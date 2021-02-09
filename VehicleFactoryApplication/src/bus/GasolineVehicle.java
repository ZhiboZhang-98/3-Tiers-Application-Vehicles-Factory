package bus;

import java.util.Scanner;

public class GasolineVehicle extends Vehicle implements IMileageEfficiency {
	private String name;
	private double fuelConsumed;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getFuelConsumed() {
		return fuelConsumed;
	}

	public void setFuelConsumed(double fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}

	public void makeTrip() {
		this.setTripCounter(100);
		this.setFuelConsumed(7.77);
	}
	
	public void makeTrip(long trip, double fuelConsumed) {
		this.setTripCounter(trip);
		this.setFuelConsumed(fuelConsumed);
	}

	public double getMilesPerGallon() {
		return (this.tripCounter/this.fuelConsumed);
	}
	
	public GasolineVehicle (String name, double fuelConsumed,long serialNumber, String made, EnumVehicleType type, long tripCounter ) {
		super(serialNumber, made, type, tripCounter);
		this.name = name;
		this.fuelConsumed = fuelConsumed;
	}
	
	public GasolineVehicle (String name, double fuelConsumed,long serialNumber, String made, EnumVehicleType type) {
		super(serialNumber, made, type);
		this.name = name;
		this.fuelConsumed = fuelConsumed;
	}
	
	public GasolineVehicle (String name, double fuelConsumed,long serialNumber, String made) {
		super(serialNumber, made);
		this.name = name;
		this.fuelConsumed = fuelConsumed;
	}
	
	public GasolineVehicle (String name, double fuelConsumed,long serialNumber) {
		super(serialNumber);
		this.name = name;
		this.fuelConsumed = fuelConsumed;
	}
	
	public GasolineVehicle (String name, long serialNumber) {
		super(serialNumber);
		this.name = name;
		this.fuelConsumed = 7.77;
	}
	
	public GasolineVehicle (long serialNumber) {
		super(serialNumber);
		this.name = "";
		this.fuelConsumed = 7.77;
	}
	
	public GasolineVehicle () {
		super();
		this.name = "";
		this.fuelConsumed = 7.77;
	}
	
	public String toString() {
		return " Vehicle Name: " + this.getName() + " " + super.toString() + "\n Fuel Consumed: " + this.getFuelConsumed() + " " + "\n Efficiency: " + this.getMilesPerGallon() +  " Km/Gal"; 
	}
	
	public static GasolineVehicle CreateGasolineVehicle()
	{
		boolean done = false;
		//public GasVehicle (String name, double fuelConsumed,long serialNumber, String made, EnumModel model, long tripCounter )
		Scanner scan = new Scanner(System.in);
		String strAnswer;
		int intAnswer;
		GasolineVehicle aVehicle = new GasolineVehicle();
		
		System.out.print("Enter Vehicle Name: ");
		aVehicle.setName(scan.next());
		
		System.out.print("\nEnter Serial Number: ");
		aVehicle.setSerialNumber(scan.nextLong());
		
		System.out.print("\nEnter Trip Counter: ");
		aVehicle.setTripCounter(scan.nextLong());
		
		System.out.print("\nEnter Fuel Consumed: ");
		aVehicle.setFuelConsumed(scan.nextDouble());
		
		System.out.print("\nEnter Made: ");
		aVehicle.setMade(scan.next());
		

		done =false;
		do {
			System.out.print("\nEnter Vehicle model \n1-SUV,\r\n" + 
					"2 -SuperCar,\r\n" + 
					"3- Sedan,\r\n" + 
					"4- SportClassic,\r\n" + 
					"5- MuscleCar,\r\n" + 
					"6- Van]: ");
			intAnswer = scan.nextInt();
			if (intAnswer >0 && intAnswer < 6) {
				aVehicle.setType(EnumVehicleType.values()[intAnswer]);
				done = true;
			} else {
				done = false;
			}
		
		} while (!done);
		
		System.out.print("\nAdding Vehicle: " + aVehicle.getName());
		System.out.println("\n... Done!\n");
		System.out.println(aVehicle.toString());
		return aVehicle;
	}
}
