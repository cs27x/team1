package edu.vanderbilt.vandysports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import edu.vanderbilt.vandysports.R;
import edu.vanderbilt.vandysports.parser.EventCrawler;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//
		testLoadEventList();
	}

	// If we grab the events in the app every time, it will take too much time.
	// public void testEventCrawler() {
	// new Thread(new Runnable() {
	// public void run() {
	// EventCrawler ec = new EventCrawler();
	// Vector<Event> list = ec.getListEvent();
	// for (int i=0; i<list.size(); i++) {
	// Event e = list.get(i);
	// System.out.println(e.event+" "+e.location+" "+e.time);
	// }
	// }
	// }).start();
	// }

	public void testLoadEventList() {
		Vector<Event> list = new Vector<Event>();
		
		// Load list from file
		FileInputStream fin;
		ObjectInputStream ois;
		try {
			InputStream fin2 = getResources().getAssets().open("EventList.ser");
			ois = new ObjectInputStream(fin2);
			list = (Vector<Event>) ois.readObject();
			for (int i = 0; i < list.size(); i++) {
				Event e = list.get(i);
				System.out.println("Test: " + e.event + " " + e.location + " "
						+ e.time);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Load Exception: " + e.toString());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
