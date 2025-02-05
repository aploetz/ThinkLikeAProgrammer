package chapter6;

public class Truck extends MotorVehicle {

	private int axels;
	private int cargoCapLbs;
	
	public Truck(String licensePlate, String make, String model, 
			int axels, int cargoCapLbs) {
		this.setLicensePlate(licensePlate);
		this.setMake(make);
		this.setModel(model);
		this.axels = axels;
		this.cargoCapLbs = cargoCapLbs;
	}
		
	public int getAxels() {
		return axels;
	}
	
	public void setAxels(int axels) {
		this.axels = axels;
	}

	public int getCargoCapLbs() {
		return cargoCapLbs;
	}
	
	public void setCargoCapLbs(int cargoCapLbs) {
		this.cargoCapLbs = cargoCapLbs;
	}
}
