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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final serverTemp st = new serverTemp();

        homeB = (Button) findViewById(R.id.homeB);
        vacToggle = (ToggleButton) findViewById(R.id.vacToggle);

        try {
            if(st.getVMODE().equals("off")){
                vacToggle.setChecked(true);
            }
            else vacToggle.setChecked(false);



            homeB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        vacToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    try {
                        st.setVMode();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Intent intent = new Intent(settings.this, VacationPopup.class);
                    startActivity(intent);
                } else {
                    try {
                        st.setVMode();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // The toggle is disabled
                }
            }
        });



        this.getActionBar().hide();

    }
}