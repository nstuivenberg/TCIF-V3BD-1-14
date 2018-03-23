package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class Observation {

    private String timestamp;
    private Date fuckYeah;


    public Observation() {
        this.setTimestamp("2015-01-01 01:00:00");
    }

    public void setTimestamp(String t) {
        this.timestamp = t;
        this.setDate(timestamp);
    }

    public void setDate(String timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date date = format.parse(timestamp);
            this.fuckYeah = date;
        } catch (ParseException p) {
            p.printStackTrace();
        }
    }

    public Date getFuckYeah() {
        return fuckYeah;
    }

    public String toString() {
        Calendar c = Calendar.getInstance();
        c.setTime(this.getFuckYeah());
        return "Meting om: " + c.getTime() + ". ";
    }
}
