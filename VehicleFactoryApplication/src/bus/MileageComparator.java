package bus;

import java.util.Comparator;

public class MileageComparator implements Comparator <Vehicle> {
    public int compare (Vehicle m1, Vehicle m2) {
        if (m1.getTripCounter()  < m2.getTripCounter() ) {return 1;}
        else if (m1.getTripCounter() > m2.getTripCounter() ) {return -1;}
        else return 0;
    }  
}
