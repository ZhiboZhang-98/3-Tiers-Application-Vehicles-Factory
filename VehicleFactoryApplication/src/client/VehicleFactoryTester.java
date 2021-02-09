package client;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import bus.*;

public class VehicleFactoryTester {
	
	static ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public static Vehicle findBySerialNumber() {
		
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
	
	public static Vehicle findByMade() {
		
		Scanner scan2 = new Scanner(System.in);
		String made;
		System.out.println("Enter Vehicle Made: ");
		made=scan2.next();
		Vehicle aVehicle1 = new Vehicle();
		aVehicle1 = aVehicle1.findByMad(vehicleList, made); 
		if (aVehicle1 != null) {
			return aVehicle1;
		} else {
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		int result = 0; 
		
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
		
		VehicleInventory theInventory = new VehicleInventory(1,"Volkswagen","Strasser Volks",vehicleList);

		do {			
			System.out.println("\n     --- Welcome to Vehiche Inventory --- \n");
			System.out.println("               *Main Menu*\n" );
			System.out.println("\t<Press  1> List Vehicles:" );
			System.out.println("\t<Press  2> List Electric Vehicles:" );
			System.out.println("\t<Press  3> List Gasoline Vehicles:" );
			System.out.println("\t<Press  4> Add a Electric Vehicle:" );
			System.out.println("\t<Press  5> Add a Gasoline Vehicle:" );
			System.out.println("\t<Press  6> Search a Vehicle by Serial Number:" );
			System.out.println("\t<Press  7> Search a Vehicle by Brand:" );
			System.out.println("\t<Press  8> Delete a Vehicle:" );
			System.out.println("\t<Press  9> Sort the Vehicles by Mileage (in descending order):" );
			System.out.println("\t<Press 10> Save the Vehicle Factory List into a Serialized File:" );
			System.out.println("\t<Press 11> Load the Vehicle Factory List From the Serialized File:" );
			System.out.println("\t<Press 12> Quit the Application:" );
			System.out.println("--------------------------------------------------------------------------------");
			Scanner scan1 = new Scanner(System.in);
			result = (scan1.nextInt());
			switch (result) { 
				case 1:					
					System.out.println("**************Gasoline Vehicles*****************");
					vehicleList.forEach((vehicle) -> {					
					if(vehicle instanceof GasolineVehicle){
						System.out.println(vehicle);
						System.out.println("-----------------------------------------");
						}
					});
					System.out.println("\n**************Electric Vehicles*****************");
					vehicleList.forEach((vehicle) -> {					
					if(vehicle instanceof ElectricVehicle){
						System.out.println(vehicle);
						System.out.println("-----------------------------------------");
						}
					});
					break;
					
				case 2:	
					vehicleList.forEach((vehicle) -> {					
							if(vehicle instanceof ElectricVehicle)
							{
								System.out.println(vehicle);
								System.out.println("-----------------------------------------");
							}
					}); 
					break; 
				
				case 3:  
					vehicleList.forEach((vehicle) -> {					
						if(vehicle instanceof GasolineVehicle)
						{
							System.out.println(vehicle);
							System.out.println("-----------------------------------------");
						}
				});
					break;

				case 4:  // Insert a Electric Vehicle...	
					ElectricVehicle aVehicle = ElectricVehicle.CreateElectricVehicle();
					vehicleList.add(aVehicle);
					break;
					
				case 5:  // Insert a Gasoline Vehicle...	
					GasolineVehicle gasVehicle = GasolineVehicle.CreateGasolineVehicle();
					vehicleList.add(gasVehicle);
					break;
				
				case 6:
					Vehicle foundVehicle = findBySerialNumber();
					if (foundVehicle == null) {
						System.out.println(" Vehicle NOT FOUND!");
					} else {
						System.out.println(foundVehicle);
					}
					break;
					
				case 7:
					Vehicle foundVehicle1 = findByMade();
					if (foundVehicle1 == null) {
						System.out.println(" Vehicle NOT FOUND!");
					} else {
						System.out.println(foundVehicle1);
					}
					break;
				
				case 8:
					Vehicle.DeleteVeichle();
					break;
					
				case 9: 
					System.out.println("\nSorting the Vehice List by Mileage in Descending Order...");
					MileageComparator mileageComp = new MileageComparator();
					Collections.sort(vehicleList, mileageComp);
					vehicleList.forEach((vehicle) -> {					
						System.out.println(vehicle);
						System.out.println("-----------------------------------------");
					});
					break;
					
				case 10:
					FileHandler.writeVehicleToFile(vehicleList);
					break;
					
				case 11:
					vehicleList = FileHandler.readVehicleFromFile();
					break;
					
				case 12:
					System.out.print("Thanks for using Vehicles' Factory System!");
					break;
				
				default:
					break;
					
			}
			System.out.print("Press a key to END the Application...");
			String key = (scan1.next());
		}while (result != 12);
		
	}

}
