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

public class AddingSchedule extends Activity implements AdapterView.OnItemSelectedListener {
    Button addedB;
    Button setB;
    serverTemp ST;
    EditText timeT;
    EditText switchT;
    EditText numberT;
    WeekProgram wpg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ST = new serverTemp();
        wpg = new WeekProgram();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_schedule);
        timeT = (EditText) findViewById(R.id.timeT);
        switchT = (EditText) findViewById(R.id.switchT);
        numberT = (EditText) findViewById(R.id.numberT);
        Spinner spinner = (Spinner) findViewById(R.id.planets_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.weekdays, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        addedB = (Button) findViewById(R.id.addedB);
        setB = (Button)findViewById(R.id.setB);
        addedB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Spinner spinner = (Spinner)findViewById(R.id.planets_spinner);
                final String day = spinner.getSelectedItem().toString();
                final String time1 = timeT.getText().toString();
                final String a_switch = switchT.getText().toString();
                final String numbers = numberT.getText().toString();
                int num1 = 0;
                try {
                    num1= Integer.parseInt(numbers);
                } catch(NumberFormatException nfe) {

                }
                final int num2 = num1;
                Thread t = new Thread(new Runnable() {


                    @Override
                    public void run() {
                        try {



                            //HeatingSystem.put("targetTemperature", stemp);
                    /* Uncomment the following parts to see how to work with the properties of the week program */
                            // Get the week program
                            //WeekProgram wpg1 = HeatingSystem.getWeekProgram();

                            // Set the week program to default
                            //wpg1.setDefault();

                            //wpg1.data.get("Monday").set(6, new Switch("day", true, "09:30"));
                            //wpg1.data.get(sday).set(snumber, new Switch(smode, true, stime));
                            //wpg1.data.get("Monday").set(8, new Switch("day", true, "12:00"));
                            //wpg.data.get("Monday").set(7, new Switch("day", true, "12:00"));
                            //wpg.data.get("Monday").set(8, new Switch("day", true, "18:00"));
                            //boolean duplicates = wpg.duplicates(wpg.data.get("Monday"));

                            //System.out.println("Duplicates found " + duplicates);
                            wpg.data.get(day).set(num2, new Switch(a_switch, true, time1));


                            //Upload the updated program
                            HeatingSystem.setWeekProgram(wpg);

                        } catch (Exception e) {
                            System.err.println("Error from getdata " + e);
                        }
                    }
                });
                t.start();



            }



        });
        setB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });






    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
