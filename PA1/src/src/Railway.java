package src;

import java.util.Arrays;

public class Railway {

	DoubleLinkedList<Station> railway;
	String[] stationNames;
	int stationIndex;

	public Railway() {

		railway = new DoubleLinkedList<Station>();
		stationNames = new String[18];
		stationIndex = 0;

	}

	/**
	 * This method adds a Station to the Railway
	 * @param s is the station being added to the railway
	 */
	public void addStation(Station s) {

		railway.insert(s);
		stationNames[stationIndex] = s.name;
		stationIndex++;

	}

	/**
	 * This method sets a Rider’s direction based on the order of 
	 * the Stations in the Railway and adds the Rider to the 
	 * appropriate Station in the Railway
	 */
	public void addRider(Rider r) {

		// stations go from north to south
		// set rider direction
		r.setDirection(calcDirection(r.startingStation, r.destinationStation));
		for (int i = 0; i < stationNames.length; i++) {

			if (stationNames[i].equals(r.startingStation)) {

				railway.get(i).addWaitingRider(r);

			}

		}

	}

	/**
	 * This method adds a Train to the appropriate Station in this 
	 * Railway
	 * @param t This is the train that is being added to the Station
	 */
	public void addTrains(Train t) {
		// add train to station
		for (int i = 0; i < stationNames.length; i++) {

			if (stationNames[i].equals(t.currentStation)) {
				
				railway.get(i).addTrainToStation(t);

			}

		}
		
	}

	/**
	 * This method sets the rider's direction based the Rider’s starting
	 * and ending Stations.
	 */
	public int calcDirection(String station1, String station2) {

		int s1pos = -1;
		int s2pos = -1;

		for (int i = 0; i < stationNames.length; i++) {

			if (stationNames[i].equals(station1)) {
			
				s1pos = i;

			} 
			
			else if (stationNames[i].equals(station2)) {

				s2pos = i;

			}

		}

		if (s1pos < s2pos) {

			return 1;

		}

		else {

			return 0;

		}

	}

	/**
	 * This method runs the simulation for a train going south and log
	 * the details.
	 */
	public void goSouth() {
		Node<Station> curr = railway.getHead();
		Train t = new Train(curr.element.name, 1);

		while (curr != null) {

			if (curr == railway.getHead() && t.direction == 1) {	
				System.out.println("\nWelcome to " + curr.element.name + "! Next station, "+ curr.next.element.name + "!");	
				// System.out.println(curr.element);
				t = curr.element.southBoardTrain();
				
			} 

			else if (curr == railway.getTail()) {
				curr.element.moveTrainSouthToNorth();
				// System.out.println(curr.element);
				System.out.println( "\nWe are at the last station!! We are switching routes.");
				System.out.print("\nSouthbound Train is now Northbound.");
			}

			else {
				System.out.println("Train has arrived to the " + curr.element.name + " Station");
				System.out.println(curr.element.addTrainToStation(t));
				System.out.println("\nOn to the next Station, "+ curr.next.element.name);	
				t = curr.element.southBoardTrain();	
				System.out.println(curr.element.name + " train has departed from the station.");
				// System.out.println("\nUpdated Station Informaton: " +curr.element.toString());
			}
			curr = curr.next;

		}
	}

		
	
	/**
	 * This method runs the simulation for a train going north and log
	 * the details.
	 */
	public void goNorth() {
		Node<Station> curr = railway.getTail();
		Train t = new Train(curr.element.name, 0);

		while(curr!= null){

			if(curr == railway.getTail() && t.direction == 0){
				System.out.println("Welcome to " + curr.element.name + "! Next station, "+ curr.prev.element.name + "!");
				// System.out.println(curr.element);
				t = curr.element.northBoardTrain();
				}

			else if (curr == railway.getHead()){
				curr.element.moveTrainNorthToSouth();
				System.out.println( "\nWe are at the last station!! We are switching routes.");
				System.out.print("\nNorthbound Train is now Southbound.");
			}
			else{
				System.out.println("Welcome! Train has arrived to the " + curr.element.name + " Station\n");
				System.out.println(curr.element.addTrainToStation(t));
				System.out.println("On to the next Station, "+ curr.element.name);
				t = curr.element.northBoardTrain();	
				System.out.println(curr.element.name + " train has departed from the station.");
				// System.out.println("\n Updated Station Informaton: " + curr.element.toString());
			}
			
			curr= curr.prev;
			
		}
		

	}

	/**
	 *  This method will execute one simulation of the Railway. 
	 * You should log the events that occur in the process of your
	 * simulation such as the status of each Station, where Trains 
	 * and Riders are, and when Riders exit a Train. This log should
	 * be returned by this method for use in the main class MBTA.java.
	 */
	public void simulate() {
		
		goSouth();
		goNorth();

	}

	/**
	 * @return the Stations list’s String representation.
	 */
	public String toString() {

		return "\nStationNames: " + "\n" + Arrays.toString(stationNames) + "\n" + railway.toString() + "\n";
		
	}

	public static void main(String[] args) {
		Railway b = new Railway();
		Station f = new Station("blue");
		Station g = new Station("green");
		Station y = new Station("yellow");
		Station q = new Station("sunset");
		Station o = new Station("orange");
		Station x = new Station("beige");
		Station v = new Station("tan");
		Station p = new Station("purple");
		b.railway.insert(f);
		b.railway.insert(g);
		b.railway.insert(y);
		b.railway.insert(q);
		b.railway.insert(o);
		b.railway.insert(x);
		b.railway.insert(v);
		b.railway.insert(p);
		b.stationNames = new String[] { "blue", "green", "yellow", "purple" };

		// System.out.println(b.calcDirection("blue", "purple"));
		Rider z = new Rider("mmm", "orange", "green");
		Rider l = new Rider("abc", "yellow", "tan");
		b.addRider(l);
		b.addRider(z);

		Train t = new Train("blue", 1);
		Train e = new Train("purple", 0);
		b.addTrains(t);
		b.addTrains(e);

		System.out.println(b.toString());

		// b.simulate();
	}
}
