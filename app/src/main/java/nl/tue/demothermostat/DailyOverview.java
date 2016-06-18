package nl.tue.demothermostat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.Switch;
import org.thermostatapp.util.WeekProgram;


public class DailyOverview extends Activity {
    Button backB;
    String day;
    public static String[] arrayTime;
    public static String[] arrayType;
    String[] arrayDay;
    public static int[] arrayNr;
    serverTemp ST;
    Button addB;
    public static int arraynr;
    WeekProgram wpg;
    public static String[] day1;
    public static String[] day2;
    public static String[] day3;
    public static String[] day4;
    public static String[] day5;
    public static String[] day6;
    public static String[] day7;
    public static String[] type1;
    public static String[] type2;
    public static String[] type3;
    public static String[] type4;
    public static String[] type5;
    public static String[] type6;
    public static String[] type7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_overview);
        setTitle(WeekOverview.day);
        ST = new serverTemp();
        wpg= new WeekProgram();
        day=WeekOverview.day;
        ListAdapter myAdapter = new CustomAdapter(this,arrayTime);
        ListView dayList = (ListView)findViewById(R.id.listView);
        dayList.setAdapter(myAdapter);




        backB = (Button) findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(day.equals("Monday")){
                    day1=arrayTime;
                }
                else if(day.equals("Tuesday")){
                    day2=arrayTime;
                }
                else if(day.equals("Wednesday")){
                    day3=arrayTime;
                }
                else if(day.equals("Thursday")){
                    day4=arrayTime;
                }
                else if(day.equals("Friday")){
                    day5=arrayTime;
                }
                else if(day.equals("Saturday")){
                    day6=arrayTime;
                }
                else if(day.equals("Sunday")){
                    day7=arrayTime;
                }
                Intent intent = new Intent(view.getContext(),WeekOverview.class);
                startActivity(intent);
            }
        });



        dayList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                arraynr = position;
                Intent intent = new Intent(view.getContext(),AddingSchedule.class);
                startActivity(intent);

            }
        });

    }


}
