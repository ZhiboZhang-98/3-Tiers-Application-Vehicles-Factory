package bus;

import java.util.Scanner;

public class ElectricVehicle extends Vehicle implements IMileageEfficiency {
	private String name;
	private double kwPowerConsumed;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getKwPowerConsumed() {
		return kwPowerConsumed;
	}

	public void setKwPowerConsumed(double kwPowerConsumed) {
		this.kwPowerConsumed = kwPowerConsumed;
	}

	public void makeTrip() {
		this.setTripCounter(100);
		this.setKwPowerConsumed(4.44);
	}
	
	public void makeTrip(long trip, double kwPowerConsumed) {
		this.setTripCounter(trip);
		this.setKwPowerConsumed(kwPowerConsumed);
	}

	public double getMilesPerGallon() {
		return (this.tripCounter/this.kwPowerConsumed);
	}
	
	public ElectricVehicle (String name, double kwPowerConsumed,long serialNumber, String made, EnumVehicleType type, long tripCounter ) {
		super(serialNumber, made, type, tripCounter);
		this.name = name;
		this.kwPowerConsumed = kwPowerConsumed;
	}
	
	public ElectricVehicle (String name, double kwPowerConsumed,long serialNumber, String made, EnumVehicleType type) {
		super(serialNumber, made, type);
		this.name = name;
		this.kwPowerConsumed = kwPowerConsumed;
	}
	
	public ElectricVehicle (String name, double kwPowerConsumed,long serialNumber, String made) {
		super(serialNumber, made);
		this.name = name;
		this.kwPowerConsumed = kwPowerConsumed;
	}
	
	public ElectricVehicle (String name, double kwPowerConsumed,long serialNumber) {
		super(serialNumber);
		this.name = name;
		this.kwPowerConsumed = kwPowerConsumed;
	}
	
	public ElectricVehicle (String name, long serialNumber) {
		super(serialNumber);
		this.name = name;
		this.kwPowerConsumed = 4.44;
	}
	
	public ElectricVehicle (long serialNumber) {
		super(serialNumber);
		this.name = "";
		this.kwPowerConsumed = 4.44;
	}
	
	public ElectricVehicle () {
		super();
		this.name = "";
		this.kwPowerConsumed = 4.44;
	}		
	
	public String toString() {
		return " Vehicle Name: " + this.getName() + " " + super.toString() + "\n KWP Consumed: " + this.getKwPowerConsumed() + " " + "\n Efficiency: " + this.getMilesPerGallon() +  " Km/KWP";
	}
	
	public static ElectricVehicle CreateElectricVehicle()
	{
		boolean done = false;
		//public GasVehicle (String name, double fuelConsumed,long serialNumber, String made, EnumModel model, long tripCounter )
		Scanner scan = new Scanner(System.in);
		String strAnswer;
		int intAnswer;
		ElectricVehicle aVehicle = new ElectricVehicle();
		
		System.out.print("Enter Vehicle Name: ");
		aVehicle.setName(scan.next());
		
		done = false;
		do {
			System.out.print("\nEnter Serial Number: ");
			strAnswer = scan.next();
			if (Validator.isLong(strAnswer)) {
				aVehicle.setSerialNumber(Long.parseLong(strAnswer));
				done = true;
			} else {
				System.out.println("Invalid Serial Number Format ");
			}
		} while (done == false);
		
		
		done = false ;
		do {
			System.out.print("\nEnter Trip Counter: ");
			strAnswer = scan.next();
			if (Validator.isLong(strAnswer)) {
				aVehicle.setTripCounter(Long.parseLong(strAnswer));
				done = true;
			} else {
				System.out.println("Invalid Trip Counter Format ");
			}		
		} while (done == false);
		
		
		done = false ;
		do {
			System.out.print("\nEnter KW Power Consumed: ");
			strAnswer = scan.next();
			if (Validator.isDouble(strAnswer)) {
				aVehicle.setKwPowerConsumed(Double.parseDouble(strAnswer));
				done = true;
			} else {
				System.out.println("Invalid KW Power Consumed Format ");
			}
		}while (done == false);
		
		
		System.out.print("\nEnter Made: ");
		aVehicle.setMade(scan.next());
		

		done =false;
		do {
			System.out.print("\nEnter Vehicle model \n1-SUV;\r\n" + 
					"2 -SuperCar;\r\n" + 
					"3- Sedan;\r\n" + 
					"4- SportClassic;\r\n" + 
					"5- MuscleCar;\r\n" + 
					"6- Van: ");
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
