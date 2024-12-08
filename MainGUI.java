package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	private JButton btnIdealWeight;
	private JButton btnBMR;
	private JButton btnCalorieIntake;
	private JButton btnWeightRecord;
	private JButton btnDiet;
	private JLabel lblTitle;

	public MainGUI() {
		getContentPane().setLayout(null);
		// Title
		lblTitle = new JLabel("Fitness Calculator", JLabel.CENTER);
		lblTitle.setFont(new Font("Georgia", Font.PLAIN, 16));
		lblTitle.setBounds(175, 10, 126, 33);
		getContentPane().add(lblTitle);
		contentPane = new JPanel();
		
		// Func1: Ideal Weight Calculator
		btnIdealWeight = new JButton("Ideal Weight Calculator");
		btnIdealWeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIdealWeight.setBounds(135, 65, 200, 50);
		getContentPane().add(btnIdealWeight);
		
		// Func2: Daily Basal Metabolic Rate (BMR) Calculator
		btnBMR = new JButton("BMR Caculator");
		btnBMR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBMR.setBounds(135, 130, 200, 50);
		getContentPane().add(btnBMR);
		
		// Func3: Daily Calorie Intake Planning
		btnCalorieIntake = new JButton("Calorie Intake Calculator");
		btnCalorieIntake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalorieIntake.setBounds(135, 195, 200, 50);
		getContentPane().add(btnCalorieIntake);
		
		// Func4: Daily Weight Record
		btnWeightRecord = new JButton("Weight Record");
		btnWeightRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWeightRecord.setBounds(135, 260, 200, 50);
		getContentPane().add(btnWeightRecord);
		
		// Func5: Food Calories Calculator(Planner)
		btnDiet = new JButton("Diet Planner");
		btnDiet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDiet.setBounds(135, 325, 200, 50);
		getContentPane().add(btnDiet);
		
		
		

	}
}
