package parser;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;
import java.text.SimpleDateFormat;
import java.util.Date;

import Objects.Event;
import Objects.Team;

/**
 * @author	Fangzhou Sun  
 * @version	1.2
 * @since	2014-09-22
 */
public class EventCrawler implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Event> listEvent;
	private Vector<String[]> listSports;

	/**
	 *  Fetches events
	 * 
	 * @return 	all currently held events
	 */
	public Vector<Event> getListEvent() {
		return listEvent;
	}

	/**
	 * Sets events to passed param
	 * @
	 * @param listEvent	list of new events
	 */
	public void setListEvent(Vector<Event> listEvent) {
		this.listEvent = listEvent;
	}

	/**
	 * Fetches list of sports
	 * 
	 * @return 	all currently held sports 
	 */
	public Vector<String[]> getListSports() {
		return listSports;
	}

	/**
	 *  Sets new list of sports
	 * 
	 * @param listSports	list of new sports
	 */
	public void setListSports(Vector<String[]> listSports) {
		this.listSports = listSports;
	}

	/**
	 * Grabs events and sports from online
	 */
	public EventCrawler() {
		listEvent = new Vector<Event>();
		listSports = new Vector<String[]>();

		System.out
		.println("Grabbing sports URLs from page: http://www.vucommodores.com/index.html");
		initURLs();

		grabEvents();

		System.out.println("Finished!");
	}

	/**
	 * Does the parsing to grab the events
	 */
	public void grabEvents() {
		for (int i = 0; i < listSports.size(); i++) {

			System.out.println("(" + (i + 1) + "/" + listSports.size() + ") "
					+ "Grabbing events from " + listSports.get(i)[1] + "'s "
					+ listSports.get(i)[0] + " page: " + listSports.get(i)[2]);
			String source = openURL(listSports.get(i)[2]);
			int fromIndex = 0;
			while (source.indexOf("event-listing", fromIndex) >= 0) {
				fromIndex = source.indexOf("event-listing", fromIndex) + 15;
				String[] eventStrList = new String[4];
				for (int td = 0; td < 4; td++) {
					int tdIndex = source.indexOf("row-text", fromIndex);
					fromIndex = tdIndex;
					String str = source.substring(tdIndex + 10,
							source.indexOf("<", tdIndex));
					fromIndex = source.indexOf("<", tdIndex) + 4;
					eventStrList[td] = str;
				}

				try {
					String teamName = eventStrList[1].replaceAll("vs. ", "")
							.replaceAll("at ", "")
							.replaceAll(" (Exhibition)", "")
							.replaceAll("\\s+$", "");
					String url = "http://search.espn.go.com/results?searchString="
							+ URLEncoder.encode(teamName, "UTF-8");

					Team team = new Team(listSports.get(i)[0], url,
							listSports.get(i)[1]);
					SimpleDateFormat dateFormat = new SimpleDateFormat(
							"MM/dd/yy");

					Date date = dateFormat.parse(eventStrList[0]);
					Event event = new Event(team, date, eventStrList[1],
							eventStrList[2], eventStrList[3]);
					// System.out.println(team.Sport+" - "+team.Gender+" - "+
					// event.event+" - "+event.location+" - "+event.time);
					listEvent.add(event);
				} catch (Exception e) {
				}
			}
		}
	}

	/**
	 * opens a url
	 * @
	 * @param url		the url to be opened
	 * @return 	returns the sources
	 */
	public String openURL(String url) {
		String source = null;
		BufferedInputStream bis;
		try {
			
			URL my_url = new URL(url);

			HttpURLConnection urlConnection = (HttpURLConnection) my_url
					.openConnection();
			urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
			InputStream is = urlConnection.getInputStream();

			bis = new BufferedInputStream(is);

			byte[] buffer = new byte[1024];
			int bytesread = 0;
			source = "";

			bytesread = bis.read(buffer);
			while (bytesread != -1) {
				source += new String(buffer, 0, bytesread);
				bytesread = bis.read(buffer);
			}
		} catch (Exception ex) {
			System.out.println("Exception: "+ex.toString());
		}
		return source;
	}

	/**
	 * adds sports to sport list from url
	 */
	public void initURLs() {

		String source = openURL("http://www.vucommodores.com/index.html");
		int menIndex = source.indexOf("sports column span4");
		int womenIndex = source.indexOf("sports column span4", menIndex + 1);

		String[] subString = new String[2];
		subString[0] = source.substring(menIndex, womenIndex);
		subString[1] = source.substring(womenIndex);

		for (int i = 0; i < 2; i++) {
			int fromIndex = 0;
			while (subString[i].indexOf("<a class=\"al\" href=\"/sports/",
					fromIndex) >= 0) {
				fromIndex = subString[i].indexOf(
						"<a class=\"al\" href=\"/sports/", fromIndex) + 1;
				String sportName = subString[i].substring(
						subString[i].indexOf("\">", fromIndex) + 2,
						subString[i].indexOf("</a>", fromIndex));

				for (int j = 0; j < 3; j++) {
					fromIndex = subString[i].indexOf(
							"<a class=\"ar\" href=\"/sports/", fromIndex) + 1;
				}
				String sportLink = "http://www.vucommodores.com"
						+ subString[i].substring(
								subString[i].indexOf("href=\"", fromIndex) + 6,
								subString[i].indexOf("\">", fromIndex));

				String[] sport = new String[3];
				sport[0] = sportName;
				sport[1] = i == 0 ? "Men" : "Women";
				sport[2] = sportLink;

				listSports.add(sport);
			}
		}
	}
}
