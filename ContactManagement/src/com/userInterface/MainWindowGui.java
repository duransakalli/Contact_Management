package com.userInterface;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.test.initCall;

public class MainWindowGui extends JFrame implements initCall {


	public MainWindowGui() {
		initWindow();
		
	}

	public void initWindow() {
		
		JPanel panel = initPanel();
		JMenuBar bar = initBar();
		
		add(panel);
		setJMenuBar(bar);
		setTitle("Contact Management");
		setSize(350, 500);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());		
		JPanel findPanel = new JPanel();
		JPanel buttonPanel = new JPanel(new GridLayout(1,1));
		
		
		JTextField callField = new JTextField(25);
		findPanel.add(callField);
		JButton findButton = new JButton("Find");
		buttonPanel.add(findButton);
		JButton deleteButton = new JButton("Delete");
		buttonPanel.add(deleteButton);
		JButton editButton = new JButton("Edit");
		buttonPanel.add(editButton);
		
		JList contacts = new JList();
		JScrollPane pane = new JScrollPane(contacts);
		
		panel.add(pane,BorderLayout.CENTER);
		panel.add(findPanel, BorderLayout.NORTH);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		return panel;
	}

	public JMenuBar initBar() {
		JMenuBar bar = new JMenuBar();
		JMenu fileJMenu = new JMenu("File");
		bar.add(fileJMenu);
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new SaveGui();
				
			}
		});
		fileJMenu.add(saveItem);
		return bar;
	}
	
	
}
