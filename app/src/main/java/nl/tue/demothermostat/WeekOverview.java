package nl.tue.demothermostat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
                mondayB.setBackgroundResource(R.drawable.roundedbuttonclicked);
                for (int i = 0; i < buttonArray.length; i++) {
                    if (i != 0) {
                        buttonArray[i].setBackgroundResource(R.drawable.roundedbutton);
                    }
                }
            }
        });

        tuesdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tuesdayB.setBackgroundResource(R.drawable.roundedbuttonclicked);
                for (int i = 0; i < buttonArray.length; i++) {
                    if (i != 1) {
                        buttonArray[i].setBackgroundResource(R.drawable.roundedbutton);
                    }
                }
            }
        });

        wednesdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wednesdayB.setBackgroundResource(R.drawable.roundedbuttonclicked);
                for (int i = 0; i < buttonArray.length; i++) {
                    if (i != 2) {
                        buttonArray[i].setBackgroundResource(R.drawable.roundedbutton);
                    }
                }
            }
        });

        thursdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thursdayB.setBackgroundResource(R.drawable.roundedbuttonclicked);
                for (int i = 0; i < buttonArray.length; i++) {
                    if (i != 3) {
                        buttonArray[i].setBackgroundResource(R.drawable.roundedbutton);
                    }
                }
            }
        });

        fridayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fridayB.setBackgroundResource(R.drawable.roundedbuttonclicked);
                for (int i = 0; i < buttonArray.length; i++) {
                    if (i != 4) {
                        buttonArray[i].setBackgroundResource(R.drawable.roundedbutton);
                    }
                }
            }
        });

        saturdayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saturdayB.setBackgroundResource(R.drawable.roundedbuttonclicked);
                for (int i = 0; i < buttonArray.length; i++) {
                    if (i != 5) {
                        buttonArray[i].setBackgroundResource(R.drawable.roundedbutton);
                    }
                }
            }
        });

        sundayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sundayB.setBackgroundResource(R.drawable.roundedbuttonclicked);
                for (int i = 0; i < buttonArray.length; i++) {
                    if (i != 6) {
                        buttonArray[i].setBackgroundResource(R.drawable.roundedbutton);
                    }
                }
            }
        });
    }
}