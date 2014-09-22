package edu.vanderbilt.vandysports;

import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import edu.vanderbilt.vandysports.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        testEventCrawler();
    }
    
    public void testEventCrawler() {
    	
    	new Thread(new Runnable() {
    	    public void run() {
    	    	EventCrawler ec = new EventCrawler();
    			Vector<Event> list = ec.getListEvent();
    			for (int i=0; i<list.size(); i++) {
    				Event e = list.get(i);
    				System.out.println(e.event+" "+e.location+" "+e.time);
    			}
    	    }
    	  }).start();
    	
    	
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
