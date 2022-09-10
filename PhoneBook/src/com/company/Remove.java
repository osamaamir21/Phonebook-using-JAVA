package com.company;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class Remove extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Remove frame = new Remove();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Remove() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 584, 392);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
        panel.setBounds(0, 0, 569, 354);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnBack = new JButton("");
        btnBack.setBorder(null);
        btnBack.setBackground(null);
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("back.png")));
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                PhoneBook p = new PhoneBook();
                p.setVisible(true);

            }
        });
        btnBack.setForeground(Color.WHITE);
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnBack.setBackground(null);
        btnBack.setBounds(28, 251, 89, 71);
        panel.add(btnBack);

        JLabel lblRemoveContact = new JLabel("Insert Name that you want to Remove");
        lblRemoveContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblRemoveContact.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblRemoveContact.setBounds(45, 24, 495, 50);
        panel.add(lblRemoveContact);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(316, 172, 224, 24);
        panel.add(textField);

        JButton button_1 = new JButton("Remove");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Logic for Remove Button
                tree data = new tree();
                JFrame f = new JFrame();
                tree.name = textField.getText().trim().toLowerCase();
                tree.number = tree.phoneBook.get(tree.name);
                if (tree.number == null)
                    JOptionPane.showMessageDialog(f, "Sorry, there is no entry for : "+tree.name);
                else {
                    tree.phoneBook.remove(tree.name);
                    tree.changed = true;
                    JOptionPane.showMessageDialog(f, "Directory entry removed for : "+tree.name);
                }
            }
        });
        button_1.setBounds(449, 281, 89, 29);
        panel.add(button_1);

        JLabel Remove = new JLabel("");
        Remove.setHorizontalAlignment(SwingConstants.CENTER);
        Remove.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("Remove.png")));
        Remove.setBounds(45, 102, 169, 138);
        panel.add(Remove);

        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.TRAILING);
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblName.setBounds(186, 172, 106, 24);
        panel.add(lblName);
    }
}

