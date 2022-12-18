/**
 * MBTA.java
 * This class  contains your program’s main method and should run a simulation of a Railway. 
 * @author:Aerionna Stephenson
 * date:December 12, 2022
 */
package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MBTA {

	static final int TIMES = 6;
	static Scanner s;
	static Railway r;

	/**
	 * The main method should construct the Railway with the Stations, Riders,
	 * and Trains loaded from the provided text files and then run the simulation
	 */
	public static void main(String[] args) throws FileNotFoundException {
		r = new Railway();

		MBTA m = new MBTA();
		m.initiateStations("C:/Users/aerio/Desktop/PA1_MBTA/PA1/redLine.txt");
		m.initiateRiders("C:/Users/aerio/Desktop/PA1_MBTA/PA1/riders.txt");
		m.initiateTrains("C:/Users/aerio/Desktop/PA1_MBTA/PA1/trains.txt");
		// System.out.println(r);
		runSimulation(TIMES);
		// System.out.println(r.toString());

		

	}
	/** 
	 * This method runs the simulation using TIMES and Railway’s simulate() method
	 * @param times is the amound of hours the transit system is running
	 */
	public static void runSimulation(int times) {

		for(int i=0; i<times; i++){

			r.simulate();
		
		}
	}

	/**
	 * This method constructs Stations from an input file and adds them to the Railway
	 * @param filename this the file contains all of the station names
	 * @throws FileNotFoundException thrown if the file is not found
	 */
	public void initiateStations(String filename) throws FileNotFoundException {

		File redline = new File(filename);
		s = new Scanner(redline);

		while (s.hasNextLine()) {

			String station = s.nextLine();

			r.addStation(new Station(station));

		}

	}

	/**
	 * This method constructs Riders from an input file and adds them to the Railway
	 * @param filename this the file contains all of the station names
	 * @throws FileNotFoundException thrown if the file is not found
	 */
	public void initiateRiders(String filename) throws FileNotFoundException {

		File rider = new File(filename);
		s = new Scanner(rider);
		int count = 0;

		String[] id = new String[11];
		String[] sst = new String[11];
		String[] dst = new String[11];

		while (s.hasNextLine()) {

			id[count] = s.nextLine();
			sst[count] = s.nextLine();
			dst[count] = s.nextLine();

			r.addRider(new Rider(id[count], sst[count], dst[count]));
			count++;

		}

	}

	/**
	 * This method  constructs Trains from an input file and adds them to the Railway
	 * @param filename this the file contains all of the station names
	 * @throws FileNotFoundException thrown if the file is not found
	 */
	public void initiateTrains(String filename) throws FileNotFoundException {

		File train = new File(filename);
		s = new Scanner(train);
		int count = 0;

		String[] name = new String[7];
		int[] direction = new int[7];

		while (s.hasNextLine()) {

			name[count] = s.nextLine();
			System.out.println();
			direction[count] = s.nextInt();
			s.nextLine();

			r.addTrains(new Train(name[count], direction[count]));
			
			count++;

		}
		
	}
}
