package nl.tue.demothermostat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

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
        setTitle("New " + WeekOverview.day + " schedule");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_schedule);
        timeT = (EditText) findViewById(R.id.timeT);

        final Context context = getApplicationContext();
        final CharSequence text = "Switch needs to be in xx:xx format";
        final int duration = Toast.LENGTH_SHORT;

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.95),(int)(height*.40));

        addedB = (Button) findViewById(R.id.addedB);
        setB = (Button) findViewById(R.id.setB);
        addedB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(timeT.getText().toString().matches("\\d{2}:\\d{2}")) {
                    String time1 = timeT.getText().toString();
                    DailyOverview.arrayTime[DailyOverview.arraynr] = time1;

                    Intent intent = new Intent(view.getContext(), DailyOverview.class);
                    startActivity(intent);
                }else{
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }


        });
        setB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
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

    public void DataXD(String[] string, String time) {
        String[] sstring = string;

        String stime = time;
        sstring[DailyOverview.arraynr] = stime;
    }
}
