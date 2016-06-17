package nl.tue.demothermostat;

import org.thermostatapp.util.HeatingSystem;
import org.thermostatapp.util.Switch;
import org.thermostatapp.util.WeekProgram;

public class serverTemp {
    String currentTemperature;
    String time;

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

    public void setTemp(final String temp) throws InterruptedException {
        final String stemp;
        stemp = temp;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.put("targetTemperature", stemp);
                    /* Uncomment the following parts to see how to work with the properties of the week program */
                    // Get the week program
                    //WeekProgram wpg = HeatingSystem.getWeekProgram();

                    // Set the week program to default
                    //wpg.setDefault();

                    //wpg.data.get("Monday").set(5, new Switch("day", true, "07:30"));
                    //wpg.data.get("Monday").set(1, new Switch("night", true, "08:30"));
                    //wpg.data.get("Monday").set(6, new Switch("day", true, "18:00"));
                    //wpg.data.get("Monday").set(7, new Switch("day", true, "12:00"));
                    //wpg.data.get("Monday").set(8, new Switch("day", true, "18:00"));
                    //boolean duplicates = wpg.duplicates(wpg.data.get("Monday"));
                    //System.out.println("Duplicates found " + duplicates);

                    //Upload the updated program
                    //HeatingSystem.setWeekProgram(wpg);

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
    }
    public String getTime() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/51";
                    HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";
//                    currentTemperature = HeatingSystem.get("currentTemperature");
//                    day = HeatingSystem.get("day");
                    time = HeatingSystem.get("time");
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
        return time;
    }
    public void setWeekProgram(WeekProgram wpg) throws InterruptedException {

        WeekProgram wpg1;
        wpg1=wpg;

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //HeatingSystem.put("targetTemperature", stemp);
                    /* Uncomment the following parts to see how to work with the properties of the week program */
                    // Get the week program
                    WeekProgram wpg1 = HeatingSystem.getWeekProgram();

                    // Set the week program to default
                    wpg1.setDefault();

                   //wpg1.data.get("Monday").set(6, new Switch("day", true, "09:30"));
                    //wpg1.data.get(sday).set(snumber, new Switch(smode, true, stime));
                    //wpg1.data.get("Monday").set(8, new Switch("day", true, "12:00"));
                    //wpg.data.get("Monday").set(7, new Switch("day", true, "12:00"));
                    //wpg.data.get("Monday").set(8, new Switch("day", true, "18:00"));
                    //boolean duplicates = wpg1.duplicates(wpg1.data.get("Monday"));

                    //System.out.println("Duplicates found " + duplicates);

                    //Upload the updated program
                    HeatingSystem.setWeekProgram(wpg1);

                } catch (Exception e) {
                    System.err.println("Error from getdata " + e);
                }
            }
        });
        t.start();
        t.join();
    }
}
