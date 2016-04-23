/**
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 23.04.2016 
 * Aufgabe: Aufgabenblatt 4 - Aufgabe 1
 */

package aufgabenblatt04;

/**
 * The class Racecar provides a simplified model for a Racecar.
 */
public class Racecar {

	/**
	 * driverName is used to store the name of the driver
	 */
	private final String driverName;
	
	/**
	 * carType is used to store the type of car
	 */
	private final String carType;
	
	/**
	 * maxSpeed stores the maximum speed this Racecar can travel at
	 */
	private final double maxSpeed;
	
	/**
	 * distanceTraveled keeps track of how far the Racecar has traveled
	 */
	private double distanceTraveled;
	
	/**
	 * Instantiates a new Racecar with specific characteristics
	 * 
	 * @param driverName provides the name of the driver
	 * @param carType provides the type of car
	 * @param maxSpeed sets the maximum speed
	 */
	public Racecar(String driverName, String carType, double maxSpeed){
		this.driverName = driverName;
		this.carType = carType;
		this.maxSpeed = maxSpeed;
		distanceTraveled = 0;
	}
	
	/**
	 * Makes the car move by one time step with a random speed between 0 and maxSpeed
	 */
	public void drive(){
		distanceTraveled += Math.random() * maxSpeed;
	}
	
	/**
	 * Prints out the current state of the Racecar
	 */
	public void print(){
		System.out.println("--------------------------");
		System.out.println("Driver:    " + driverName);
		System.out.println("Type:      " + carType);
		System.out.println("Max Speed: " + maxSpeed);
		System.out.format("Distance:  %.3f\n", distanceTraveled);
		
	}
	
	public double getDistanceTraveled() {
		return distanceTraveled;
	}
	
	public String getDriverName() {
		return driverName;
	}
	
	public static void main(String[] args) {
		Racecar r = new Racecar("Moritz", "Ford Fiesta", 140);
		r.print();
		
		for(int i = 0; i < 5; i++){
			r.drive();
			r.print();
		}
		
	}

}
