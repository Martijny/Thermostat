package nl.tue.demothermostat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;


public class DailyOverview extends Activity {
    Button backB;
    String day;
    String[] array;
    serverTemp ST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_overview);
        setTitle(WeekOverview.day);
        ST = new serverTemp();
        day=WeekOverview.day;
        try {
            array = ST.GetSchedule(day);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ListAdapter myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,array);
        ListView dayList = (ListView)findViewById(R.id.listView);
        dayList.setAdapter(myAdapter);

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
