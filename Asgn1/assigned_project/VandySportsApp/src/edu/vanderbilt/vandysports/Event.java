package edu.vanderbilt.vandysports;

java.util.Date;

public class Event {

    public final Team mTeam;
    public final Date date;
    public final String event;
    public final String location;
    public final String time;

    public Event(Team team, Date date, String event, String location, String time) {
        mTeam = team;
        this.date = date;
        this.event = event;
        this.location = location;
        this.time = time;
    }
}
