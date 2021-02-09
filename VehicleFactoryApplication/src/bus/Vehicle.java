package bus;

import java.util.ArrayList;
import java.util.Scanner;

import bus.EnumVehicleType;

import java.io.Serializable;

public class Vehicle implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3583021125433693673L;
	private long serialNumber;
	private String made;
	private EnumVehicleType type;
	protected long tripCounter;
	
	static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
	
	public long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getMade() {
		return made;
	}
	
	public void setMade(String made) {
		this.made = made;
	}
	public EnumVehicleType getType() {
		return type;
	}
	public void setType(EnumVehicleType type) {
		this.type = type;
	}
	public long getTripCounter() {
		return tripCounter;
	}
	public void setTripCounter(long tripCounter) {
		this.tripCounter = tripCounter;
	}
	
	public Vehicle findBySerialNum(ArrayList<Vehicle> vehiclelist,long serialNumber) {
			for(Vehicle aVehicle : vehiclelist) {
		        if(aVehicle.getSerialNumber()== serialNumber) {
		            return aVehicle;
		        }
		    }
		    return null;	
	}
	
	public Vehicle findByMad(ArrayList<Vehicle> vehiclelist,String made) {
		for(Vehicle aVehicle1 : vehiclelist) {
	        if(aVehicle1.getMade().matches(made)) {
	            return aVehicle1;
	        }
	    }
	    return null;	
}
	
	public Vehicle (long serialNumber, String made, EnumVehicleType type, long tripCounter) {
		this.serialNumber = serialNumber;
		this.made = made;
		this.type = type;
		this .tripCounter = tripCounter;
	}
	
	
	public Vehicle (long serialNumber, String made, EnumVehicleType type) {
		this.serialNumber = serialNumber;
		this.made = made;
		this.type = type;
		this .tripCounter = 100;
	}
	
	public Vehicle (long serialNumber, String made) {
		this.serialNumber = serialNumber;
		this.made = made;
		this.type = EnumVehicleType.Undefined;
		this .tripCounter = 100;
	}
	
	public Vehicle (long serialNumber) {
		this.serialNumber = serialNumber;
		this.made = "";
		this.type = EnumVehicleType.Undefined;
		this .tripCounter = 100;
	}
	
	public Vehicle () {
		this.serialNumber = 0;
		this.made = "";
		this.type = EnumVehicleType.Undefined;
		this .tripCounter = 100;
	}
	
	public String toString() {
		return " Serial Number: " + this.getSerialNumber() + "\n Made: " + this.getMade() + "\n Vehicle Type: " + this.getType() + "\n Trip Counter: " + this.getTripCounter();
	}
	
	public static void DeleteVeichle() {
		Scanner scan = new Scanner(System.in);
		long serialNumber;
		System.out.println("Enter Vehicle Serial Number: ");
		serialNumber=scan.nextLong();
		Vehicle aVehicle = new Vehicle();
		aVehicle = aVehicle.findBySerialNum(vehicleList, serialNumber); 
		if (aVehicle != null) {
			vehicleList.remove(aVehicle);
			System.out.println("Deleted Vehicle:\n" + aVehicle.toString() );
			aVehicle = null; //Garbage collect will take handle of it;
		} else {
			System.out.println("Vehicle Serial Number:" + serialNumber + " NOT FOUND!" );
		}
		
	}
	
	public static Vehicle findBySerialNumber() {
		
		GasolineVehicle aVehicle1 = new GasolineVehicle("Charger", 124, 100023, "Dodge",EnumVehicleType.Coupe, 87);
		GasolineVehicle aVehicle2 = new GasolineVehicle("Edge", 144, 100024, "Ford",EnumVehicleType.MuscleCar, 97);
		GasolineVehicle aVehicle3 = new GasolineVehicle("GT*", 344, 100025, "Ford",EnumVehicleType.Sedan, 207);
		GasolineVehicle aVehicle4 = new GasolineVehicle("300", 1344, 100026, "Chrysler",EnumVehicleType.SuperCar, 357);
		
		
		ElectricVehicle aVehicle5 = new ElectricVehicle("Civic", 1224, 100027, "Honda",EnumVehicleType.OffRoad, 307);
		ElectricVehicle aVehicle6 = new ElectricVehicle("Sierra", 1544, 100022, "GMC",EnumVehicleType.SportClassic, 907);
		ElectricVehicle aVehicle7 = new ElectricVehicle("Equinox", 3044, 100021, "Chevrolet",EnumVehicleType.SUV, 1207);
		ElectricVehicle aVehicle8 = new ElectricVehicle("XTS", 1344, 100028, "Cadillac",EnumVehicleType.Van, 357);
		
		
		vehicleList.add(aVehicle1);
		vehicleList.add(aVehicle2);
		vehicleList.add(aVehicle3);
		vehicleList.add(aVehicle4);
		vehicleList.add(aVehicle5);
		vehicleList.add(aVehicle6);
		vehicleList.add(aVehicle7);
		vehicleList.add(aVehicle8);
		
		Scanner scan = new Scanner(System.in);
		long serialNumber;
		System.out.println("Enter Vehicle Serial Number: ");
		serialNumber=scan.nextLong();
		Vehicle aVehicle = new Vehicle();
		aVehicle = aVehicle.findBySerialNum(vehicleList, serialNumber); 
		if (aVehicle != null) {
			return aVehicle;
		} else {
			return null;
		}
		
	}
}
