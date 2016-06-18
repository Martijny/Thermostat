package nl.tue.demothermostat;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class VacationPopup extends Activity {

    Button setVacTempB;
    EditText editTemp;
    serverTemp ST = new serverTemp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_popup);
        this.getActionBar().hide();

        setVacTempB = (Button)findViewById(R.id.setVacTempB);
        editTemp = (EditText)findViewById(R.id.editTemp);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.95),(int)(height*.15));

        setVacTempB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Double.parseDouble(editTemp.getText().toString()) >= 5 && Double.parseDouble(editTemp.getText().toString()) <= 30){
                    try {
                        ST.setWeekProgramState("off");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        ST.setTemp(editTemp.getText().toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
            }
        });
    }
}
