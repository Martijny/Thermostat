package nl.tue.demothermostat;

import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.Switch;
import org.thermostatapp.util.WeekProgram;

public class serverTemp {
    String currentTemperature;
    String dayTemp;
    String nightTemperature;
    String time;
    String day;
    String weekProgramState;
    Switch switch1;
    String weeklystate;

    public String getData() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/51";
                    HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";
                    currentTemperature = HeatingSystem.get("currentTemperature");
//                    day = HeatingSystem.get("day");
//                    time = HeatingSystem.get("time");
//                    targetTemperature = HeatingSystem.get("targetTemperature");
//                    dayTemperature = HeatingSystem.get("dayTemperature");
//                    nightTemperature = HeatingSystem.get("nightTemperature");
//                    weekProgramState = HeatingSystem.get("weekProgramState");

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
        return currentTemperature;
    }

    public String getWeekProgramState() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    weekProgramState = HeatingSystem.get("weekProgramState");
                } catch (Exception e) {
                    System.err.println("Error from weekProgramState " + e);
                }
            }
        });
        t.start();
        t.join();
        return weekProgramState;
    }

    public void setWeekProgramState(String input) throws InterruptedException {
        final String state;
        state = input;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.put("weekProgramState", state);
                } catch (Exception e) {
                    System.err.println("Error from weekProgramState " + e);
                }
            }
        });
        t.start();
        t.join();
    }

    public void setTemp(final String temp) throws InterruptedException {
        final String stemp;
        stemp = temp;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.put("targetTemperature", stemp);
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
    }
    public void setDayTemp(final String temp) throws InterruptedException {
        final String stemp;
        stemp = temp;
        Thread st = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.put("dayTemperature", stemp);
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        st.start();
        st.join();
    }
    public String getDayTemp() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/51";
                    HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";
                    dayTemp = HeatingSystem.get("dayTemperature");
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
        return dayTemp;
    }
    public void setNightTemp(final String temp) throws InterruptedException {
        final String stemp;
        stemp = temp;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.put("nightTemperature", stemp);
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
    }
    public String getNightTemp() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/51";
                    HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";
                    nightTemperature = HeatingSystem.get("nightTemperature");
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
        return nightTemperature;
    }


    public String getTime() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    time = HeatingSystem.get("time");
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
        return time;
    }
    public String getDay() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    day = HeatingSystem.get("day");
                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
        return day;
    }

    public void getWeekProgram(final WeekProgram wpg, final String day) throws InterruptedException {
        final String sday;
        sday=day;
        final WeekProgram wpg1;
        wpg1=wpg;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //HeatingSystem.put("targetTemperature", stemp);
                    /* Uncomment the following parts to see how to work with the properties of the week program */
                    // Get the week program
                    HeatingSystem.getWeekProgram().data.get(sday);

                    // Set the week program to default
                    //wpg1.setDefault();

                   //wpg1.data.get("Monday").set(6, new Switch("day", true, "09:30"));
                    //wpg1.data.get(sday).set(snumber, new Switch(smode, true, stime));
                    //wpg1.data.get("Monday").set(8, new Switch("day", true, "12:00"));
                    //wpg.data.get("Monday").set(7, new Switch("day", true, "12:00"));
                    //wpg.data.get("Monday").set(8, new Switch("day", true, "18:00"));
                    //boolean duplicates = wpg1.duplicates(wpg1.data.get("Monday"));

                    //System.out.println("Duplicates found " + duplicates);

                    //Upload the updated program
                    //HeatingSystem.setWeekProgram(wpg1);

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
    }


    public String[] GetSchedule(String day) throws InterruptedException {
        final String[] switches = new String[10];
        final String days = day;


        Thread t = new Thread() {

            public void run() {
                try {
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    for (int i = 0; i < 10; i++) {
                        switch1 = wpg.data.get(days).get(i);
                        switches[i] = switch1.getTime();

                    }

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        };
        t.start();
        t.join();
        return switches;
    }

    public int[] GetNumber(String day) throws InterruptedException {
        final int[] switches = new int[10];
        final String days = day;


        Thread t = new Thread() {

            public void run() {
                try {
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    for (int i = 0; i < 10; i++) {
                        switch1 = wpg.data.get(days).get(i);
                        switches[i] = switch1.getTime_Int();

                    }

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        };
        t.start();
        t.join();
        return switches;
    }
    public String[] GetDayNight(String day) throws InterruptedException {
        final String[] switches = new String[10];
        final String days = day;


        Thread t = new Thread() {

            public void run() {
                try {
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    for (int i = 0; i < 10; i++) {
                        switch1 = wpg.data.get(days).get(i);
                        switches[i] = switch1.getType();

                    }

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        };
        t.start();
        t.join();
        return switches;
    }
    public void setVMode() throws InterruptedException {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    weeklystate = HeatingSystem.get("weekProgramState");
                    if (weeklystate.equals("on")) {
                        weeklystate = "off";
                        HeatingSystem.put("weekProgramState", weeklystate);
                    }else{
                        weeklystate = "on";
                        HeatingSystem.put("weekProgramState", weeklystate);
                    }

                    weeklystate = HeatingSystem.get("weekProgramState");

                } catch (Exception e) {
                }
            }
        });
        t.start();
        t.join();
    }
    public String getVMODE() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                     weeklystate = HeatingSystem.get("weekProgramState");

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
        return weeklystate;

    }
    public boolean[] GetOnOff(String day) throws InterruptedException {
        final boolean[] switches = new boolean[10];
        final String days = day;


        Thread t = new Thread() {

            public void run() {
                try {
                    WeekProgram wpg = HeatingSystem.getWeekProgram();
                    for (int i = 0; i < 10; i++) {
                        switch1 = wpg.data.get(days).get(i);
                        switches[i] = switch1.getState();

                    }

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        };
        t.start();
        t.join();
        return switches;
    }

}
