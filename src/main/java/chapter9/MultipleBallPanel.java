package chapter9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class MultipleBallPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 2043779718874812497L;
	private final int fPS = 60; // frames per second
	
	private int width;
	private int height;
	private Thread panelThread;
	
	private List<Ball> ballList;
	private Random randomInts;
	
	public MultipleBallPanel(int width, int height, int numBalls) {
		
		randomInts = new Random();
		ballList = new ArrayList<>();
		
		this.width = width;
		this.height = height;
		
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.black);
		this.setFocusable(true);
		
		this.panelThread = Thread.ofVirtual().unstarted(this);
		
		
		for (int ballCounter = 0; ballCounter < numBalls; ballCounter++) {
			
			ballList.add(new Ball(50, 10,
					randomInts.nextInt(0,width),
					randomInts.nextInt(0,height),
					randomColor()));
		}
	}
	
	@Override
	public void run() {

		while (panelThread.isAlive()) {
			update();
			repaint();
			
			// compute pauses based on frames per second
			try {
				Thread.sleep(1000 / fPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void start() {
		panelThread.start();
	}

	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		for (Ball ball : ballList) {
			g2.setColor(ball.getColor());
			g2.fillOval(ball.getxCoord(), ball.getyCoord(), ball.getSize(), ball.getSize());
		}
		
		g2.dispose();
	}

	private Color randomColor() {

		int red = randomInts.nextInt(0, 256);
		int green = randomInts.nextInt(0, 256);
		int blue = randomInts.nextInt(0, 256);
		
		
		return new Color(red,green,blue);
	}
	
	private void update() {
		for (Ball ball : ballList) {
			checkCollision(ball);
			ball.update();
		}
	}
	
	private void checkCollision(Ball ball) {
		
		// check for panel edge/wall collision
		if (ball.getxCoord() <= 0 && ball.isMovingLeft()) {
			ball.setMovingLeft(false);
		} else if (ball.getxCoord() + ball.getSize() >= width && !ball.isMovingLeft()) {
			ball.setMovingLeft(true);
		}
		
		if (ball.getyCoord() <= 0 && ball.isMovingUp()) {
			ball.setMovingUp(false);
		} else if (ball.getyCoord() + ball.getSize() >= height && !ball.isMovingUp()) {
			ball.setMovingUp(true);
		}
		
		// check for collision with other balls
		for (Ball otherBall : ballList) {
			
			// use color as a uniqueness check,
			// make sure we're not checking the ball for colliding with itself
			// take the size of the ball into account,
			// as well as the fact that the ball is drawn from its upper-left corner
			if (otherBall.getColor() != ball.getColor()) {
				if (ball.getxCoord() <= otherBall.getxCoord() + ball.getSize()
						&& ball.getxCoord() >= otherBall.getxCoord()
						&& ball.getyCoord() <= otherBall.getyCoord() + ball.getSize()
						&& ball.getyCoord() >= otherBall.getyCoord()) {
					if (ball.isMovingLeft()) {
						ball.setMovingLeft(false);
					} else {
						ball.setMovingLeft(true);
					}
					
					if (ball.isMovingUp()) {
						ball.setMovingUp(false);
					} else {
						ball.setMovingUp(true);
					}
				}
			}
		}
	}
}
