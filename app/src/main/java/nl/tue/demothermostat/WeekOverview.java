package nl.tue.demothermostat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.lang.reflect.Array;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_overview);

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