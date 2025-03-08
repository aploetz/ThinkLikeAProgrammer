package chapter9;

import javax.swing.JFrame;

public class Chapter9Starfield {

	public static void main(String[] args) {

		JFrame starfieldFrame = new JFrame();
		starfieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		StarfieldPanel starfieldPanel = new StarfieldPanel(1500);
		
		starfieldFrame.add(starfieldPanel);
		starfieldFrame.pack();
		starfieldFrame.setVisible(true);
	}
}
