package Objects;

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

import parser.*;

public class SportsFilter {	
	
	public static void main(String[] args)
	{
		DataModel dm = new DataModel();
		Vector<Event> allEvents = dm.getAllEvents();
		for(Event event : allEvents)
		{
			event.printEvent();
		}
		//Options for filters here

		//getEventsOnDate(dm);
		getTeamEvents(dm);
	}
	
	private static void getEventsOnDate(DataModel dm)
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.print("Enter a Date (Format - yyyy/mm/dd): ");
		String dateString = scanner.nextLine();
		Date date = stringToDate(dateString);
		scanner.close();
		Vector<Event> events = dm.getEventsOn(date);
		System.out.println("Events on " + dateString + ": " + events.size());
		for (Event event : events)
		{
			event.printEvent();
			System.out.println("");
		}
	}	
	
	private static void getTeamEvents(DataModel dm)
	{
		//print Vanderbilt teams
		System.out.println("Available Teams:");
		Vector<Team> sports = dm.getAllTeams();
		for(Team team_ : sports)
		{
			team_.printTeam();
		}
		//get team user is interested in
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.print("Enter a Team (Format - '[Team]'s [Sport]): ");
		String team = scanner.nextLine();
		scanner.close();
		//turn string into a team object
		Team selectedTeam = null;
		for(Team team_ : sports)
		{
			System.out.println(team_.getGender() + "'s " + team_.getSport() + " vs. " + team);
			
			if ((team_.getGender() + "'s " + team_.getSport()).equals(team))
			{
				selectedTeam = team_;
				System.out.println("SELECTED: " + team_.getGender() + "'s " + team_.getSport());
			}
		}
		if (selectedTeam == null)
		{
			System.out.println("Sorry, that isn't a valid team entry!");
			return;
		}
		//print events
		Vector<Event> events = dm.getEventsFrom(selectedTeam);
		System.out.println("Events for " + team + ": " + events.size());
		for (Event event : events)
		{
			event.printEvent();
			System.out.println("");
		}
	}
	
	@SuppressWarnings("deprecation")
	private static Date stringToDate(String dateString)
	{
		String[] rawDate = dateString.split("/");
		int year = Integer.parseInt(rawDate[0]);
		int month = Integer.parseInt(rawDate[1]);
		int day = Integer.parseInt(rawDate[2]);
		return new Date(year - 1900, month - 1, day);
	}
}
