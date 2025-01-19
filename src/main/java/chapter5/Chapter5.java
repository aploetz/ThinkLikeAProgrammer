package chapter5;

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
	}

}
