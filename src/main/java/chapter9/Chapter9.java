package chapter9;

import javax.swing.JFrame;

public class Chapter9 {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		BallPanel ballPanel = new BallPanel(1000,800);
		
		frame.add(ballPanel);
		frame.pack();
		frame.setVisible(true);
	
		ballPanel.start();
	}
}
