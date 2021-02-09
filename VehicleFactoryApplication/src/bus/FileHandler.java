package bus;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler {
	public static void writeVehicleToFile(ArrayList<Vehicle> vehicleList) throws IOException
	{
		try {
			FileOutputStream fos = new FileOutputStream("vehicles.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);		
			oos.writeObject(vehicleList);
			System.out.println("\n .....Vehicle Factory Data Successfully Saved into File.....");
			} catch(Exception e) {
				System.out.println(".....Save to File Unsuccessfully.....");
			}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Vehicle> readVehicleFromFile() throws IOException, ClassNotFoundException
	{
		ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();
		
		FileInputStream fis = new FileInputStream("vehicles.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		vehicleList = (ArrayList<Vehicle>) ois.readObject();
		System.out.println("\n .....Vehicle Factory Data from File.....");
		for(Vehicle record : vehicleList)
		{
			System.out.println("-----------------------------------------");
			System.out.println(record);			
		}
		return vehicleList;
	}
}
