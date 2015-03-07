package com.cPremiumCook;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import com.cPremiumCook.data.Constants;

@SuppressWarnings({"unchecked", "serial", "rawtypes"})
public class Gui extends JFrame {

	/**
	 * Create the frame.
	 */
	public Gui() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("cPremiumCooker");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Sharks", "Manta Ray", "Rocktails"}));
		comboBox.setSelectedIndex(0);
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(comboBox, BorderLayout.CENTER);
		
		lblCpremiumcooker.setForeground(Color.DARK_GRAY);
		lblCpremiumcooker.setFont(new Font("Southern Aire Personal Use Only", Font.PLAIN, 91));
		lblCpremiumcooker.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCpremiumcooker, BorderLayout.NORTH);
		
		btnStartScript.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                StartButtonActionPerformed(e);
            }
        });
		btnStartScript.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnStartScript.setForeground(Color.DARK_GRAY);
		contentPane.add(btnStartScript, BorderLayout.SOUTH);
	}
	
	private void StartButtonActionPerformed(java.awt.event.ActionEvent e) {
		switch (comboBox.getSelectedIndex()) {
		case 0:
			Constants.rawFish = 384;
			break;
		case 1:
			Constants.rawFish = 390;
			break;
		case 2:
			Constants.rawFish = 14616;
			break;
		default:
			break;
		}
		Constants.START = true;
        isRunning = false;
        setVisible(false);
	}
	
	private JPanel contentPane;
	private JComboBox comboBox = new JComboBox();
	private JLabel lblCpremiumcooker = new JLabel("cPremiumCooker");
	private JButton btnStartScript = new JButton("Start Script");
	boolean isRunning = true;

}
