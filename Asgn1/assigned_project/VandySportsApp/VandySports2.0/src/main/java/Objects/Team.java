package Objects;

import java.io.Serializable;
import java.util.*;

/**
 * @author	Will Pascucci 
 * @version	1.4
 * @since	2014-09-21
 */
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	public final String sport_;
	public final String websiteLink_;
	public final String gender_;
	public Vector<Event> events;
	
	/**
	 * Creates a team object	 
	 * @param sport	the sport this team plays
	 * @param link	link to team website
	 * @param gender	mens vs. womens
	 */
	public Team(String sport, String link, String gender) {
		sport_ = sport;
		websiteLink_ = link;
		gender_ = gender;
	}
	
	/**
	 * mens or womens team
	 * 
	 * @return	gender of the team
	 */
	public String getGender()
	{
		return gender_;
	}
	
	/**
	 * sport this team plays
	 * 
	 * @return	sport this team plays
	 */
	public String getSport()
	{
		return sport_;
	}
	
	/**
	 * url for team website
	 * 
	 * @return	url for team website
	 */
	public String getLink()
	{
		return websiteLink_;
	}
	
	/**
	 * prints which team this is
	 * 
	 */
	public void printTeam()
	{
		System.out.println(gender_ + "'s " + sport_);
	}
	
	/**
	 * compares to see if these are the same team
	 * 
	 * @param team	team to compare with
	 * @return	true if teams are the same
	 */
	public boolean equals(Team team)
	{
		return this.gender_.toLowerCase().equals(team.gender_.toLowerCase()) 
				&& this.sport_.toLowerCase().equals(team.sport_.toLowerCase());
	}
}