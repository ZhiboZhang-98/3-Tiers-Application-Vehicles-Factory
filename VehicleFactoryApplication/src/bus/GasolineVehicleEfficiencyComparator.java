package bus;

import java.util.Comparator;

public class GasolineVehicleEfficiencyComparator implements Comparator <GasolineVehicle> {
	public int compare (GasolineVehicle v1, GasolineVehicle v2) {
		if(v1.getFuelConsumed() > v2.getFuelConsumed()) { return -1;}
		else if (v1.getFuelConsumed() < v2.getFuelConsumed()) { return 1;}
		else return 0;
	}
}
