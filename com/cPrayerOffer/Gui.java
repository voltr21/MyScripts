package com.cPrayerOffer;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;

import com.cPrayerOffer.data.Constants;


@SuppressWarnings({"serial", "rawtypes", "unchecked"})
public class Gui extends JFrame {

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Big Bones", "Dragon Bones", "Frost Dragon Bones"}));
		contentPane.add(comboBox, BorderLayout.CENTER);
		
		lblCprayeroffer.setForeground(Color.DARK_GRAY);
		lblCprayeroffer.setFont(new Font("Southern Aire Personal Use Only", Font.PLAIN, 91));
		lblCprayeroffer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCprayeroffer.setBackground(Color.DARK_GRAY);
		contentPane.add(lblCprayeroffer, BorderLayout.NORTH);
		
		btnStartScript.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                StartButtonActionPerformed(e);
            }
        });
		btnStartScript.setBackground(Color.DARK_GRAY);
		btnStartScript.setForeground(Color.DARK_GRAY);
		contentPane.add(btnStartScript, BorderLayout.SOUTH);
	}
	
	private void StartButtonActionPerformed(java.awt.event.ActionEvent e) {
		switch (comboBox.getSelectedIndex()) {
		case 0:
			Constants.bonesId = 533;
			break;
		case 1:
			Constants.bonesId = 537;
			break;
		case 2:
			Constants.bonesId = 16571;
			break;
		default:
			break;
		}
		Constants.START = true;
        isRunning = false;
        setVisible(false);
	}
	
	private JPanel contentPane;
	JComboBox comboBox = new JComboBox();
	JLabel lblCprayeroffer = new JLabel("cPrayerOffer");
	JButton btnStartScript = new JButton("Start Script");
	boolean isRunning = true;
}
