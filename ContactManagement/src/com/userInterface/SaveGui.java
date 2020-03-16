package com.userInterface;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.db.DerbyjdbcConnectionDb;
import com.domain.PhoneDomain;
import com.test.initCall;

public class SaveGui extends JDialog implements initCall{
	
	DerbyjdbcConnectionDb connect = new DerbyjdbcConnectionDb();
	PhoneDomain newRecord = new PhoneDomain();

	public SaveGui() {
		initWindow();
	}

	public void initWindow() {
		
		JPanel panel = initPanel();
		
		add(panel);
		setTitle("Save");
		pack();
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}

	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(4,2));
		
		JLabel FnameLabel = new JLabel("First Name: ",JLabel.RIGHT);
		panel.add(FnameLabel);
		final JTextField FnameField = new JTextField(15);
		panel.add(FnameField);
		JLabel LNameLabel = new JLabel("Last Name: ",JLabel.RIGHT);
		panel.add(LNameLabel);
		final JTextField LnameField = new JTextField(15);
		panel.add(LnameField);
		JLabel PhoneLabel = new JLabel("Phone Number: ",JLabel.RIGHT);
		panel.add(PhoneLabel);
		final JTextField phoneField = new JTextField(15);
		panel.add(phoneField);
		
		JButton saveButton = new JButton("Save");
		panel.add(saveButton);
		saveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				newRecord.setFname(FnameField.getText());
				newRecord.setLname(LnameField.getText());
				newRecord.setPhone(phoneField.getText());
				
				connect.newRecord(newRecord);
				
				JOptionPane.showMessageDialog(null, "Success");
				
			}
		});
		
		
		
		JButton cancelButton = new JButton("Cancel");
		panel.add(cancelButton);
		
		return panel;
	}

	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

}
