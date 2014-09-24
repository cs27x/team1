package parser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import Objects.Event;

public class ObjectSaver {
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;

	public static void main(String[] args) {

		EventCrawler ec = new EventCrawler();
		
		// Grab events from pages
		Vector<Event> list = ec.getListEvent();

		// Save list to file
		FileOutputStream fout;
		try {
			fout = new FileOutputStream("EventList.ser");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Load list from file
		FileInputStream fin;
		try {
			fin = new FileInputStream("EventList.ser");
			ois = new ObjectInputStream(fin);
			list = (Vector<Event>) ois.readObject();
			for (int i = 0; i < list.size(); i++) {
				Event e = list.get(i);
				System.out.println("Test: "+e.event + " " + e.location + " " + e.time);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
