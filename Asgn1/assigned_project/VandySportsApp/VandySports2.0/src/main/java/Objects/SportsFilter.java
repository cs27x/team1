package Objects;

import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;

import parser.*;

public class SportsFilter {	
	
	public static void main(String[] args)
	{
		//Options for filters here

		DataModel dm = new DataModel();
		Date date = new Date();
		System.out.println(date);
		getEventsonDate(dm);
	}
	
	private static void getEventsonDate(DataModel dm)
	{
		Scanner scanner = new Scanner(new InputStreamReader(System.in));
		System.out.print("Enter a Date (Format - yyyy/mm/dd): ");
		String dateString = scanner.nextLine();
		String[] rawDate = dateString.split("/");
		int year = Integer.parseInt(rawDate[0]);
		int month = Integer.parseInt(rawDate[1]);
		int day = Integer.parseInt(rawDate[2]);
		@SuppressWarnings("deprecation")
		Date date = new Date(year, month, day);
		//parse dateString to date
		scanner.close();
		Vector<Event> events = dm.getEventsOn(date);
		for (Event event : events)
		{
			event.print();
			System.out.println("");
		}
	}	
}
