package chapter9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.Random;

import javax.swing.JPanel;

public class BallPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 2043779718874812497L;
	private final int fPS = 60; // frames per second
	
	private int width;
	private int height;
	private Ball ball;
	private Thread panelThread;
	
	public BallPanel(int width, int height) {
		
		Random randomInts = new Random();
		this.width = width;
		this.height = height;
		
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
		
		this.panelThread = Thread.ofVirtual().unstarted(this);
		
		ball = new Ball(50, 10,
				randomInts.nextInt(0,width),
				randomInts.nextInt(0,height),
				Color.CYAN);
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
			
		g2.setColor(ball.getColor());
		g2.fillOval(ball.getxCoord(), ball.getyCoord(), ball.getSize(), ball.getSize());
		
		g2.dispose();
		
	}

	private void update() {
		checkCollision();
		ball.update();
	}
	
	private void checkCollision() {
		
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
	}
}
