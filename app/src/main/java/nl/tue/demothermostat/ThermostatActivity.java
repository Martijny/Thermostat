package nl.tue.demothermostat;

import nl.tue.demothermostat.circularseekbar.CircularSeekBar.OnCircularSeekBarChangeListener;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
    double tits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);

        ImageView bleft = (ImageView)findViewById(R.id.bleft);
        ImageView bright = (ImageView)findViewById(R.id.bright);
        setTemp = (TextView)findViewById(R.id.setTemp);
        dDayTemp = (TextView)findViewById(R.id.dDayTemp);
        dNightTemp = (TextView)findViewById(R.id.dNightTemp);
        final CircularSeekBar seekbar = (CircularSeekBar) findViewById(R.id.circularSeekBar1);
        seekbar.setMax(250);

        ImageView bPlus = (ImageView)findViewById(R.id.bPlus);
        bPlus.setImageResource(R.drawable.add_button);
        ImageView bMinus = (ImageView)findViewById(R.id.bMinus);
        temp = (TextView)findViewById(R.id.temp);
        Button weekOverview = (Button)findViewById(R.id.week_overview);
        Button sTemp = (Button)findViewById(R.id.sTemp);

        weekOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button testingWS = (Button)findViewById(R.id.testing_ws);

        testingWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TestingWS.class);
                startActivity(intent);
            }
        });

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vtemp = (Double.parseDouble(temp.getText().toString())+0.1);
                temp.setText(String.format("%.1f", vtemp));
                seekbar.setProgress((int) (vtemp * 10));
            }
        });
        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vtemp = (Double.parseDouble(temp.getText().toString())-0.1);
                temp.setText(String.format( "%.1f", vtemp ));
                seekbar.setProgress((int)(vtemp*10));
            }
        });
        bleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(setTemp.getText().equals("Day")){
                    setTemp.setText("Night");
                    setSwitch = "Night";
                }else{
                    setTemp.setText("Day");
                    setSwitch = "Day";
                }
            }
        });
        bright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(setTemp.getText().equals("Day")){
                    setTemp.setText("Night");
                    setSwitch = "Night";
                }else{
                    setTemp.setText("Day");
                    setSwitch = "Day";
                }
            }
        });
        sTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(setTemp.getText().equals("Day")) {
                    dayTemp = Double.parseDouble(temp.getText().toString());
                    dDayTemp.setText(""+dayTemp);
                }else if(setTemp.getText().equals("Night")){
                    nightTemp = Double.parseDouble(temp.getText().toString());
                    dNightTemp.setText(""+nightTemp);
                }
            }
        });
        seekbar.setOnSeekBarChangeListener(new CircleSeekBarListener());

    }

    public class CircleSeekBarListener implements CircularSeekBar.OnCircularSeekBarChangeListener {
        @Override
        public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
            vtemp = (progress*0.1);
            temp.setText(String.format( "%.1f", vtemp ));
        }

        @Override
        public void onStopTrackingTouch(CircularSeekBar seekBar) {

        }

        @Override
        public void onStartTrackingTouch(CircularSeekBar seekBar) {

        }
    }
}
