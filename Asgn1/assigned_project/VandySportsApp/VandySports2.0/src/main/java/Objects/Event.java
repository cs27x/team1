package Objects;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable {

	private static final long serialVersionUID = 1L;
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
    
    public void printEvent()
    {
    	mTeam.printTeam();
    	System.out.println(event + " at " + location + " on " + date);
    }
}
