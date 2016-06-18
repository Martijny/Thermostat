package nl.tue.demothermostat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class VacationPopup extends Activity {

    Button setVacTempB;
    EditText editTemp;
    serverTemp ST = new serverTemp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_popup);
        this.getActionBar().hide();

        final Context context = getApplicationContext();
        final CharSequence text = "Use a value between 5 and 30";
        final int duration = Toast.LENGTH_SHORT;

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
                String empty = "";
                if(!editTemp.getText().toString().equals("") && Double.parseDouble(editTemp.getText().toString()) >= 5 && Double.parseDouble(editTemp.getText().toString()) <= 30){
                    try {
                        settings.setWeekinfo.setText("Vacation Mode is ON");
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
                }else{
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
}
