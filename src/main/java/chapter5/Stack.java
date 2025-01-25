package chapter5;

public class Stack {

	private int maxCount = 0;
	private int palletCount = 0;
	private String[] pallets;
	
	public Stack(int maxPallets) {
		this.maxCount = maxPallets;
		pallets = new String[maxPallets];
	}
	
	public int getPalletCount() {
		return palletCount;
	}
	
	public String peek() {
		if (palletCount > 0) {
			return pallets[palletCount - 1];
		} else {
			return "EMPTY";
		}
	}
	
	public String pop() {
		
		if (palletCount > 0) {
			palletCount--;
			return pallets[palletCount];
		} else {
			return "EMPTY";
		}
	}
	
	public void add(String pallet) {
		
		if (palletCount < maxCount) {
			pallets[palletCount] = pallet;
			palletCount++;
		}
	}
}
