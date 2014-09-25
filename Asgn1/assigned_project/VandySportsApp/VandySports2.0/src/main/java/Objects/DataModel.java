package Objects;

import java.util.*;

import parser.EventCrawler;

/**
 * @author	Cameron Ridgewell 
 * @author	Will Pascucci
 * @version	1.3
 * @since	2014-09-22
 */
public class DataModel {

    private final Vector<Event> listEvent;
    private final Vector<Team> listTeam;
    
    /**
     * constructor for dataModel object
     */
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

    /**
     * constructor for dataModel object
     * 
     * @param events
     */
    public DataModel(Vector<Event> events)
    {
        final Set<Team> teams = new HashSet<Team>();
        for (Event e: events) {
            teams.add(e.getTeam());
        }
        listTeam = new Vector<Team>(teams);
        listEvent = new Vector<Event>(events);
    }

    /**
     * fetches all events
     * 
     * @return	all events 
     */
    public Vector<Event> getAllEvents()
    {
        return listEvent;
    }

    /**
     * fetches all teams
     * 
     * @return	all teams 
     */
    public Vector<Team> getAllTeams()
    {
        return listTeam;
    }

    /**
     * fetches all events on a given date
     * 
     * @param specdate	date we want to search
     * @return	all events on this date
     */
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

    /**
     * fetches all events between 2 given dates
     * 
     * @param date1	start date for event filter
     * @param date2	end date for event filter
     * @return	all events in this time period
     */
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

    /**
     * fetches every event for a team
     * 
     * @param team	team who’s events we want
     * @return	all events for this team
     */
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
