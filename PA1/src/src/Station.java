package src;

public class Station {

	public String name;
	Queue<Rider> northWaiting;
	Queue<Rider> southWaiting;
	Queue<Train> northBoundTrains;
	Queue<Train> southBoundTrains;

	public Station(String name) {

		this.name = name;
		northWaiting = new Queue<Rider>(5);
		southWaiting = new Queue<Rider>(5);
		northBoundTrains = new Queue<Train>(6);
		southBoundTrains = new Queue<Train>(6);

	}

	/**
	 * getter
	 * 
	 * @return the station name
	 */
	public String stationName() {

		return this.name;

	}

	/**
	 * This method adds a Rider to the appropriate Queue, depending on the
	 * Rider’s direction, as long as they should be in this Station. Return true if
	 * this is
	 * possible and false otherwise.
	 * 
	 * @param r This is a waiting rider
	 */
	public void addWaitingRider(Rider r) {

		if (r.direction == 1) {

			southWaiting.enqueue(r);

		} else if (r.direction == 0) {

			northWaiting.enqueue(r);

		}

	}

	/**
	 * This method moves a Train into this Station, removes all of the passengers
	 * who are meant to
	 * disembark at this Station, and places the Train in the appropriate Queue
	 * depending
	 * on its direction. This method should return a String that includes that some
	 * passengers were removed at this Station.
	 * 
	 * @param t is train that is being enqueued to the station
	 * @return the passengers that are being removed
	 */
	public String addTrainToStation(Train t) {

		t.updateStation(this.name);

		if (t.goingNorth() == true) {

			northBoundTrains.enqueue(t);
					
		}

		else {

			southBoundTrains.enqueue(t);

		}
	
		return "\n" + name + " Disembarking Passengers: " + (t.removePassenger())+ "\nThis train currently has " + t.passengerIndex + " passenger(s).";

	}

	/**
	 * This method prepares a Southbound train of passengers by dequeuing a train
	 * from the southbound train queue and adding as many southbound Riders to the
	 * Train as possible
	 * 
	 * @return the train that has been filled or null if there are no waiting
	 *         southbound Trains
	 */
	public Train southBoardTrain() {

		Train t = new Train("Alewife", 1);

		if (!southBoundTrains.isEmpty()) {

			t = southBoundTrains.dequeue();
			t.updateStation(t.currentStation);

		}

		while (!southWaiting.isEmpty() && t.hasSpaceForPassengers()) {

			t.addPassenger(southWaiting.dequeue());

			System.out.println("\n This Train now has " + t.passengerIndex + " passenger(s): " + t.currentPassengers());

		}

		return t;

	}

	/**
	 * This method prepares a Northbound train of passengers by dequeuing a train
	 * from the northbound train queue and adding as many northbound Riders to the
	 * Train as possible
	 * 
	 * @return the train that has been filled or null if there are no waiting
	 *         northbound Trains.
	 */
	public Train northBoardTrain() {

		Train t = new Train("Braintree", 0);
		if (!northBoundTrains.isEmpty()) {

			t = northBoundTrains.dequeue();
			t.updateStation(t.currentStation);
			System.out.println(this.name + " train has departed from the station.");
			
		}

		while (!northWaiting.isEmpty() && t.hasSpaceForPassengers()) {

			t.addPassenger(northWaiting.dequeue());

			System.out.println("This Train now has " + t.passengerIndex + " passenger(s): " + t.currentPassengers());

		}

		return t;

	}

	/**
	 * This method changes the direction of the first waiting northbound Train
	 * and moves it to the southbound queue. Train does not have any riders.
	 */
	public void moveTrainNorthToSouth() {

		Train t = new Train(name, 1);
		t.swapDirection(1);
		southBoundTrains.enqueue(t);

	}

	/**
	 * This method changes the direction of the first waiting southbound Train
	 * and moves it to the northbound queue. Train does not have any riders.
	 */
	public void moveTrainSouthToNorth() {

		Train t = new Train(name, 0);
		t.swapDirection(0);
		// t.passengerIndex
		northBoundTrains.enqueue(t);

	}

	/**
	 * @return the name and status of the station.
	 */
	public String toString() {

		return "\n Station: " + stationName() + "\n" + northWaiting.numOfElements + "  north-bound trains waiting " +  "\n"
				+ southBoundTrains.numOfElements + "  south-bound trains waiting " +  "\n" + northWaiting.numOfElements
				+ " north-bound passengers waiting " +  "\n" + southWaiting.numOfElements + "  south-bound passengers waiting\n ";

	}

}
