package chapter5;

import java.util.UUID;

public class Chapter5 {

	public static void main(String[] args) {

		Stack truckStack = new Stack(8);
		truckStack.push("41A - Housewares");
		truckStack.push("22F - Personal Care");
		truckStack.push("93T - Toys and Games");
		truckStack.push("18J - Electronics");
		truckStack.push("18K - Electronics");
		truckStack.push("81D - Grocery (non-perishable)");

		System.out.printf("Next pallet is %s\n", truckStack.peek());
		
		System.out.printf("Unloading %s\n", truckStack.pop());
		System.out.printf("Unloading %s\n", truckStack.pop());
		System.out.printf("Unloading %s\n", truckStack.pop());
		System.out.printf("Unloading %s\n", truckStack.pop());

		System.out.printf("Next pallet is %s\n", truckStack.peek());

		System.out.printf("Unloading %s\n", truckStack.pop());
		System.out.printf("Unloading %s\n", truckStack.pop());
		System.out.printf("Unloading %s\n", truckStack.pop());
		
		System.out.println();
	
		Queue takeoff = new Queue(10);
		System.out.printf("Routing %s to takeoff runway.\n", takeoff.enqueue("DL2150"));
		System.out.printf("Routing %s to takeoff runway.\n", takeoff.enqueue("AA1822"));
		System.out.printf("Now taking off is %s, and %s is next.\n",
				takeoff.dequeue(), takeoff.getFront());
		System.out.printf("Routing %s to takeoff runway.\n", takeoff.enqueue("DL2205"));		
		System.out.printf("Routing %s to takeoff runway.\n", takeoff.enqueue("DL1141"));
		System.out.printf("Now taking off is %s, and %s is next.\n",
				takeoff.dequeue(), takeoff.getFront());
		System.out.printf("Routing %s to takeoff runway.\n", takeoff.enqueue("SW1004"));
		System.out.printf("Now taking off is %s, and %s is next.\n",
				takeoff.dequeue(), takeoff.getFront());
		
		System.out.println();

		LinkedList directions = new LinkedList();
		
		Step step1 = new Step(UUID.randomUUID(), "After 0.1 miles, turn left onto Wuthering Hills Drive.");
		Step step2 = new Step(UUID.randomUUID(), "After 1.3 miles, turn right onto Highway 11.");
		Step step3 = new Step(UUID.randomUUID(), "After 0.3 miles, exit the roundabout onto the ramp for I-39S/I-90E.");
		Step step4 = new Step(UUID.randomUUID(), "After 12 miles, take exit 1 for IL-75W/US-51N, and turn right.");
		Step step5 = new Step(UUID.randomUUID(), "After 1.2 miles, turn right onto US-51N. You are now entering Wisconsin.");
		Step step6 = new Step(UUID.randomUUID(), "After 1.1 miles, turn right onto Pleasant St.");
		Step step7 = new Step(UUID.randomUUID(), "After 350 feet, turn left onto East Grand Ave.");
		Step step8 = new Step(UUID.randomUUID(), "After 0.2 miles, turn right onto 2nd St.");
		Step step9 = new Step(UUID.randomUUID(), "After 350 feet, you have arrived at 705 3rd St.");

		directions.addStep(step1);
		directions.addStep(step2);
		directions.addStep(step3);
		directions.addStep(step4);
		directions.addStep(step5);
		directions.addStep(step6);
		directions.addStep(step7);
		directions.addStep(step8);
		directions.addStep(step9);
		
		printDirections(directions);
		
		System.out.println();
	}

	private static void printDirections(LinkedList directions) {

		Step currentStep = directions.getFirstStep();

		while (currentStep != null) {
			System.out.printf("%s\n", currentStep.getDescription());
			currentStep = currentStep.getNextStep();
		}
	}
}
