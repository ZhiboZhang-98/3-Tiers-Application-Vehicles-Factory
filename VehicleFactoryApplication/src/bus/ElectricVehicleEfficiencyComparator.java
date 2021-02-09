package bus;

import java.util.Comparator;

public class ElectricVehicleEfficiencyComparator implements Comparator <ElectricVehicle> {
	public int compare (ElectricVehicle v1, ElectricVehicle v2) {
		if(v1.getKwPowerConsumed() > v2.getKwPowerConsumed()) { return -1;}
		else if (v1.getKwPowerConsumed() < v2.getKwPowerConsumed()) { return 1;}
		else return 0;
	}
}
