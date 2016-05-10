/*
 * Praktikum PM1 / PT - SS 2016
 * Gruppe:  Philip Scheer (Philip.Scheer@haw-hamburg.de),
 * 			Moritz Höwer (Moritz.Hoewer@haw-hamburg.de)
 * 
 * Datum: 06.05.2016 
 * Aufgabe: Aufgabenblatt 5 - Aufgabe 2
 */

package aufgabenblatt05;

/**
 * 
 * 
 *@author Moritz Höwer
 */
public class TrainApplication {

	private static final int LOCO1_TYPE = 1;
	private static final int LOCO1_LENGTH = 10;

	private static final int LOCO2_TYPE = 2;
	private static final int LOCO2_LENGTH = 20;

	private static final int WAGON1_CAPACITY = 1;
	private static final int WAGON1_LENGTH = 10;

	private static final int WAGON2_CAPACITY = 2;
	private static final int WAGON2_LENGTH = 20;

	/**
	 * tests the other classes
	 */
	private void test(){
		//Prepare
		Locomotive loco1 = new Locomotive(LOCO1_TYPE, LOCO1_LENGTH);
		Locomotive loco2 = new Locomotive(LOCO2_TYPE, LOCO2_LENGTH);

		Wagon wagon1 = new Wagon(WAGON1_CAPACITY, WAGON1_LENGTH);
		Wagon wagon2 = new Wagon(WAGON2_CAPACITY, WAGON2_LENGTH);

		Train train1 = new Train(loco1);
		Train train2 = new Train(loco2);

		System.out.println("Testing...");

		//Test Locomotive
		assert(loco1.getFirstWagon() == null);
		assert(loco1.getType() == LOCO1_TYPE);
		assert(loco1.getLength() == LOCO1_LENGTH);
		assert(loco1.getSerialNumber() + 1 == loco2.getSerialNumber());

		//Test Wagon
		assert(wagon1.getNextWagon() == null);
		assert(wagon1.getCapacity() == WAGON1_CAPACITY);
		assert(wagon1.getLength() == WAGON1_LENGTH);
		assert(wagon1.getSerialNumber() + 1 == wagon2.getSerialNumber());

		//Test Train
		assert(train1.getLength() == LOCO1_LENGTH);
		assert(train1.getPassengerCapacity() == 0);
		assert(train1.getWagonCount() == 0);

		train1.addWagon(wagon1);
		assert(loco1.getFirstWagon() == wagon1);
		assert(train1.getLength() == LOCO1_LENGTH + WAGON1_LENGTH);
		assert(train1.getPassengerCapacity() == WAGON1_CAPACITY);
		assert(train1.getWagonCount() == 1);

		train1.addWagon(wagon2);
		assert(wagon1.getNextWagon() == wagon2);
		assert(train1.getLength() == LOCO1_LENGTH + WAGON1_LENGTH + WAGON2_LENGTH);
		assert(train1.getPassengerCapacity() == WAGON1_CAPACITY + WAGON2_CAPACITY);
		assert(train1.getWagonCount() == 2);

		train2.appendTrain(train1);
		assert(train1.getLength() == LOCO1_LENGTH);
		assert(train1.getPassengerCapacity() == 0);
		assert(train1.getWagonCount() == 0);
		assert(loco1.getFirstWagon() == null);
		assert(loco2.getFirstWagon() == wagon1);
		assert(train2.getLength() == LOCO2_LENGTH + WAGON1_LENGTH + WAGON2_LENGTH);
		assert(train2.getPassengerCapacity() == WAGON1_CAPACITY + WAGON2_CAPACITY);
		assert(train2.getWagonCount() == 2);

		Wagon w = train2.removeFirstWagon();
		assert(w == wagon1);
		assert(loco2.getFirstWagon() == wagon2);
		assert(train2.getLength() == LOCO2_LENGTH + WAGON2_LENGTH);
		assert(train2.getPassengerCapacity() == WAGON2_CAPACITY);
		assert(train2.getWagonCount() == 1);


		System.out.println("done");
	}

	/**
	 * tries out the other classes
	 */
	private void tryIt(){
		Locomotive loco = new Locomotive(2, 10);
		Train train = new Train(loco);
		Train train2 = new Train(new Locomotive(3, 12));

		train2.addWagon(new Wagon(100, 20));	
		train2.addWagon(new Wagon(100, 20));	
		train2.addWagon(new Wagon(80, 23));	
		System.out.println(train2);

		train.appendTrain(train2);
		System.out.println(train2);
		System.out.println(train);

		Wagon w = train.removeFirstWagon();
		System.out.println(w);

		System.out.println(train);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//new TrainApplication().tryIt();
		new TrainApplication().test();
	}

}
