package nl.tue.demothermostat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.Switch;
import org.thermostatapp.util.WeekProgram;

import java.lang.reflect.Array;
import java.util.Arrays;

public class AddingSchedule extends Activity implements AdapterView.OnItemSelectedListener {
    Button addedB;
    Button setB;
    serverTemp ST;
    EditText timeT;
    EditText switchT;
    EditText numberT;
    WeekProgram wpg;
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
    String s0;
    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    String s6;
    String s7;
    String s8;
    String s9;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ST = new serverTemp();
        wpg = new WeekProgram();
        setTitle("New "+WeekOverview.day+" schedule");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_schedule);
        timeT = (EditText) findViewById(R.id.timeT);



        addedB = (Button) findViewById(R.id.addedB);
        setB = (Button)findViewById(R.id.setB);
        addedB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String time1 = timeT.getText().toString();
                if(WeekOverview.day.equals("Monday")){
                    DataXD(DailyOverview.day1,time1);
                }
                else if(WeekOverview.day.equals("Tuesday")){
                    DataXD(DailyOverview.day2,time1);
                }
                else if (WeekOverview.day.equals("Wednesday")){
                    DataXD(DailyOverview.day3,time1);
                }
                else if(WeekOverview.day.equals("Thursday")){
                    DataXD(DailyOverview.day4,time1);
                }
                else if(WeekOverview.day.equals("Friday")){
                    DataXD(DailyOverview.day5,time1);
                }
                else if(WeekOverview.day.equals("Saturday")){
                    DataXD(DailyOverview.day6,time1);
                }
                else if(WeekOverview.day.equals("Sunday")){
                    DataXD(DailyOverview.day7,time1);
                }



                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);







            }



        });
        setB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {





                Intent intent = new Intent(view.getContext(),DailyOverview.class);
                startActivity(intent);




            }
        });






    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void DataXD(String[] string, String time){
        String[] sstring=string;

        String stime = time;
        sstring[DailyOverview.arraynr] = stime;



    }
}
