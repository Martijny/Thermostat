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
    EditText vacTemp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_popup);
        this.getActionBar().hide();

        setVacTempB = (Button)findViewById(R.id.setVacTempB);
        vacTemp = (EditText)findViewById(R.id.editText);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;
        final serverTemp st=new serverTemp();
        getWindow().setLayout((int)(width*.95),(int)(height*.15));

        setVacTempB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String s = vacTemp.getText().toString();
                    st.setTemp(s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(view.getContext(), settings.class);
                startActivity(intent);

            }
        });
    }
}
