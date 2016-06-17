package nl.tue.demothermostat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.thermostatapp.util.CorruptWeekProgramException;
import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.Switch;
import org.thermostatapp.util.WeekProgram;

import java.lang.reflect.Array;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by nstash on 06/05/15.
 */
public class WeekOverview extends Activity {

    Button mondayB;
    Button tuesdayB;
    Button wednesdayB;
    Button thursdayB;
    Button fridayB;
    Button saturdayB;
    Button sundayB;
    Button[] buttonArray;
    Button addB;
    private ListView scheduleList;
    private ArrayAdapter<String> listAdapter ;
    Switch switch0;
    Switch switch1;
    Switch switch2;
    Switch switch3;
    Switch switch4;
    Switch switch5;
    Switch switch6;
    Switch switch7;
    Switch switch8;
    Switch switch9;
    String night0;
    String night1;
    String night2;
    String night3;
    String night4;
    String day5;
    String day6;
    String day7;
    String day8;
    String day9;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_overview);
        textView4= (TextView)findViewById(R.id.textView4);
        textView5= (TextView)findViewById(R.id.textView5);
        textView6= (TextView)findViewById(R.id.textView6);
        textView7= (TextView)findViewById(R.id.textView7);
        textView8= (TextView)findViewById(R.id.textView8);
        textView9= (TextView)findViewById(R.id.textView9);
        textView10= (TextView)findViewById(R.id.textView10);
        textView11= (TextView)findViewById(R.id.textView11);
        textView12= (TextView)findViewById(R.id.textView12);
        textView13= (TextView)findViewById(R.id.textView13);


        mondayB = (Button) findViewById(R.id.mondayB);
        tuesdayB = (Button) findViewById(R.id.tuesdayB);
        wednesdayB = (Button) findViewById(R.id.wednesdayB);
        thursdayB = (Button) findViewById(R.id.thursdayB);
        fridayB = (Button) findViewById(R.id.fridayB);
        saturdayB = (Button) findViewById(R.id.saturdayB);
        sundayB = (Button) findViewById(R.id.sundayB);
        addB = (Button) findViewById(R.id.addB);

        buttonArray = new Button[7];
        buttonArray[0] = mondayB;
        buttonArray[1] = tuesdayB;
        buttonArray[2] = wednesdayB;
        buttonArray[3] = thursdayB;
        buttonArray[4] = fridayB;
        buttonArray[5] = saturdayB;
        buttonArray[6] = sundayB;

        this.getActionBar().hide();



        mondayB.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {
                                           Intent intent = new Intent(view.getContext(),DailyOverview.class);
                                           startActivity(intent);
                                       }
                                   });

        tuesdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);

            }
        });

        wednesdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);

            }
        });

        thursdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);

            }
        });

        fridayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);

            }
        });

        saturdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);

            }
        });

        sundayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);

            }
        });

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),AddingSchedule.class);
                startActivity(intent);

            }
        });
    }



}