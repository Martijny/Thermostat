package nl.tue.demothermostat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by nstash on 06/05/15.
 */
public class WeekOverview extends Activity {

    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_overview);

        button2 = (Button)findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hexVal = "0000ff";
                System.out.println(Integer.parseInt(hexVal, 16));
                button2.setBackgroundColor(0xFFFF0000);
            }});
    }
}