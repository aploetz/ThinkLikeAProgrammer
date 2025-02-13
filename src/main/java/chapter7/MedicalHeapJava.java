package chapter7;

import java.util.PriorityQueue;

public class MedicalHeapJava {

	PriorityQueue<Patient> patientHeap;
	
	public MedicalHeapJava() {
		patientHeap = new PriorityQueue<>(new PatientComparator());
	}


	public MedicalHeapJava(Patient[] patientArray) {
		
		patientHeap = new PriorityQueue<>(new PatientComparator());
		
		for (Patient patient : patientArray) {
			patientHeap.add(patient);
		}
	}
	
	public void push(Patient patient) {
		patientHeap.add(patient);
	}
	
	public Patient pop() {
		return patientHeap.poll();
	}
	
	public String toString() {
		StringBuilder returnVal = new StringBuilder("[ ");
		boolean first = true;
		
		for (Patient patient : patientHeap) {
			
			if (!first) {
				returnVal.append(", ");
			} else {
				first = false;
			}

			returnVal.append(patient.getName());
			returnVal.append(":");
			returnVal.append(patient.getPriority());
		}
		returnVal.append(" ]");
		return returnVal.toString();
	}
}
