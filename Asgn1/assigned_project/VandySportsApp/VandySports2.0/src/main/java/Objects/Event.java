package Objects;

import java.io.Serializable;
import java.util.Date;

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
    
    public Event(Team team, Date date, String event, String location, String time) {
        mTeam = team;
        this.date = date;
        this.event = event;
        this.location = location;
        this.time = time;
    }
    
    public Team getTeam() 
    {
    	return mTeam;
    }
    
    @SuppressWarnings("deprecation")
	public void printEvent()
    {
    	mTeam.printTeam();
    	System.out.println("\t" + "at " + location + " on " + days[date.getDay()] + " " 
    	+ months[date.getMonth()] + " " + (date.getDate() + 1) + ", " + (date.getYear()+1900));
    }
}
