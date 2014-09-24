package Objects;

import java.io.Serializable;
import java.util.*;

public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	public final String sport_;
	public final String websiteLink_;
	public final String gender_;
	public Vector<Event> events;
	
	public Team(String sport, String link, String gender) {
		sport_ = sport;
		websiteLink_ = link;
		gender_ = gender;
	}
	
	public String getGender()
	{
		return gender_;
	}
	
	public String getSport()
	{
		return sport_;
	}
	
	public void printTeam()
	{
		System.out.println(gender_ + "'s " + sport_ );
	}
	
	public boolean equals(Team team)
	{
		return this.gender_.toLowerCase().equals(team.gender_.toLowerCase()) 
				&& this.sport_.toLowerCase().equals(team.sport_.toLowerCase());
	}
}