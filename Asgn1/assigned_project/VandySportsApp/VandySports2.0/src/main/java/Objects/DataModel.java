package Objects;

import java.util.*;
import parser.EventCrawler;

public class DataModel {

    private final Vector<Event> listEvent;
    private final Vector<Team> listTeam;
    private Vector<Event> filteredList;
    
    public DataModel()
    {
    	EventCrawler ec = new EventCrawler();
    	listEvent = ec.getListEvent();
    	listTeam = new Vector<Team>();
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
    	Iterator itr = listEvent.iterator();
    	while(itr.hasNext())
    	{
    		Event e = (Event) itr.next();
    		if(e.date==specdate)
    		{
    			filteredList.add(e);
    		}
    	}
        return filteredList;
    }

    public Vector<Event> getEventsBetween(Date date1, Date date2)
    {
    	Iterator itr = listEvent.iterator();
    	while(itr.hasNext())
    	{
    		Event e = (Event) itr.next();
    		if(e.date.compareTo(date1)>0&&e.date.compareTo(date2)<0)
    		{
    			filteredList.add(e);
    		}
    	}
        return filteredList;
    }

    public Vector<Event> getEventsFrom(Team team)
    {
    	Iterator itr = listEvent.iterator();
    	while(itr.hasNext())
    	{
    		Event e = (Event) itr.next();
    		if(e.mTeam==team)
    		{
    			filteredList.add(e);
    		}
    	}
        return filteredList;
    }

    public Vector<Event> getEventsFrom(Vector<Team> teams)
    {
        return null;
    }
}
