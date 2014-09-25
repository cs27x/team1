package Objects;

import java.util.*;

import parser.EventCrawler;

public class DataModel {

    private final Vector<Event> listEvent;
    private final Vector<Team> listTeam;
    
    public DataModel()
    {
    	EventCrawler ec = new EventCrawler();
    	listEvent = ec.getListEvent();
    	listTeam = new Vector<Team>();
    	for (int i = 0; i < ec.getListSports().size(); i++)
    	{
    		Team t = new Team(ec.getListSports().get(i)[0],
    				ec.getListSports().get(i)[2], 
    				ec.getListSports().get(i)[1]);
    		listTeam.add(t);
    	}
    }

    public Vector<Event> getAllEvents()
    {
        return listEvent;
    }

    public Vector<Team> getAllTeams()
    {
        return listTeam;
    }

    public Vector<Event> getEventsOn(Date specdate)
    {
    	Vector<Event> filteredList = new Vector<Event>();
    	for(Event e: listEvent)
    	{
    		if (e.date.compareTo(specdate)==0)
    		{
    			filteredList.add(e);
    		}
    	}
        return filteredList;
    }

    public Vector<Event> getEventsBetween(Date date1, Date date2)
    {
    	Vector<Event> filteredList = new Vector<Event>();
    	for (Event e : listEvent)
    	{
    		if(e.date.compareTo(date1)>=0 && e.date.compareTo(date2)<=0)
    		{
    			filteredList.add(e);
    		}
    	}
        return filteredList;
    }

    public Vector<Event> getEventsFrom(Team team)
    {
    	Vector<Event> filteredList = new Vector<Event>();
    	for(Event e: listEvent)
    	{
    		if(e.getTeam().equals(team))
    		{
    			filteredList.add(e);
    		}
    	}
        return filteredList;
    }

    /*public Vector<Event> getEventsFrom(Vector<Team> teams)
    {
        Iterator itr = teams.iterator();
        while()
    }*/
}
