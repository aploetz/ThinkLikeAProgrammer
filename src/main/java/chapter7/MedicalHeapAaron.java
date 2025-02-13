package chapter7;

public class MedicalHeapAaron {

	Patient[] patientArray;
	int patientCount = 0;
	
	public MedicalHeapAaron() {
		this(10);
	}
	
	public MedicalHeapAaron(int arraySize) {
		this.patientArray = new Patient[arraySize];
	}
	
	public MedicalHeapAaron(Patient[] array, int patientCount) {
		this.patientArray = array;
		this.patientCount = patientCount;
		System.out.printf("Initial list: %s\n",this.toString());
		minHeapify();
	}
	
	public void push(Patient newPatient) {
		patientArray[patientCount] = newPatient;
		patientCount++;
		minHeapify();
		patientCount = verifyPatientCount(); 
	}
	
	public Patient pop() {
		Patient returnVal = patientArray[0];
		patientArray[0] = null;
		fixMinEmptyRoot();
		patientCount = verifyPatientCount();
		
		return returnVal;
	}
	
	public String toString() {
		StringBuilder returnVal = new StringBuilder("[ ");
		boolean first = true;
		for (int index = 0; index < patientCount; index++) {

			if (!first) {
				returnVal.append(", ");
			} else {
				first = false;
			}
			
			if (patientArray[index] != null) {
				returnVal.append(patientArray[index].getName());
				returnVal.append(":");
				returnVal.append(patientArray[index].getPriority());
			} else {
				returnVal.append("EMPTY");
			}
		}
		returnVal.append(" ]");
		return returnVal.toString();
	}
	
	// rearrange heap values with a preference on promoting the minimums
	private void minHeapify() {
		int index = 0;
		
		boolean leftChildValid = false;
		boolean rightChildValid = false;
		
		while (index < patientCount) {
			int leftChild = computeLeftChild(index);
			int rightChild = computeRightChild(index);
			
			if (leftChild < patientCount) {
				// leftChild is valid
				leftChildValid = true;
			} else {
				leftChildValid = false;
			}
			
			if (rightChild < patientCount) {
				// rightChild is valid
				rightChildValid = true;
			} else {
				rightChildValid = false;
			}
			
			int leftChildPriority = 9999;
			if (leftChildValid && patientArray[leftChild] != null) {
				leftChildPriority = patientArray[leftChild].getPriority();
			}
			
			int rightChildPriority = 9999;
			if (rightChildValid && patientArray[rightChild] != null) {
				rightChildPriority = patientArray[rightChild].getPriority();
			}
			
			if (leftChildValid && rightChildValid
					&& patientArray[leftChild] != null && patientArray[rightChild] != null) {
				// both leftChild and rightChild are valid
				if (leftChildPriority < rightChildPriority
						&& leftChildPriority < patientArray[index].getPriority()) {
					// leftChild priority is less than rightChild priority
					// leftChild priority is less than parent(index) priority 
					// promote and reset index counter! 
					promote(index, leftChild);
					index = 0;
				} else if (rightChildPriority < leftChildPriority
						&& rightChildPriority < patientArray[index].getPriority()){
					// rightChild priority is less than leftChild priority
					// rightChild priority is less than parent(index) priority
					// promote and reset index counter! 
					promote(index, rightChild);
					index = 0;
				} else {
					// no promotion at this level, so increment
					index++;
				}
			} else if ((leftChildValid && rightChildValid)
					&& (patientArray[leftChild] == null && patientArray[rightChild] != null)) {
				// leftChild is invalid/null, but rightChild is good
				if (rightChildPriority < patientArray[index].getPriority()) {
					// righttChild priority is less than parent(index) priority
					// promote and reset index counter! 
					promote(index, rightChild);
					index = 0;
				} else {
					index++;
				}
			} else if (leftChildValid && patientArray[leftChild] != null) {
				// at least rightChild is invalid
				if (leftChildPriority < patientArray[index].getPriority()) {
					// leftChild priority is less than parent(index) priority
					// promote and reset index counter! 
					promote(index, leftChild);
					index = 0;
				} else {
					// no promotion at this level, so increment
					index++;
				}
			} else {
				// both leftChild and rightChild are invalid
				// we are at a leaf, increment!
				index++;
			}
		}
	}
	
	private void fixMinEmptyRoot() {
		// root is null, "sift" root down
		int emptyIndex = 0;
		boolean leftChildValid = true;
		boolean rightChildValid = true;
		
		while (leftChildValid || rightChildValid) {
			
			int leftChild = computeLeftChild(emptyIndex); 
			int rightChild = computeRightChild(emptyIndex);
			
			if (leftChild < patientCount) {
				// leftChild is valid
				leftChildValid = true;
			} else {
				leftChildValid = false;
			}
			
			if (rightChild < patientCount) {
				// rightChild is valid
				rightChildValid = true;
			} else {
				rightChildValid = false;
			}

			if (leftChildValid && rightChildValid) {
				// both are valid
				if ((patientArray[leftChild] != null && patientArray[rightChild] != null)
						&& patientArray[leftChild].getPriority() < patientArray[rightChild].getPriority()) {
					// promote left
					patientArray[emptyIndex] = patientArray[leftChild];
					patientArray[leftChild] = null;
					emptyIndex = leftChild;
				} else {
					// promote right
					patientArray[emptyIndex] = patientArray[rightChild];
					patientArray[rightChild] = null;
					emptyIndex = rightChild;
				}
			} else if (leftChildValid) {
				// only left child is valid...promote!
				patientArray[emptyIndex] = patientArray[leftChild];
				patientArray[leftChild] = null;
				emptyIndex = leftChild;
			} else if (rightChildValid) {
				// only left child is valid...promote!
				patientArray[emptyIndex] = patientArray[rightChild];
				patientArray[rightChild] = null;
				emptyIndex = rightChild;
			}
		}
	}
	
	private int verifyPatientCount() {
		// NULLs can occur at leaf nodes, causing last patient to be dropped.
		// start counting from back. Stop at first valid patient.
		for (int index = patientArray.length - 1; index >= 0; index--) {
			if (patientArray[index] != null) {
				return index + 1;
			}
		}
		// if the list is completely empty, then return 0
		return 0;
	}
	
	private int computeLeftChild(int index) {
		return (index * 2) + 1;
	}

	private int computeRightChild(int index) {
		return (index * 2) + 2;
	}

	// promote from index2 to index1.
	private void promote(int index1, int index2) {
		Patient swap = patientArray[index1];
		patientArray[index1] = patientArray[index2];
		patientArray[index2] = swap;
	}
}
