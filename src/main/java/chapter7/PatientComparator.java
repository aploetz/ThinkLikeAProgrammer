package chapter7;

import java.util.Comparator;

public class PatientComparator implements Comparator<Patient>{

	@Override
	public int compare(Patient p1, Patient p2) {

		if (p1.getPriority() > p2.getPriority()) {
			return 1;
		} else if (p1.getPriority() < p2.getPriority()) {
			return -1;
		} else {
			return 0;
		}
	}

}
