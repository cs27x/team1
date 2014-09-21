package edu.vanderbilt.vandysports;

java.util.Date;

public class DataModel {
	
	List<Event> listEvent;
	List<Team> listTeam;
	
	public DataModel()
	{
		this.listEvent = getAllEvents();
		this.listTeam = getAllTeams();
	}
	
	public getAllEvents()
	{
		
	}
	
	public getAllTeams()
	{
		
	}
	
	public getEventsOn(Date date)
	{
		
	}
	
	public getEventsBetween(Date date1, Date date2)
	{
		
	}
	
	public getEventsFrom(Team team)
	{
		
	}
	
	public getEventsFrom(List<Team> teams)
	{
		
	}
}