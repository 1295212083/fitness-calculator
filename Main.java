package calculator;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		MainGUI main = new MainGUI();
		main.setTitle("Fitness Calculator");
		main.setBounds(400, 400, 500, 500);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setVisible(true);

	}

}
