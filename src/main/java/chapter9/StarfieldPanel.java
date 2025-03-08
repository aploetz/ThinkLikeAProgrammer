package chapter9;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.util.Random;

import javax.swing.JPanel;

public class StarfieldPanel extends JPanel {

	private static final long serialVersionUID = 6361841055806902341L;
	private static final int WIDTH = 1000;
	private static final int HEIGHT = 800;
	private int stars;
	
	public StarfieldPanel(int stars) {
		
		this.stars = stars;
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.BLACK);
		this.setFocusable(true);
	
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.WHITE);
		Random randomInts = new Random();
		
		for (int starCounter = 0; starCounter < stars; starCounter++) {
			int x = randomInts.nextInt(0,WIDTH);
			int y = randomInts.nextInt(0,HEIGHT);
			g2.drawLine(x, y, x+1, y+1);
		}
		
		g2.fillOval(600, 100, 100, 100);
		g2.setColor(Color.BLACK);
		g2.fillOval(580, 90, 100, 100);
		
		g2.dispose();
	}
}
