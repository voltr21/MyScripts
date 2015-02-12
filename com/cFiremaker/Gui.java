package com.cFiremaker;

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

import com.cFiremaker.data.Constants;

@SuppressWarnings({"unchecked", "serial", "rawtypes"})
public class Gui extends JFrame {

	/**
	 * Create the frame.
	 */
	public Gui() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("cFiremaker");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setMaximumRowCount(3);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tree", "Oak", "Willow", "Maple", "Yew", "Magic"}));
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
			Constants.LOGS_ID = 1512;
			Constants.TREE_ID = 1276;
			break;
		case 1:
			Constants.LOGS_ID = 1522;
			Constants.TREE_ID = 1281;
			Constants.SEED_ID = 5313;
			break;
		case 2:
			Constants.LOGS_ID = 14616;
			Constants.TREE_ID = 1520;
			Constants.SEED_ID = 5314;
			break;
		case 3:
			Constants.LOGS_ID = 1518;
			Constants.TREE_ID = 1307;
			Constants.SEED_ID = 5315;
			break;
		case 4:
			Constants.LOGS_ID = 1516;
			Constants.TREE_ID = 1309;
			Constants.SEED_ID = 5316;
			break;
		case 5:
			Constants.LOGS_ID = 1514;
			Constants.TREE_ID = 1306;
			Constants.SEED_ID = 5317;
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
	private JLabel lblCpremiumcooker = new JLabel("cFiremaker");
	private JButton btnStartScript = new JButton("Start Script");
	boolean isRunning = true;

}