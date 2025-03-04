package chapter9;

import javax.swing.JFrame;

public class Chapter9 {

	public static void main(String[] args) {

		JFrame starfieldFrame = new JFrame();
		starfieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StarfieldPanel starfieldPanel = new StarfieldPanel(1500);
		
		starfieldFrame.add(starfieldPanel);
		starfieldFrame.pack();
		starfieldFrame.setVisible(true);

		
		JFrame ballFrame = new JFrame();
		ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BallPanel ballPanel = new BallPanel(1000,800);
		
		ballFrame.add(ballPanel);
		ballFrame.pack();
		ballFrame.setVisible(true);
	
		ballPanel.start();
	}
}
