package chapter5;

import java.util.UUID;

public class LinkedList {

	private Step firstStep;
	private Step lastStep;
	private int stepCount = 0;
	
	public void addStep(Step step) {
		
		if (stepCount > 0) {
			Step currentLast = lastStep;
			currentLast.setNextStep(step);
			lastStep = step;
		} else {
			setFirstStep(step);
		}
		
		stepCount++;
	}
	
	public Step getFirstStep() {
		return firstStep;
	}
	
	public Step removeStep(UUID id) {
		
		Step returnVal = null;
		Step currentStep = firstStep;
		Step previousStep = null;
		boolean found = false;
		int counter = 0;
		
		while (counter < stepCount) {
			
			if (currentStep.getId() == id) {

				returnVal = currentStep;
				found = true;
				break;
			}
			
			previousStep = currentStep;
			currentStep = currentStep.getNextStep();
		}
		
		if (found) {
			if (returnVal.getId().equals(firstStep.getId())) {
				firstStep = returnVal.getNextStep();
			} else {
				previousStep.setNextStep(returnVal.getNextStep());
			}
		}
		
		return returnVal;
	}
	
	private void setFirstStep(Step step) {
		
		firstStep = step;
		lastStep = step;
	}
}
