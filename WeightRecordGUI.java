package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.net.*;
import javax.swing.border.LineBorder;

public class WeightRecordGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textWeight;
	private JButton btnDelete;
	private JLabel lblWeight;
	private JLabel lblKg;
	private JButton btnAdd;
	private JButton btnViewTrend;
	private JButton btnBack;
	private JTable table;
	private JLabel lblDate;
	private JTextField textDate;

	public WeightRecordGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWeight = new JLabel("Weight:");
		lblWeight.setBounds(100, 26, 46, 14);
		contentPane.add(lblWeight);
		
		textWeight = new JTextField();
		textWeight.setBounds(156, 23, 100, 20);
		contentPane.add(textWeight);
		textWeight.setColumns(10);
		
		lblKg = new JLabel("kg");
		lblKg.setBounds(263, 26, 22, 14);
		contentPane.add(lblKg);
		

		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				click_add();
			}
		});
		btnAdd.setBounds(292, 36, 68, 23);
		contentPane.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click_delete();
			}
		});
		btnDelete.setBounds(177, 308, 89, 23);
		contentPane.add(btnDelete);
		
		btnViewTrend = new JButton("View Trend");
		btnViewTrend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click_view();
			}
		});
		btnViewTrend.setBounds(57, 308, 99, 23);
		contentPane.add(btnViewTrend);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click_back();
			}
		});
		btnBack.setBounds(286, 308, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 92, 318, 182);
		contentPane.add(scrollPane);
		
		String [] columnNames = {"Date", "Weight(kg)"};
		String [][] data = {{null, null}};
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		lblDate = new JLabel("Date:");
		lblDate.setBounds(110, 53, 33, 14);
		contentPane.add(lblDate);
		
		// You may also want add a date error checker here
		textDate = new JTextField();
		textDate.setText("yyyy-mm-dd");
		textDate.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				textDate.setText("");
			}

			@Override
			public void focusLost(FocusEvent e) {
				textDate.setText("yyyy-mm-dd");
			}
		});
		textDate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		textDate.setBounds(156, 54, 100, 20);
		contentPane.add(textDate);
		textDate.setColumns(10);
	}
	
	
	public void click_delete() {
		// TODO:
	}
	
	public void click_back() {
		Main.mainGUI.setVisible(true);
		this.dispose();
	}
	
	public void click_view() {
		// Click "view trend" button will invoke another page, and this is where we present the graph
		// TODO: Change lblGraph to and image to display the 
		JLabel lblGraph = new JLabel(" Graph here ");
		lblDate.setBounds(400, 500, 800, 800);
		JDialog graph = new JDialog(this, "Weight Trend Graph");
		graph.setBounds(400, 500, 800, 800);
		graph.getContentPane().add(lblGraph);
		graph.setVisible(true);
	}
	
	public void click_add() {
		// TODO:
	}
}

