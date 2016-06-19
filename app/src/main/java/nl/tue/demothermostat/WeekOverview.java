package nl.tue.demothermostat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    public static String day;
    Button mondayB;
    Button tuesdayB;
    Button wednesdayB;
    Button thursdayB;
    Button fridayB;
    Button saturdayB;
    Button sundayB;
    Button[] buttonArray;
    Button addB;
    Button backB;
    Button homeB;
    Button settingsB;
    serverTemp ST;
    WeekProgram wpg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_overview);
        ST = new serverTemp();

        wpg = new WeekProgram();


        mondayB = (Button) findViewById(R.id.mondayB);
        tuesdayB = (Button) findViewById(R.id.tuesdayB);
        wednesdayB = (Button) findViewById(R.id.wednesdayB);
        thursdayB = (Button) findViewById(R.id.thursdayB);
        fridayB = (Button) findViewById(R.id.fridayB);
        saturdayB = (Button) findViewById(R.id.saturdayB);
        sundayB = (Button) findViewById(R.id.sundayB);
        addB = (Button) findViewById(R.id.addB);
        backB = (Button) findViewById(R.id.backB);
        homeB = (Button) findViewById(R.id.homeB);
        settingsB = (Button) findViewById(R.id.settingsB);

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
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
                startActivity(intent);

                day = "Monday";
                DailyOverview.arrayTime = DailyOverview.day1;
                DailyOverview.arrayType = DailyOverview.type1;
                DailyOverview.arrayMode = DailyOverview.offon1;

            }
        });

        tuesdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
                startActivity(intent);


                day = "Tuesday";
                DailyOverview.arrayTime = DailyOverview.day2;
                DailyOverview.arrayType = DailyOverview.type2;
                DailyOverview.arrayMode = DailyOverview.offon2;
            }
        });

        wednesdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
                startActivity(intent);
                day = "Wednesday";
                DailyOverview.arrayTime = DailyOverview.day3;
                DailyOverview.arrayType = DailyOverview.type3;
                DailyOverview.arrayMode = DailyOverview.offon3;

            }
        });

        thursdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
                startActivity(intent);
                day = "Thursday";
                DailyOverview.arrayTime = DailyOverview.day4;
                DailyOverview.arrayType = DailyOverview.type4;
                DailyOverview.arrayMode = DailyOverview.offon4;
            }
        });

        fridayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
                startActivity(intent);
                day = "Friday";
                DailyOverview.arrayTime = DailyOverview.day5;
                DailyOverview.arrayType = DailyOverview.type5;
                DailyOverview.arrayMode = DailyOverview.offon5;

            }
        });

        saturdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
                startActivity(intent);
                day = "Saturday";
                DailyOverview.arrayTime = DailyOverview.day6;
                DailyOverview.arrayType = DailyOverview.type6;
                DailyOverview.arrayMode = DailyOverview.offon6;
            }
        });

        sundayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DailyOverview.class);
                startActivity(intent);
                day = "Sunday";
                DailyOverview.arrayTime = DailyOverview.day7;
                DailyOverview.arrayType = DailyOverview.type7;
                DailyOverview.arrayMode = DailyOverview.offon7;
            }
        });

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Thread s = new Thread() {

                    public void run() {
                        try {
                            wpg = HeatingSystem.getWeekProgram();
                            // Set the week program to default
                            for (int i = 0; i < 10; i++) {
                                wpg.data.get("Monday").set(i, new Switch(DailyOverview.type1[i], DailyOverview.offon1[i], DailyOverview.day1[i]));
                                wpg.data.get("Tuesday").set(i, new Switch(DailyOverview.type2[i], DailyOverview.offon2[i], DailyOverview.day2[i]));
                                wpg.data.get("Wednesday").set(i, new Switch(DailyOverview.type3[i], DailyOverview.offon3[i], DailyOverview.day3[i]));
                                wpg.data.get("Thursday").set(i, new Switch(DailyOverview.type4[i], DailyOverview.offon4[i], DailyOverview.day4[i]));
                                wpg.data.get("Friday").set(i, new Switch(DailyOverview.type5[i], DailyOverview.offon5[i], DailyOverview.day5[i]));
                                wpg.data.get("Saturday").set(i, new Switch(DailyOverview.type6[i], DailyOverview.offon6[i], DailyOverview.day6[i]));
                                wpg.data.get("Sunday").set(i, new Switch(DailyOverview.type7[i], DailyOverview.offon7[i], DailyOverview.day7[i]));

                            }

//
                            boolean duplicates = wpg.duplicates(wpg.data.get("Monday"));
                            System.out.println("Duplicates found " + duplicates);
                             duplicates = wpg.duplicates(wpg.data.get("Tuesday"));
                            System.out.println("Duplicates found " + duplicates);
                            duplicates = wpg.duplicates(wpg.data.get("Wednesday"));
                            System.out.println("Duplicates found " + duplicates);
                            duplicates = wpg.duplicates(wpg.data.get("Thursday"));
                            System.out.println("Duplicates found " + duplicates);
                            duplicates = wpg.duplicates(wpg.data.get("Friday"));
                            System.out.println("Duplicates found " + duplicates);
                            duplicates = wpg.duplicates(wpg.data.get("Saturday"));
                            System.out.println("Duplicates found " + duplicates);
                            duplicates = wpg.duplicates(wpg.data.get("Sunday"));
                            System.out.println("Duplicates found " + duplicates);

                            //Upload the updated program
                            HeatingSystem.setWeekProgram(wpg);
                            DailyOverview.day1 = ST.GetSchedule("Monday");
                            DailyOverview.day2 = ST.GetSchedule("Tuesday");
                            DailyOverview.day3 = ST.GetSchedule("Wednesday");
                            DailyOverview.day4= ST.GetSchedule("Thursday");
                            DailyOverview.day5 = ST.GetSchedule("Friday");
                            DailyOverview.day6 = ST.GetSchedule("Saturday");
                            DailyOverview.day7 = ST.GetSchedule("Sunday");
                            DailyOverview.type1 = ST.GetDayNight("Monday");
                            DailyOverview.type2 = ST.GetDayNight("Tuesday");
                            DailyOverview.type3= ST.GetDayNight("Wednesday");
                            DailyOverview.type5 = ST.GetDayNight("Friday");
                            DailyOverview.type6 = ST.GetDayNight("Saturday");
                            DailyOverview.type7 = ST.GetDayNight("Sunday");
                            DailyOverview.type4 = ST.GetDayNight("Thursday");
                            DailyOverview.offon1 = ST.GetOnOff("Monday");
                            DailyOverview.offon2 = ST.GetOnOff("Tuesday");
                            DailyOverview.offon3= ST.GetOnOff("Wednesday");
                            DailyOverview.offon5 = ST.GetOnOff("Friday");
                            DailyOverview.offon6 = ST.GetOnOff("Saturday");
                            DailyOverview.offon7 = ST.GetOnOff("Sunday");
                            DailyOverview.offon4 = ST.GetOnOff("Thursday");


                        } catch (Exception e) {
                            System.err.print("Errorrrrrrr");
                        }
                    }
                };
                s.start();

                Context context = getApplicationContext();
                CharSequence text = "New weekly schedule added to the server";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        homeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ThermostatActivity.class);
                startActivity(intent);
            }
        });

        settingsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), settings.class);
                startActivity(intent);
            }
        });
    }


}