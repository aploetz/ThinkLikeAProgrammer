package chapter9;

import javax.swing.JFrame;

public class Chapter9MultipleBalls {

	public static void main(String[] args) {
		
		JFrame ballFrame = new JFrame();
		ballFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MultipleBallPanel ballPanel = new MultipleBallPanel(1000,800,20);
		
		ballFrame.add(ballPanel);
		ballFrame.pack();
		ballFrame.setVisible(true);
	
		ballPanel.start();
	}
}
