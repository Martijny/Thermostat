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
    Button minusB;
    Button addB;
    String setSwitch;
    double dayTemp;
    double nightTemp;
    serverTemp ST;
    boolean isButton;

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
        minusB = (Button)findViewById(R.id.minusB);
        addB = (Button)findViewById(R.id.addB);

        weekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
        }});

        minusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButton = true;
                vtemp = round(Double.parseDouble(temp.getText().toString())-0.1,2);
                temp.setText(""+vtemp);
                seekbar.setProgress((int)(Double.parseDouble(temp.getText().toString())*10)-50);
        }});

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isButton = true;
                vtemp = round(Double.parseDouble(temp.getText().toString())+0.1,2);
                temp.setText(""+vtemp);
                seekbar.setProgress((int) (Double.parseDouble(temp.getText().toString())*10)-50);
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
            if(!isButton) {
                Double tempTemp = 5.0;
                csbTemp = round(((progress * 0.1)+tempTemp), 2);
                temp.setText("" + csbTemp);
            }
            isButton = false;
        }


        @Override
        public void onStopTrackingTouch(CircularSeekBar seekBar) {

        }

        @Override
        public void onStartTrackingTouch(CircularSeekBar seekBar) {

        }
    }
}

