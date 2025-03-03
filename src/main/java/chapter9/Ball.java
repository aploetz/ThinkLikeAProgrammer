package chapter9;

import java.awt.Color;
import java.util.Random;

public class Ball {
	private boolean movingUp;
	private boolean movingLeft;
	private int xCoord;
	private int yCoord;
	private int size;
	private int speed;
	private Color color;
	
	public Ball(int size, int speed, int xCoord, int yCoord, Color color) {
		
		Random booleanDirection = new Random();
		movingLeft = booleanDirection.nextBoolean();
		movingUp = booleanDirection.nextBoolean();

		this.size = size;
		this.speed = speed;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.color = color;
	}

	public void update() {
		
		if (movingLeft) {
			xCoord -= speed;
		} else { 
			xCoord += speed;
		}
		
		if (movingUp) {
			yCoord -= speed;
		} else {
			yCoord += speed;
		}
	}
	
	public boolean isMovingUp() {
		return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
		this.movingUp = movingUp;
	}

	public boolean isMovingLeft() {
		return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.movingLeft = movingLeft;
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		this.yCoord = yCoord;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}
