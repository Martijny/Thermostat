package nl.tue.demothermostat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.thermostatapp.util.Switch;
import org.w3c.dom.Text;

import nl.tue.demothermostat.circularseekbar.CircularSeekBar;

public class settings extends Activity {

    Button homeB;
    ToggleButton vacToggle;
    TextView setWeekinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        serverTemp st = new serverTemp();

        homeB = (Button) findViewById(R.id.homeB);
        vacToggle = (ToggleButton) findViewById(R.id.vacToggle);
        setWeekinfo = (TextView) findViewById(R.id.setWeekInfo);


        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        vacToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Intent intent = new Intent(settings.this, VacationPopup.class);
                    startActivity(intent);
                } else {
                    // The toggle is disabled
                }
            }
        });

        try {
            for (int i = 0; i < st.GetSchedule("Monday").length; i++) {
                setWeekinfo.append(st.GetSchedule("Monday")[i]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.getActionBar().hide();

    }
}