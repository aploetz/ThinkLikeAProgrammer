package chapter5;

import java.util.UUID;

public class Chapter5 {

	public static void main(String[] args) {

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
		
		UUID id1 = UUID.randomUUID();
		Step step1 = new Step(id1, "After 0.1 miles, turn left onto Wuthering Hills Drive.");
		directions.addStep(step1);
		
		UUID id2 = UUID.randomUUID();
		Step step2 = new Step(id2, "After 1.3 miles, turn right onto Highway 11.");
		directions.addStep(step2);
		
		UUID id3 = UUID.randomUUID();
		Step step3 = new Step(id3, "After 0.3 miles, exit the roundabout onto the ramp for I-39S/I-90E.");
		directions.addStep(step3);
		
		UUID id4 = UUID.randomUUID();
		Step step4 = new Step(id4, "After 11 miles, you are now entering Illinois.");
		directions.addStep(step4);
		
		UUID id5 = UUID.randomUUID();
		Step step5 = new Step(id5, "After 1 mile, take exit 1 for IL-75W/US-51N, and turn right.");
		directions.addStep(step5);
		
		UUID id6 = UUID.randomUUID();
		Step step6 = new Step(id6, "After 1.2 miles, turn right onto US-51N. You are now entering Wisconsin.");
		directions.addStep(step6);
		
		UUID id7 = UUID.randomUUID();
		Step step7 = new Step(id7, "After 1.1 miles, turn right onto Pleasant St.");
		directions.addStep(step7);
		
		UUID id8 = UUID.randomUUID();
		Step step8 = new Step(id8, "After 350 feet, turn left onto East Grand Ave.");
		directions.addStep(step8);
		
		UUID id9 = UUID.randomUUID();
		Step step9 = new Step(id9, "After 0.2 miles, turn right onto 2nd St.");
		directions.addStep(step9);
		
		UUID id10 = UUID.randomUUID();
		Step step10 = new Step(id10, "After 350 feet, you have arrived at 705 3rd St. Beloit, WI.");
		directions.addStep(step10);
		
		Step currentStep = step1;
		while (currentStep != null) {
			System.out.printf("%s\n", currentStep.getDescription());
			currentStep = currentStep.getNextStep();
		}
		
		System.out.println();
	}

}
