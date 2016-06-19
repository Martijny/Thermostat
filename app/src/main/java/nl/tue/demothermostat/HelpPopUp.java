package nl.tue.demothermostat;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HelpPopUp extends Activity {
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_pop_up);

        final Context context = getApplicationContext();
        final CharSequence text = "Use a value between 5 and 30";
        final int duration = Toast.LENGTH_SHORT;
        ok = (Button)findViewById(R.id.button4);


        Dialog dialog = new Dialog(context);
        dialog.setCanceledOnTouchOutside(true);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .95), (int) (height * .70));

        this.getActionBar().hide();
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
