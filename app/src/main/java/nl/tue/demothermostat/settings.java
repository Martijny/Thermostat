package nl.tue.demothermostat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.Switch;
import org.thermostatapp.util.WeekProgram;
import org.w3c.dom.Text;

import nl.tue.demothermostat.circularseekbar.CircularSeekBar;

public class settings extends Activity {

    Button homeB;
    Button weekB;
    public static ToggleButton vacToggle;
    public static TextView setWeekinfo;
    serverTemp ST;
    Button reset;
    WeekProgram wpg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ST = new serverTemp();
        wpg = new WeekProgram();

        homeB = (Button) findViewById(R.id.homeB);
        weekB = (Button) findViewById(R.id.weekB);
        reset = (Button) findViewById(R.id.button2);
        vacToggle = (ToggleButton) findViewById(R.id.vacToggle);
        setWeekinfo = (TextView) findViewById(R.id.setWeekInfo);


        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ThermostatActivity.class);
                startActivity(intent);
            }
        });

        weekB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        try {
            if(ST.getWeekProgramState().equals("off")){
                vacToggle.setChecked(true);
                setWeekinfo.setText("Vacation Mode is ON");
            }else{
                vacToggle.setChecked(false);
                setWeekinfo.setText("Vacation Mode is OFF");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        vacToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent intent = new Intent(settings.this, VacationPopup.class);
                    startActivity(intent);
                } else {
                    try {
                        ST.setWeekProgramState("on");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    setWeekinfo.setText("Vacation Mode is OFF");
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ST.getWeekProgram(wpg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Context context = getApplicationContext();
                CharSequence text = "Weekly program reset";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        this.getActionBar().hide();

    }
}