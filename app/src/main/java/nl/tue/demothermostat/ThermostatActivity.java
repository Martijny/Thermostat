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
    double csbTemp;
    TextView temp;
    TextView setTemp;
    TextView dDayTemp;
    TextView dNightTemp;
    Button weekButton;
    String setSwitch;
    double dayTemp;
    double nightTemp;
    serverTemp ST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);
        ST = new serverTemp();

        dDayTemp = (TextView)findViewById(R.id.dDayTemp);
        dNightTemp = (TextView)findViewById(R.id.dNightTemp);
        weekButton = (Button)findViewById(R.id.weekB);
        final CircularSeekBar seekbar = (CircularSeekBar) findViewById(R.id.circularSeekBar1);
        seekbar.setMax(250);

        temp = (TextView)findViewById(R.id.temp);
        temp.setText("" + vtemp);
        Button sTemp = (Button)findViewById(R.id.sTemp);

        weekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
        }});

        sTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ST.setTemp(temp.getText().toString());
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

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public class CircleSeekBarListener implements CircularSeekBar.OnCircularSeekBarChangeListener {
        @Override
        public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
            csbTemp = round(((progress*0.1) + vtemp),2);
            temp.setText(""+csbTemp);
        }


        @Override
        public void onStopTrackingTouch(CircularSeekBar seekBar) {

        }

        @Override
        public void onStartTrackingTouch(CircularSeekBar seekBar) {

        }
    }
}

