package cThiever;

import cThiever.data.Constants;

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
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        comboBox.setBackground(Color.WHITE);
        comboBox.setForeground(Color.DARK_GRAY);
        comboBox.setMaximumRowCount(3);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bakers", "Fur", "Silver", "Gem"}));
        comboBox.setSelectedIndex(0);
        comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        contentPane.add(comboBox, BorderLayout.CENTER);

        JLabel lblcThiever = new JLabel("cThiever");
        lblcThiever.setForeground(Color.DARK_GRAY);
        lblcThiever.setFont(new Font("Southern Aire Personal Use Only", Font.PLAIN, 91));
        lblcThiever.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblcThiever, BorderLayout.NORTH);

        JButton btnStartScript = new JButton("Start Script");
        btnStartScript.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
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
                Constants.itemId = 1894;
                Constants.stallId = 2561;
                break;
            case 1:
                Constants.itemId = 6815;
                Constants.stallId = 2563;
                break;
            case 2:
                Constants.itemId = 1807;
                Constants.stallId = 2565;
                break;
            case 3:
                Constants.itemId = 1614;
                Constants.stallId = 2562;
                break;
            default:
                break;
        }
        Constants.START = true;
        isRunning = false;
        setVisible(false);
    }

    private JComboBox comboBox = new JComboBox();
    boolean isRunning = true;

}
