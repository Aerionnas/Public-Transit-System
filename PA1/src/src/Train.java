/**
 * Train.java
 * This class represents a Train on the red line. All Trains hold a specified number of passengers in 
 * an array, the current number of passengers, the current Station where the Train is, and the Train’s 
 * current direction. 
 * 
 * @author:Aerionna Stephenson
 * date:December 12, 2022
 */
package src;

import java.util.Arrays;

public class Train {

	final int TOTAL_PASSENGERS = 10;
	Rider[] passengers;
	String currentStation;
	int direction;
	int passengerIndex;

	public Train(String currentStation, int direction) {

		this.currentStation = currentStation;
		this.direction = direction;
		passengers = new Rider[10];
		this.passengerIndex = 0;

	}

	//getters
	public String getStation() {

		return this.currentStation;

	}

	public int getDirection() {

		return direction;

	}


	//setters
	public void swapDirection(int direc) {

		this.direction = direc;

	}

	public void updateStation(String s) {
		this.currentStation = s;
	}

	/**
	 * @return true if this Train is northbound.
	 */
	public boolean goingNorth() {

		if (this.direction == 0) {

			return true;

		} 
		else {

			return false;

		}

	}

	/**
	 * This method returns a String of the current passengers on the Train.
	 * @return the current passengers on the train
	 */
	public String currentPassengers() {

		String rider = "";

		if (passengerIndex == 0) {

			return rider;

		}

		for (int i=0; i<passengerIndex; i++) {
			
			if(passengers[i]== null){
				continue;
			}

			rider += "\n" + passengers[i].getRiderID() + ", " + passengers[i].getDestination() ;

		}

		return rider;
	}

	/**
	 * This method adds a passenger to the Train as long as the rider is at the correct
	 * station to enter the Train, is going the appropriate direction, and if there is 
	 * space on the train.
	 * @param r the rider that is becoming a passenger on the train
	 * @return true if the passenger was added
	 */
	public boolean addPassenger(Rider r) {		

		if ( (r.direction == direction) && (hasSpaceForPassengers() == true) && (r.startingStation.equals(currentStation))) {
			
			this.passengers[this.passengerIndex] = r;
			System.out.println(this.passengers[passengerIndex].riderID + " is no longer waiting.");
			this.passengerIndex++;
			
			return true;

		}

		else {
		
			return false;

		}

	}

	/**
	 * This method checks if there is room for more passengers on this train
	 * @return true if the Train has space for additional passengers. 
	 */
	public boolean hasSpaceForPassengers() {

		if (this.passengerIndex == TOTAL_PASSENGERS) {

			return false;

		} 
		else {

			return true;

		}
	}

	/**
	 * This method removes all of the passengers who should be exiting the Train 
	 * at the Train’s current station
	 * @param station This is the station where the passenger is waiting

	 */
	public String removePassenger() {
		
		String remove = "";
		
		for (int i = 0; i < this.passengers.length; i++) {

			if (this.passengers[i] == null){
				
				continue;
				
			} 

			else if (this.passengers[i].destinationStation.equals(this.currentStation) ) {
				remove+= this.passengers[i].getRiderID() + ", " + this.passengers[i].getDestination() + " was removed \n";
				
				
				this.passengerIndex--;
				this.passengers[i] = null;
				
			}

			else{

				remove+= "\n"+ this.passengers[i].riderID + " is staying on this train.\n";
			}
		
		}


		return remove;

	}

	
	/**
	 * Checks if a Stations were equal
	 * 
	 * @param Rider to be checked
	 * @return true or false
	 */
	public boolean equals(Rider r) {
		if (r.destinationStation == this.currentStation) {
			return true;
		}
		return false;
	}

	/**
	 * @return a String representation of this Train
	 */
	public String toString() {
		return currentStation + " Train" + currentPassengers();
	}

	public static void main(String[] args) {
		Station d = new Station("Ben");
		Station lyn = new Station("Lyn");
		Station lesly = new Station("Lesley");

		Train t = new Train("Ben", 1);
		Rider ben = new Rider("abc", "Ben", "Lesley");
		Rider stacy = new Rider("def", "Ben", "Lesley");
		Rider bill= new Rider("fgh", "Ben", "Lesley");
		Rider nancy = new Rider("hijk", "Ben", "Lesley");
		Rider erica = new Rider("lmno", "Ben", "Lesley");

			
		ben.setDirection(1);
		System.out.println(t.addPassenger(ben));
		
		stacy.setDirection(1);
		System.out.println(t.addPassenger(stacy));
		
		bill.setDirection(1);
		System.out.println(t.addPassenger(bill));
		
		nancy.setDirection(1);
		System.out.println(t.addPassenger(nancy));

		System.out.println(t.currentPassengers());
		
		System.out.println(Arrays.toString(t.passengers));

		System.out.println(t.removePassenger());
		
		System.out.println(t.passengerIndex);

		// System.out.println(t.currentPassengers());


	}

}

