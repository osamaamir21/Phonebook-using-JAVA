package com.company;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class Search extends JFrame {

    private JPanel contentPane;
    private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Search frame = new Search();
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
    public Search() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 590, 395);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
        panel.setBounds(0, 0, 569, 354);
        contentPane.add(panel);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(272, 176, 262, 32);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel = new JLabel("Insert name which you want to Search");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        lblNewLabel.setBounds(0, 26, 569, 39);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Name");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblNewLabel_1.setBounds(135, 177, 127, 21);
        panel.add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Search");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Logic For Search Button
                tree data= new tree();
                JFrame f = new JFrame();
                data.name = textField.getText().trim().toLowerCase();
                data.number = data.phoneBook.get(tree.name);
                if (data.number == null) {


                    JOptionPane.showMessageDialog(f, "No Number Found");
                }else {

                    JOptionPane.showMessageDialog(f, "Number For "+data.name+ " : "+data.number);
//		              System.out.println("\nNubmer for  " + data.name + " :  " + data.number);
                }
            }
        });
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(457, 299, 89, 23);
        panel.add(btnNewButton);

        JButton btnBack = new JButton("");
        btnBack.setBorder(null);
        btnBack.setBackground(null);
        btnBack.setIcon(new ImageIcon(getClass().getResource("back.png")));
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

        JLabel label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.RIGHT);
        label.setIcon(new ImageIcon(getClass().getResource("Search.png")));
        label.setBounds(40, 113, 127, 143);
        panel.add(label);
    }
}

