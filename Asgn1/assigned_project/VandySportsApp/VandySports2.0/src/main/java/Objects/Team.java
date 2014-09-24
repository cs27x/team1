package Objects;

import java.io.Serializable;
import java.util.*;

public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	public final String Sport;
	public final String Website_Link;
	public final String Gender;
	public Vector<Event> events;
	
	public Team(String sport, String link, String gender) {
		Sport=sport;
		Website_Link=link;
		Gender=gender;
	}
	
	public void printTeam()
	{
		System.out.println(Gender + "'s " + Sport );
	}
}