package calculator.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import calculator.functions.DailyWeightRecord;

public class FoodCalorieGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFood;
	private JButton btnDelete;
	private JLabel lblFood;
	private JLabel lblg;
	private JLabel lblTotalCal;
	private JLabel lblResult;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnBack;
	private JTable table;
	private JLabel lblQuantity;
	private JTextField textQuantity;
	private JComboBox<String> boxSuggestion;
	private DefaultTableModel tableModel;
	private List<String> suggestions;
	private double total_cal;

	public FoodCalorieGUI() {
		total_cal = 0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblFood = new JLabel("Food:");
		lblFood.setBounds(90, 26, 46, 14);
		contentPane.add(lblFood);
		
		textFood = new JTextField();
		textFood.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> makeSuggestion());
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> makeSuggestion());
			}
			@Override
			public void changedUpdate(DocumentEvent e) {
				SwingUtilities.invokeLater(() -> makeSuggestion());
			}
		});
		textFood.setBounds(132, 23, 123, 20);
		contentPane.add(textFood);
		textFood.setColumns(10);
		
		suggestions = new ArrayList<>();
        suggestions.add("apple");
        suggestions.add("asperagus");
        suggestions.add("banana");
        suggestions.add("orange");
        suggestions.add("grape");
        suggestions.add("watermelon");
        
		boxSuggestion = new JComboBox<>();
		boxSuggestion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> insertSuggestion());
			}
		});
		boxSuggestion.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				boxSuggestion.setVisible(true);
			}
			@Override
			public void focusLost(FocusEvent e) {
				boxSuggestion.setVisible(false);
			}
		});
		boxSuggestion.setBounds(132, 43, 123, 20);
		contentPane.add(boxSuggestion);
		boxSuggestion.setVisible(false);
		boxSuggestion.setEditable(false);
		
		
		lblg = new JLabel("g");
		lblg.setBounds(242, 54, 22, 14);
		contentPane.add(lblg);
		
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
		btnDelete.setBounds(311, 335, 89, 23);
		contentPane.add(btnDelete);
		
		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click_save();
			}
		});
		btnSave.setBounds(57, 335, 99, 23);
		contentPane.add(btnSave);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click_back();
			}
		});
		btnBack.setBounds(187, 375, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 92, 343, 190);
		contentPane.add(scrollPane);
		
		String [] columnNames = {"Food", "Quantity(g)", "Calories(kcal)"};
		tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(72, 51, 59, 20);
		contentPane.add(lblQuantity);
		

		textQuantity = new JTextField();
		textQuantity.setBounds(132, 51, 100, 20);
		contentPane.add(textQuantity);
		textQuantity.setColumns(10);
		
		lblTotalCal = new JLabel("Total Calories: ");
		lblTotalCal.setBounds(57, 295, 99, 14);
		contentPane.add(lblTotalCal);
		
		lblResult = new JLabel("-");
		lblResult.setBounds(143, 295, 89, 14);
		contentPane.add(lblResult);
		
	}
	
	// Fill items in boxSuggestion and display if any matches
	public void makeSuggestion() {
		String input;
		input = textFood.getText();
		boxSuggestion.removeAllItems();
//		boxSuggestion.addItem("-");
		if (input.length() > 0){
			for (String item: suggestions) {
				if (item.toLowerCase().contains(input.toLowerCase())) {
					boxSuggestion.addItem(item);
				}
			}
		}
		if (boxSuggestion.getItemCount() > 0) {
			boxSuggestion.setVisible(true);
			boxSuggestion.setSelectedIndex(-1);
		}else {
			boxSuggestion.setVisible(false);
		}
	}
	
	// Insert the selected suggestion to the Textfield
	public void insertSuggestion() {
		if (boxSuggestion.getSelectedItem() != null) {
			textFood.setText((String)boxSuggestion.getSelectedItem());
			boxSuggestion.setVisible(false);
		}
		
	}
	// Always to remember update total_cal
	public void click_add() {
		
	}
	public void click_delete() {
		
	}
	public void click_save() {
		
	}
	public void click_back() {
		Main.mainGUI.setVisible(true);
		this.dispose();
	}
}
