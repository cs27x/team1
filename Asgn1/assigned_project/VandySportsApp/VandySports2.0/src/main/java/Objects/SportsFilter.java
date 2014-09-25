package Objects;

import java.util.*;

/**
 * @author Cameron Ridgewell
 * @author Will Pascucci
 * @author Fangzhou Sun
 * @version 1.2
 * @since 2014-09-23
 */
public class SportsFilter {

	public static void main(String[] args) {
		DataModel dm = new DataModel();
		// Options for filters here
		printTitle();
		printNextEvent(dm);

		boolean endFlag = false;
		Scanner scanner = new Scanner(System.in);
		while (!endFlag) {
			System.out
					.println("\n\nWhat would you like to see?\n  Please enter the number of your search type.");
			System.out
					.print("\t1. Filter by Single Date\n\t2. Filter by Single Team\n\t3. See Soonest "
							+ "Upcoming Event(s)\n\t4. See All Events\n\t5. See this Week's Events\n\t6. List of team's ESPN pages"
							+ "\n\t7. See Calendar of events\n\t8. Filter by Multiple Teams\n\tEnter 0 to quit\n\nEnter Selection: ");

			int selection = scanner.nextInt();
			scanner.nextLine();

			switch (selection) {
			case 0:
				endFlag = true;
				break;
			case 1:
				getEventsOnDate(dm, scanner);
				break;
			case 2:
				printTeamEvents(dm, scanner);
				break;
			case 3:
				printNextEvent(dm);
				break;
			case 4:
				printAllEvents(dm);
				break;
			case 5:
				printThisWeekEvents(dm);
				break;
			case 6:
				printTeamLinks(dm);
				break;
			case 7:
				getEventsCalendar(dm);
				break;
			case 8:
				printMultiTeamsEvents(dm, scanner);
				break;
			default:
				System.out.println("Invalid Entry, please try again!\n");
				break;
			}
		}
		scanner.close();
	}

	/**
	 * prints all events on a requested date
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 * @param scanner
	 *            scanner to read input
	 */
	private static void getEventsOnDate(DataModel dm, Scanner scanner) {
		// ask for input date
		System.out.print("Enter a Date (Format - yyyy/mm/dd): ");
		String dateString = scanner.nextLine();
		Date date = stringToDate(dateString);
		Vector<Event> events = dm.getEventsOn(date);
		if (events.size() > 0) {
			// print events from input date
			System.out
					.println("Events on " + dateString + ": " + events.size());
			for (Event event : events) {
				event.printEvent();
				System.out.println("");
			}
		} else {
			// no events on input date, fetch next event
			System.out.println("There aren't any events on " + dateString);
			System.out.println("The next event after then is: ");
			for (Event event : getNextEvents(dm, date)) {
				event.printEvent();
			}
		}
	}

	/**
	 * prints events in the calendar view
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 */
	private static void getEventsCalendar(DataModel dm) {
		// print events for next calendar week
		System.out.println("Here is a calendar of all the upcoming events");
		Vector<Event> events = dm.getAllEvents();
		Iterator<Event> itr = events.iterator();
		while (itr.hasNext()) {
			Event e = (Event) itr.next();
			e.printDate();
			Event e2 = (Event) itr.next();
			e.printEventNoDate();
			while (e.getDate() == e2.getDate()) {
				e2.printEventNoDate();
				e2 = (Event) itr.next();
			}
		}

	}

	/**
	 * prints events for multiple teams
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 * @param scanner
	 *            scanner to read input
	 */
	private static void printMultiTeamsEvents(DataModel dm, Scanner scanner) {
		// print Vanderbilt teams
		System.out.println("Available Teams:");
		Vector<Team> sports = dm.getAllTeams();
		for (Team team_ : sports) {
			team_.printTeam();
		}
		Vector<Event> events = new Vector<Event>();
		System.out
				.print("Enter Teams (Format - '[Team]'s [Sport] | '[Team]'s [Sport] | ...): ");
		String team = scanner.nextLine();
		// turn string into team objects
		// get teams user is interested in
		Vector<Team> selectedTeams = stringToTeams(team, sports);
		if (selectedTeams == null || selectedTeams.size() == 0) {
			return;
		}
		for (Team selectedTeam : selectedTeams) {
			events = dm.getEventsFrom(selectedTeam);
			// print events
			System.out.println("Events for " + selectedTeam.getGender() + "'s "
					+ selectedTeam.getSport() + ": " + events.size());
			for (Event event : events) {
				event.printEvent();
				System.out.println("");
			}
		}
	}

	/**
	 * prints events for a single team
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 * @param scanner
	 *            scanner to read input
	 */
	private static void printTeamEvents(DataModel dm, Scanner scanner) {
		// print Vanderbilt teams
		System.out.println("Available Teams:");
		Vector<Team> sports = dm.getAllTeams();
		for (Team team_ : sports) {
			team_.printTeam();
		}
		Vector<Event> events = new Vector<Event>();
		System.out.print("Enter a Team (Format - '[Team]'s [Sport]): ");
		String team = scanner.nextLine();
		// turn string into a team object
		// get team user is interested in
		Team selectedTeam = stringToTeam(team, sports);
		if (selectedTeam == null) {
			return;
		}
		events = dm.getEventsFrom(selectedTeam);
		// print events
		System.out.println("Events for " + team + ": " + events.size());
		for (Event event : events) {
			event.printEvent();
			System.out.println("");
		}
	}

	/**
	 * gets closest events after a specified date
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 * @param date
	 *            gets next events from given date
	 * @return returns events on closest date with events
	 */
	public static Vector<Event> getNextEvents(DataModel dm, Date date) {
		Vector<Event> nextEventList = new Vector<Event>();
		while (nextEventList.size() == 0) {
			nextEventList = dm.getEventsOn(date);
			date = incrementDay(date);
		}
		return nextEventList;
	}

	/**
	 * prints single closest event from now
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 */
	@SuppressWarnings("deprecation")
	public static void printNextEvent(DataModel dm) {
		// Get date with no time
		Date date = new Date();
		Vector<Event> events = getNextEvents(dm,
				new Date(date.getYear(), date.getMonth(), date.getDate()));
		System.out.println("The Next Vanderbilt Sporting Event is: ");
		for (Event event : events) {
			event.printEvent();
		}
	}

	/**
	 * prints all team links
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 */
	public static void printTeamLinks(DataModel dm) {
		for (Team team : dm.getAllTeams()) {
			team.printTeam();
			System.out.println("\t" + team.getLink());
		}
	}

	/**
	 * converts a string to a date
	 * 
	 * @param dateString
	 *            date to be converted
	 * @return date corresponding to passed string
	 */
	@SuppressWarnings("deprecation")
	private static Date stringToDate(String dateString) {
		String[] rawDate = dateString.split("/");
		int year = Integer.parseInt(rawDate[0]);
		int month = Integer.parseInt(rawDate[1]);
		int day = Integer.parseInt(rawDate[2]);
		return new Date(year - 1900, month - 1, day);
	}

	/**
	 * converts a string input to several teams
	 * 
	 * @param team
	 *            string containing the teams
	 * @param sports
	 *            all teams
	 * @return teams corresponding to string input
	 */
	private static Vector<Team> stringToTeams(String team, Vector<Team> sports) {
		Vector<Team> selectedTeams = new Vector<Team>();
		String[] teamArray = team.split(" \\| ");
		for (String teamOne : teamArray) {
			Team t = stringToTeam(teamOne, sports);
			if (t != null)
				selectedTeams.add(t);
		}
		if (selectedTeams.size() == 0) {
			System.out.println("Sorry, there is no valid team entry!");
			return null;
		}
		return selectedTeams;
	}

	/**
	 * converts a string input to a team
	 * 
	 * @param team
	 *            string containing team
	 * @param sports
	 *            all teams
	 * @return team corresponding to passed string
	 */
	private static Team stringToTeam(String team, Vector<Team> sports) {
		Team selectedTeam = null;
		for (Team team_ : sports) {
			if ((team_.getGender() + "'s " + team_.getSport()).equals(team)) {
				selectedTeam = team_;
			}
		}
		if (selectedTeam == null) {
			System.out.println("Sorry, that isn't a valid team entry!");
			return null;
		}
		return selectedTeam;
	}

	/**
	 * increments a date
	 * 
	 * @param date
	 *            date to be incremented
	 * @return date after being incremented
	 */
	@SuppressWarnings("deprecation")
	private static Date incrementDay(Date date) {
		// Rapidly seeing the superiority of the calendar class
		Date datecopy = new Date(date.getYear(), date.getMonth(),
				date.getDate());
		int febDays = 28;
		if ((datecopy.getYear() + 1900) % 400 == 0
				|| ((datecopy.getYear() + 1900) % 4 == 0 && (datecopy.getYear() + 1900) % 100 != 0)) {
			febDays = 29;
		}
		int[] month_lengths = { 31, febDays, 31, 30, 31, 30, 31, 31, 30, 31,
				30, 31 };
		if (datecopy.getDate() > month_lengths[datecopy.getMonth()]) {
			if (datecopy.getMonth() == 11) {
				datecopy.setYear(datecopy.getYear() + 1);
				datecopy.setMonth(0);
				datecopy.setDate(1);
			} else {
				datecopy.setMonth(datecopy.getMonth() + 1);
				datecopy.setDate(1);
			}
		} else {
			datecopy.setDate(datecopy.getDate() + 1);
		}
		return datecopy;
	}

	/**
	 * fetches events within a range of dates
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 * @param startDate
	 *            initial date in range
	 * @param days
	 *            number of days in date range
	 * @return events found in specified range
	 */
	private static Vector<Event> getDateRangeEvents(DataModel dm,
			Date startdate, int days) {
		Date enddate = startdate;
		for (int i = 0; i <= days; i++) {
			enddate = incrementDay(enddate);
		}
		return dm.getEventsBetween(startdate, enddate);
	}

	/**
	 * prints events in the next week
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 */
	@SuppressWarnings("deprecation")
	private static void printThisWeekEvents(DataModel dm) {
		Date date = new Date();
		System.out.println("The week of " + (date.getMonth() + 1) + "/"
				+ date.getDate() + "/" + (date.getYear() + 1900)
				+ "'s events: ");
		Vector<Event> filteredEvents = getDateRangeEvents(dm, new Date(), 7);
		for (Event event : filteredEvents) {
			event.printEvent();
		}
	}

	/**
	 * prints all events
	 * 
	 * @param dm
	 *            dataModel containing filtered events
	 */
	private static void printAllEvents(DataModel dm) {
		for (Event event : dm.getAllEvents()) {
			event.printEvent();
		}
	}

	/**
	 * prints title “VANDY SPORTS”
	 */
	private static void printTitle() {
		System.out.println("");
		System.out
				.println(" __ __   ____  ____   ___    __ __   _____ ____    ___   ____   ______   _____ __ ");
		System.out
				.println("|  |  | /    ||    \\ |   \\  |  |  | / ___/|    \\  /   \\ |    \\ |      | / ___/|  |");
		System.out
				.println("|  |  ||  o  ||  _  ||    \\ |  |  |(   \\_ |  o  )|     ||  D  )|      |(   \\_ |  |");
		System.out
				.println("|  |  ||     ||  |  ||  D  ||  ~  | \\__  ||   _/ |  O  ||    / |_|  |_| \\__  ||__|");
		System.out
				.println("|  :  ||  _  ||  |  ||     ||___, | /  \\ ||  |   |     ||    \\   |  |   /  \\ | __ ");
		System.out
				.println(" \\   / |  |  ||  |  ||     ||     | \\    ||  |   |     ||  .  \\  |  |   \\    ||  |");
		System.out
				.println("  \\_/  |__|__||__|__||_____||____/   \\___||__|    \\___/ |__|\\_|  |__|    \\___||__|");
		System.out.println("");

	}
}
