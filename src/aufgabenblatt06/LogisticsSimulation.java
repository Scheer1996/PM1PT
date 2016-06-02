/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 19.05.2016 
 * Aufgabe: Aufgabenblatt 6 - Aufgabe 4
 */

package aufgabenblatt06;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main class for this project
 * 
 * Simulates a logistics network
 * 
 * @author Moritz Höwer
 */
public class LogisticsSimulation {

	// Constants to avoid "Magic Numbers"
	private final int TIMESTEP = 15;
	private final int ACTIVE_SHIPMENTS_TARGET = 20;

	private final int MINUTES_IN_HOUR = 60;
	private final String COLOR_RED = "\033[31m";
	private final String COLOR_GREEN = "\033[32m";
	private final String COLOR_RESET = "\033[0m";

	private final String STEP_STRING = "STEP";
	private final String QUIT_STRING = "END";

	/**
	 * list for storing the active shipments
	 */
	private LinkedList<MyShipmentWrapper> shipments;

	/**
	 * the global time for this simulation
	 */
	private int currentTime;

	/**
	 * flag for the simulator loop
	 */
	private boolean keepSimulating;

	/**
	 * DurationEstimator for calculating durations between the cities
	 */
	private ShipmentDurationEstimator durationEstimator;

	/**
	 * scanner for waitForInput()
	 */
	private Scanner scanner;

	// Constructor
	public LogisticsSimulation(boolean offlineMode) {
		shipments = new LinkedList<>();
		currentTime = 0;
		keepSimulating = false;
		durationEstimator = (offlineMode)
				? new OfflineShipmentDurationEstimator()
				: new GoogleShipmentDurationEstimator();
	}

	/**
	 * starts the simulator
	 */
	public void startSimulation() {
		shipments.clear();
		scanner = new Scanner(System.in);
		keepSimulating = true;

		// start simulation loop
		while (keepSimulating) {
			doTimestep();
			displayShipmentList();
			waitForInput();
		}
		scanner.close();
	}

	/**
	 * performs one timestep
	 */
	private void doTimestep() {
		// go through shipments list
		int activeShipments = 0;
		for (Iterator<MyShipmentWrapper> it = shipments.iterator(); it
				.hasNext();) {
			MyShipmentWrapper s = it.next();

			// make all the new shipments from last tick normal
			if (s.displayState == ShipmentDisplayState.NEW) {
				s.displayState = ShipmentDisplayState.NORMAL;
			}

			// count active shipments
			if (s.displayState == ShipmentDisplayState.NORMAL) {
				activeShipments++;
			}
			// remove shipments that have been delivered in the last tick
			else if (s.displayState == ShipmentDisplayState.DELIVERED) {
				it.remove();
				System.out.println("Removed");
			}
		}

		// add new shipments (if necessary)
		for (int i = activeShipments; i < ACTIVE_SHIPMENTS_TARGET; i++) {
			addShipment();
			System.out.println("Added");
		}

		// advance time
		currentTime += TIMESTEP;
		for (MyShipmentWrapper s : shipments) {
			// update time for shipment
			s.shipment.updateTime(currentTime);

			// check whether shipment has been delivered
			if (s.shipment.isDelivered()) {
				s.displayState = ShipmentDisplayState.DELIVERED;
			}
		}
	}

	/**
	 * adds a random shipment to the list
	 */
	private void addShipment() {
		// create 2 random cities
		City city1 = City.values()[getRandomNumberInInterval(0,
				City.values().length - 1)];
		City city2 = City.values()[getRandomNumberInInterval(0,
				City.values().length - 1)];

		// create dummy people for the cities
		Person p1 = new Person(new Address("Strasse", 1, 11111, city1));
		Person p2 = new Person(new Address("Strasse", 2, 22222, city2));

		// create shipment
		Shipment s;
		if (getRandomNumberInInterval(0, 1) == 0) {
			s = new Package(p1, p2, currentTime, durationEstimator
					.getShipmentTransportDuration(city1, city2), 2);
		} else {
			s = new Letter(p1, p2, currentTime, durationEstimator
					.getShipmentTransportDuration(city1, city2), false);
		}

		// add shipment to list (using Wrapper)
		shipments.add(new MyShipmentWrapper(s));
	}

	/**
	 * generates a random number between a and b INCLUDING a and b using
	 * Math.random()
	 * 
	 * a and b must be positive
	 * 
	 * @param a
	 *            lower interval boundary (INCLUDED)
	 * @param b
	 *            upper interval boundary (INCLUDED)
	 * @return a random number between a and b
	 */
	private int getRandomNumberInInterval(int a, int b) {
		// error cases
		if (a < 0 || b < 0) {
			throw new IllegalArgumentException("Numbers must be positive");
		}

		// special case: a and b are equal
		if (a == b) {
			return a;
		}

		int min = Math.min(a, b);
		int max = Math.max(a, b);

		// calculate width of interval (+ 1 because we need to include b)
		int diff = max - min + 1;

		return (int) (Math.random() * diff) + min;
	}

	/**
	 * displays all current shipments as a table on the console
	 */
	private void displayShipmentList() {
		// sort list (by ETE ascending)
		shipments.sort(null);

		// use somewhat ugly code to clear the screen
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start()
					.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// print header with current time
		System.out.println(
				"=====================================================================================");
		System.out.println(
				"                                  Logistics Simulation                               ");
		System.out.println(
				"=====================================================================================");
		System.out.format("Current time is %02d:%02d \n",
				currentTime / MINUTES_IN_HOUR, currentTime % MINUTES_IN_HOUR);
		System.out.println();

		// print table header
		System.out.println(
				"      Type     |    Origin   |  Destination  |  Start  | Duration |  ETA  |    ETE   ");
		System.out.println(
				"---------------|-------------|---------------|---------|----------|-------|----------");

		// print data for all the shipments
		for (MyShipmentWrapper sw : shipments) {
			Shipment s = sw.shipment;

			String type = (s instanceof Package) ? "Package" : "Letter";
			int shipmentID = s.getShipmentID();
			String origin = s.sender.getAddress().getCity().toString();
			String destination = s.receiver.getAddress().getCity().toString();
			int start = s.getStartTime();
			int duration = s.getTransportDuration();
			int eta = start + duration;
			int ete = eta - currentTime;

			if (sw.displayState == ShipmentDisplayState.NORMAL) {
				System.out.format(
						" %7s (%03d) | %11s | %13s |  %02d:%02d  | %3d min  | %02d:%02d |  %3d min \n",
						type, shipmentID, origin, destination, start / MINUTES_IN_HOUR,
						start % MINUTES_IN_HOUR, duration,
						eta / MINUTES_IN_HOUR, eta % MINUTES_IN_HOUR, ete);
			} else if (sw.displayState == ShipmentDisplayState.DELIVERED) {
				System.out.format(
						COLOR_RED
								+ " %7s (%03d) | %11s | %13s |  %02d:%02d  | %3d min  | %02d:%02d | Delivered \n"
								+ COLOR_RESET,
						type, shipmentID, origin, destination, start / MINUTES_IN_HOUR,
						start % MINUTES_IN_HOUR, duration,
						eta / MINUTES_IN_HOUR, eta % MINUTES_IN_HOUR);
			} else if (sw.displayState == ShipmentDisplayState.NEW) {
				System.out.format(
						COLOR_GREEN
								+ " %7s (%03d) | %11s | %13s |  %02d:%02d  | %3d min  | %02d:%02d |  %3d min \n"
								+ COLOR_RESET,
						type, shipmentID, origin, destination, start / MINUTES_IN_HOUR,
						start % MINUTES_IN_HOUR, duration,
						eta / MINUTES_IN_HOUR, eta % MINUTES_IN_HOUR, ete);
			}
		}
	}

	/**
	 * waits for input from the user
	 */
	private void waitForInput() {
		while (true) {
			System.out.print("Please enter command (STEP or END): ");
			String command = scanner.nextLine().trim().toUpperCase();
			if (command.equals(QUIT_STRING)) {
				keepSimulating = false;
				return;
			} else if (command.equals(STEP_STRING)) {
				return;
			}
		}
	}

	/**
	 * @param args
	 *            Commandline args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LogisticsSimulation sim = new LogisticsSimulation(true);
		sim.startSimulation();

	}

	/**
	 * Wrapper to store some additional information along with the Shipment
	 * 
	 * Only used within this class. Additional Information used for display
	 */
	private class MyShipmentWrapper implements Comparable<MyShipmentWrapper> {

		/**
		 * the shipment
		 */
		public final Shipment shipment;

		/**
		 * the current display-state of the shipment
		 */
		public ShipmentDisplayState displayState;

		public MyShipmentWrapper(Shipment shipment) {
			this.shipment = shipment;
			displayState = ShipmentDisplayState.NEW;
		}

		@Override
		public int compareTo(MyShipmentWrapper o) {
			return (shipment.startTime + shipment.transportDuration)
					- (o.shipment.startTime + o.shipment.transportDuration);
		}
	}
	/**
	 * local enum for ShipmentDisplayState
	 */
	private enum ShipmentDisplayState {
		NEW, NORMAL, DELIVERED
	}
}
