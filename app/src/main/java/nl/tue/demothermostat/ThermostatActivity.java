package nl.tue.demothermostat;

import nl.tue.demothermostat.circularseekbar.CircularSeekBar.OnCircularSeekBarChangeListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import nl.tue.demothermostat.serverTemp;

import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.Switch;
import org.thermostatapp.util.WeekProgram;

import nl.tue.demothermostat.circularseekbar.CircularSeekBar;

public class ThermostatActivity extends Activity {

    double vtemp = 5;
    TextView temp;
    TextView setTemp;
    TextView dDayTemp;
    TextView dNightTemp;
    String setSwitch;
    double dayTemp;
    double nightTemp;
    serverTemp ST;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);
        ST = new serverTemp();

        dDayTemp = (TextView) findViewById(R.id.dDayTemp);
        dNightTemp = (TextView) findViewById(R.id.dNightTemp);
        final CircularSeekBar seekbar = (CircularSeekBar) findViewById(R.id.circularSeekBar1);
        seekbar.setMax(250);

        temp = (TextView) findViewById(R.id.temp);
        Button sTemp = (Button) findViewById(R.id.sTemp);


        sTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ST.setTemp(""+vtemp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    dDayTemp.setText(ST.getData());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        seekbar.setOnSeekBarChangeListener(new CircleSeekBarListener());

    }

    public class CircleSeekBarListener implements CircularSeekBar.OnCircularSeekBarChangeListener {
        @Override
        public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
            vtemp = (progress * 0.1);
            temp.setText(String.format("%.1f", vtemp));
        }

        @Override
        public void onStopTrackingTouch(CircularSeekBar seekBar) {

        }

        @Override
        public void onStartTrackingTouch(CircularSeekBar seekBar) {

        }
    }
}
