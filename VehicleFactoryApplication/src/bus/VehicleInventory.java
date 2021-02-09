package bus;

import java.util.ArrayList;

public class VehicleInventory {
	private int id;
	private String name;
	private String address;
	private ArrayList<Vehicle> vehicleList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ArrayList<Vehicle> getVehicleList() {
		return vehicleList;
	}
	public void setVehicleList(ArrayList<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}
	
	public VehicleInventory (int id, String name, String address, ArrayList<Vehicle> vehicleList) {
	this.id =id;
	this.name = name;
	this.address = address;
	this.vehicleList = vehicleList;
	}
}
