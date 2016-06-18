package nl.tue.demothermostat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import nl.tue.demothermostat.R;

class CustomAdapter extends ArrayAdapter<String> {
    public int mode, count;


    public CustomAdapter(Context context, String[] array) {
        super(context, R.layout.custom_row, array);
        this.mode = mode;
    }

    @Override
  public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());


        View customView = myInflater.inflate(R.layout.custom_row, parent, false);


        String singleFoodItem = getItem(position);
        TextView myText =(TextView) customView.findViewById(R.id.myText);
        ImageView imageView = (ImageView) customView.findViewById(R.id.imageView);
        myText.setText(singleFoodItem);
        String string = DailyOverview.arrayType[position];


        for (int i =0; i<10; i++){
           if (string.equals("day")){
               imageView.setImageResource(R.drawable.sun_icon);
           }else{
                imageView.setImageResource(R.drawable.moon_icon);
           }
        }

        return customView;
    }
}