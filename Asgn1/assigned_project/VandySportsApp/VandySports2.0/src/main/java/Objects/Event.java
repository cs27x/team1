package Objects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author	Nathan Walker
 * @author	Cameron Ridgewell
 * @author	Will Pascucci 
 * @version	1.6
 * @since	2014-09-21
 */
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Team mTeam;
    public final Date date;
    public final String event;
    public final String location;
    public final String time;

    private String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", 
    		"September", "October", "November", "December"};
    
    /**
     * Creates an event object	 
     * 
     * @param team	the team playing in this event
     * @param date	date of the event
     * @param event	title of the event
     * @param location	location of the event
     * @param time	time of the event
     */
    public Event(Team team, Date date, String event, String location, String time) {
        mTeam = team;
        this.date = date;
        this.event = event;
        this.location = location;
        this.time = time;
    }
    
    /**
     * team playing in this event
     * 
     * @return	team that is playing
     */
    public Team getTeam() 
    {
    	return mTeam;
    }
    
    /**
     * date the event is on
     * 
     * @return	date of event
     */
    public Date getDate()
    {
    	return date;
    }
    
    /**
     * prints the details of the event
     * 
     */
    @SuppressWarnings("deprecation")
	public void printEvent()
    {
    	mTeam.printTeam();
    	System.out.println("at " + location + " on " + days[date.getDay()] + " " 
    	+ months[date.getMonth()] + " " + (date.getDate() + 1) + ", " + (date.getYear()+1900));
    }
    
    /**
     * prints the date of the event
     */
    @SuppressWarnings("deprecation")
    public void printDate()
    {
    	System.out.println(days[date.getDay()] + " " 
    	+ months[date.getMonth()] + " " + (date.getDate() + 1) + ", " + (date.getYear()+1900));
    }
    
    /**
     * prints event without date
     */
    public void printEventNoDate()
    {
    	mTeam.printTeam();
    	System.out.println("at " + location +"\n\n");
    }
}
