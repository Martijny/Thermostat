package nl.tue.demothermostat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;


public class DailyOverview extends Activity {
    Button backB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_overview);
        backB = (Button) findViewById(R.id.backB);
        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),WeekOverview.class);
                startActivity(intent);
            }
        });
    }


}
