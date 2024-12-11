package calculator.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FoodCalorieGUI extends JFrame {
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FoodCalorieGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();


		setContentPane(contentPane);
	}

}
