package edu.vanderbilt.vandysports.testsuite;

import java.util.Arrays;
import java.util.Date;
import java.util.Vector;

import static org.junit.Assert.*;
import Objects.*;

import org.junit.Test;

public class TestDataModel {

    private static Vector<Team> testTeams = new Vector<Team>(Arrays.asList(
                new Team("Football", "Men", "vanderbilt.edu/football"),
                new Team("Bowling", "Women", "vanderbilt.edu/bowling"),
                new Team("Baseball", "Women", "vanderbilt.edu/baseball"),
                new Team("Crew", "Men", "vanderbilt.edu/crew"),
                new Team("Tennis", "Women", "vanderbilt.edu/tennis")
            ));
    private static Vector<Event> testEvents = new Vector<Event>(Arrays.asList(
                new Event(testTeams.get(0), new Date(2014, 8, 24), "@ North Carolina", "Raleigh, NC", "7:30"),
                new Event(testTeams.get(0), new Date(2014, 10, 24), "@ LSU", "Baton Rouge, LA", "5:00"),
                new Event(testTeams.get(1), new Date(2014, 8, 18), "bowling game 1", "here", "7:30"),
                new Event(testTeams.get(1), new Date(2014, 11, 14), "bowling game 2", "Raleigh, NC", "7:30"),
                new Event(testTeams.get(2), new Date(2015, 6, 2), "Baseball game 1", "Nashville,  TN", "6:00"),
                new Event(testTeams.get(2), new Date(2015, 7, 28), "Baseball game 2", "Nashville,  TN", "6:00"),
                new Event(testTeams.get(3), new Date(2014, 7, 28), "Crew match 1", "Nashville", "7:30"),
                new Event(testTeams.get(3), new Date(2014, 11, 30), "Crew match 2", "Kentucky", "7:30"),
                new Event(testTeams.get(4), new Date(2015, 1, 24), "Tennis match 1", "Georgia", "7:30"),
                new Event(testTeams.get(4), new Date(2014, 8, 24), "Tennis match 2", "Florida", "7:30")
            ));
    private DataModel dm = new DataModel(testEvents);

    @Test
    public void testGetAllEvents() {
        assertEquals(dm.getAllEvents().size(), 10);
        for (Event e : dm.getAllEvents())
            assertNotNull(e.getTeam());
    }

    @Test
    public void testGetAllTeams() {
        assertEquals(dm.getAllTeams().size(), 5);
    }

    @Test
    public void testGetEventsOn() {
        Vector<Event> evtsOn = dm.getEventsOn(new Date(2014, 8, 24));
        assertEquals(evtsOn.size(), 2);
        for (Event e : evtsOn) {
            assertTrue(e.getDate().getDate() == 24
                    && e.getDate().getMonth() == 8
                    && e.getDate().getYear() == 2014);
        }
    }

    @Test
    public void testGetEventsBetween() {
        Vector <Event> evtsBt = dm.getEventsBetween(new Date(2015, 1, 25), new Date(2015, 7, 28));
        assertEquals(evtsBt.size(), 2);
        assertSame(evtsBt.get(0).getTeam(), evtsBt.get(1).getTeam());
    }

    @Test
    public void testGetEventsFrom() {
        for (Team t : dm.getAllTeams()) {
            Vector <Event> evtsFr = dm.getEventsFrom(t);
            assertEquals(evtsFr.size(), 2);
            for (Event e : evtsFr) {
                assertSame(e.getTeam(), t);
            }
        }
    }

}
