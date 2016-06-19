package nl.tue.demothermostat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import nl.tue.demothermostat.circularseekbar.CircularSeekBar;

public class ThermostatActivity extends Activity {

    double vtemp = 5;
    double csbTemp;
    int selectedButton;
    TextView temp;
    TextView currentTemp;
    TextView currentTime;
    TextView selectedTemp;
    double dayTemp;
    double nightTemp;
    Button weekB;
    Button minusB;
    Button addB;
    Button settingB;
    Button dayB;
    Button nightB;
    Button overrideTempB;
    Button setSwitchB;
    serverTemp ST;
    boolean isButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);
        ST = new serverTemp();

        weekB = (Button) findViewById(R.id.weekB);
        selectedTemp = (TextView) findViewById(R.id.selectedTemp);
        final CircularSeekBar seekbar = (CircularSeekBar) findViewById(R.id.circularSeekBar1);
        seekbar.setMax(250);


        currentTemp = (TextView) findViewById(R.id.currentTemp);
        currentTime = (TextView) findViewById(R.id.currentTime);
        temp = (TextView) findViewById(R.id.temp);
        temp.setText("" + vtemp);
        minusB = (Button) findViewById(R.id.minusB);
        setSwitchB = (Button) findViewById(R.id.setSwitchB);
        overrideTempB = (Button) findViewById(R.id.overrideTempB);
        addB = (Button) findViewById(R.id.addB);
        dayB = (Button) findViewById(R.id.dayB);
        nightB = (Button) findViewById(R.id.nightB);
        settingB = (Button) findViewById(R.id.settingB);

        this.getActionBar().hide();

        try {
            selectedTemp.setText("Day Temperature: " + ST.getDayTemp());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        weekB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    DailyOverview.day1 = ST.GetSchedule("Monday");
                    DailyOverview.day2 = ST.GetSchedule("Tuesday");
                    DailyOverview.day3 = ST.GetSchedule("Wednesday");
                    DailyOverview.day4 = ST.GetSchedule("Thursday");
                    DailyOverview.day5 = ST.GetSchedule("Friday");
                    DailyOverview.day6 = ST.GetSchedule("Saturday");
                    DailyOverview.day7 = ST.GetSchedule("Sunday");
                    DailyOverview.type1 = ST.GetDayNight("Monday");
                    DailyOverview.type2 = ST.GetDayNight("Tuesday");
                    DailyOverview.type3 = ST.GetDayNight("Wednesday");
                    DailyOverview.type5 = ST.GetDayNight("Friday");
                    DailyOverview.type6 = ST.GetDayNight("Saturday");
                    DailyOverview.type7 = ST.GetDayNight("Sunday");
                    DailyOverview.type4 = ST.GetDayNight("Thursday");
                    DailyOverview.offon1 = ST.GetOnOff("Monday");
                    DailyOverview.offon2 = ST.GetOnOff("Tuesday");
                    DailyOverview.offon3 = ST.GetOnOff("Wednesday");
                    DailyOverview.offon5 = ST.GetOnOff("Friday");
                    DailyOverview.offon7 = ST.GetOnOff("Sunday");
                    DailyOverview.offon4 = ST.GetOnOff("Thursday");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        minusB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Double.parseDouble(temp.getText().toString()) > 5) {
                    seekbar.setProgress((int) ((round(Double.parseDouble(temp.getText().toString()) - 0.1, 2)) * 10) - 50);
                }
            }
        });

        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Double.parseDouble(temp.getText().toString()) < 30) {
                    seekbar.setProgress((int) ((round(Double.parseDouble(temp.getText().toString()) + 0.1, 2)) * 10) - 50);
                }
            }
        });

        setSwitchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getSelected() == dayB.getId()) {
                    try {
                        ST.setDayTemp(temp.getText().toString());
                        selectedTemp.setText("Day Temperature: " + ST.getDayTemp());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        ST.setNightTemp(temp.getText().toString());
                        selectedTemp.setText("Night Temperature: " + ST.getNightTemp());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        overrideTempB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        dayB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected(dayB.getId());
                dayB.setBackgroundResource(R.drawable.sun_icon);
                nightB.setBackgroundResource(R.drawable.moon_icon_unselected);
                try {
                    selectedTemp.setText("Day Temperature: " + ST.getDayTemp());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        nightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected(nightB.getId());
                nightB.setBackgroundResource(R.drawable.moon_icon);
                dayB.setBackgroundResource(R.drawable.sun_icon_unselected);
                try {
                    selectedTemp.setText("Night Temperature: " + ST.getNightTemp());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        settingB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), settings.class);
                startActivity(intent);
            }
        });

        overrideTempB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ST.setTemp(temp.getText().toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        seekbar.setOnSeekBarChangeListener(new CircleSeekBarListener());

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    currentTime.setText("Time: " + ST.getTime() + " ("+ ST.getDay()+")");
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();

        Thread t1 = new Thread() {

            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1500);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    currentTemp.setText("Temperature: " + ST.getData());
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t1.start();
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public void setSelected(int button) {
        selectedButton = button;
    }

    public int getSelected() {
        return selectedButton;
    }

    public class CircleSeekBarListener implements CircularSeekBar.OnCircularSeekBarChangeListener {
        @Override
        public void onProgressChanged(CircularSeekBar circularSeekBar, int progress, boolean fromUser) {
            Double tempTemp = 5.0;
            csbTemp = round(((progress * 0.1) + tempTemp), 2);
            temp.setText("" + csbTemp);
        }


        @Override
        public void onStopTrackingTouch(CircularSeekBar seekBar) {

        }

        @Override
        public void onStartTrackingTouch(CircularSeekBar seekBar) {

        }
    }
}

