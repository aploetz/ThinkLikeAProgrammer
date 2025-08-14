package chapter6;

public class Truck extends MotorVehicle {

	private int axles;
	private int cargoCapLbs;
	
	public Truck(String licensePlate, String make, String model, 
			int axles, int cargoCapLbs) {
		this.setLicensePlate(licensePlate);
		this.setMake(make);
		this.setModel(model);
		this.axles = axles;
		this.cargoCapLbs = cargoCapLbs;
	}
		
	public int getAxles() {
		return axles;
	}
	
	public void setAxles(int axles) {
		this.axles = axles;
	}

	public int getCargoCapLbs() {
		return cargoCapLbs;
	}
	
	public void setCargoCapLbs(int cargoCapLbs) {
		this.cargoCapLbs = cargoCapLbs;
	}
}
