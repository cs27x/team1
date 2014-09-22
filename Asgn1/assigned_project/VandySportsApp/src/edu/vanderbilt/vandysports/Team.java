package edu.vanderbilt.vandysports;

import java.util.*;

public class Team
{
	public final String Sport;
	public final String Website_Link;
	public final String Gender;
	public Vector<Event> events;
	
	public Team(String sport, String link, String gender)
	{
		Sport=sport;
		Website_Link=link;
		Gender=gender;
	}
}