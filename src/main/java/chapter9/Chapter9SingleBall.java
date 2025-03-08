package chapter9;

import javax.swing.JFrame;

public class Chapter9SingleBall {

	public static void main(String[] args) {
		
		JFrame ballFrame = new JFrame();
		ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BallPanel ballPanel = new BallPanel(1000,800);
		
		ballFrame.add(ballPanel);
		ballFrame.pack();
		ballFrame.setVisible(true);
	
		ballPanel.start();
	}
}
