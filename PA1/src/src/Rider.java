/**
 * Rider.java
 * This class represents a Rider on the red line. A rider should have an ID, starting station, 
 * destination station, and a direction.
 * 
 * @author:Aerionna Stephenson
 * date:December 12, 2022
 */
package src;

public class Rider {

	 String riderID;
	 String startingStation;
	 String destinationStation;
	 int direction;
	
	public Rider(String riderID, String startingStation, String destinationStation) {

		this.riderID = riderID;
		this.startingStation = startingStation;
		this.destinationStation = destinationStation;

	}
	
	//getters
	public String getStarting() {

		return this.startingStation;

	}
	
	public String getDestination() {

		return this.destinationStation;

	}
		
	public int getDirection() {

		return this.direction;

	}

	public String getRiderID() {

		return this.riderID;

	}

	//setters

	public void setDirection(int direction) {

		this.direction = direction;

	}

	/**
	 * This method checks if this Rider is equal to another Object 
	 * based on ID
	 * @param s this is another Rider Object
	 * @return true or false
	 */
	// public boolean equals(Rider s) {

	// 	if(riderID == s.riderID){

	// 		return true;

	// 	}

	// 	return false;

	// }
		
	/**
	 * @return a string representation of a rider
	 */
	public String toString() {

		return "Rider : riderID = " + riderID + ", startingStation = " + startingStation + ", destinationStation = "
				+ destinationStation + ", direction = " + direction;
				
	}
	
}
