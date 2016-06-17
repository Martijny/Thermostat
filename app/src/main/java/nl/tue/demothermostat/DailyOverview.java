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

    String[] array;
    serverTemp ST;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_overview);
        ST = new serverTemp();
        try {
            array = ST.GetSchedule("Monday");
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
