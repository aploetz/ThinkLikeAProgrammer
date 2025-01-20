package chapter5;

import java.util.UUID;

public class Step {
	private UUID id;
	private String description;
	private Step nextStep;
	
	public Step(UUID id, String desc) {
		this.id = id;
		this.description = desc;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Step getNextStep() {
		return nextStep;
	}

	public void setNextStep(Step nextStep) {
		this.nextStep = nextStep;
	}	
}
