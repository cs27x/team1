package edu.vanderbilt.vandysports;

import java.util.Date;
import java.util.Vector;

public class DataModel {

    private final Vector<Event> listEvent;
    private final Vector<Team> listTeam;

    public DataModel()
    {
        this.listEvent = new Vector<Event>();
        this.listTeam = new Vector<Team>();
    }

    public Vector<Event> getAllEvents()
    {
        return listEvent;
    }

    public Vector<Team> getAllTeams()
    {
        return listTeam;
    }

    public Vector<Event> getEventsOn(Date date)
    {
        return null;
    }

    public Vector<Event> getEventsBetween(Date date1, Date date2)
    {
        return null;
    }

    public Vector<Event> getEventsFrom(Team team)
    {
        return null;
    }

    public Vector<Event> getEventsFrom(Vector<Team> teams)
    {
        return null;
    }
}
