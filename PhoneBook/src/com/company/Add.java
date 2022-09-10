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
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.util.*;
import javax.swing.border.LineBorder;

public class Add extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Add frame = new Add();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public Add() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 585, 393);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
        panel.setLayout(null);
        panel.setBounds(0, 0, 569, 354);
        contentPane.add(panel);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(280, 121, 245, 30);
        panel.add(textField);

        JLabel lblAdd = new JLabel("Insert Name and Number");
        lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdd.setForeground(Color.BLACK);
        lblAdd.setFont(new Font("Times New Roman", Font.BOLD, 36));
        lblAdd.setBounds(57, 33, 442, 39);
        panel.add(lblAdd);

        JLabel lblName = new JLabel("Name");
        lblName.setHorizontalAlignment(SwingConstants.CENTER);
        lblName.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblName.setBounds(144, 124, 119, 21);
        panel.add(lblName);

        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //Main Logic Behind Add Button/Function
                tree data= new tree();
                JFrame f = new JFrame();
                data.name =textField.getText().trim().toLowerCase();
                if(data.name.length()==0) {

                    JOptionPane.showMessageDialog(f, "Name Cannot be Blank");
                }
                else if (data.name.indexOf('%') >= 0) {

                    JOptionPane.showMessageDialog(f, "Name Cannot Contain the Character");
                }
                data.number= textField_1.getText().trim();
                if(data.number.length()==0) {

                    JOptionPane.showMessageDialog(f, "Number cannot be  Blank");
                }
                else {
                    data.phoneBook.put(data.name, data.number);
                    data.changed = true;
                }
                if(data.changed==true) {

                    JOptionPane.showMessageDialog(f, "Number Added Successfully");
                }
                else {

                    JOptionPane.showMessageDialog(f, "Error !! Number Note added");
                }


            }
        });
        btnAdd.setForeground(Color.WHITE);
        btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnAdd.setBackground(Color.BLUE);
        btnAdd.setBounds(451, 306, 89, 23);
        panel.add(btnAdd);

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
        btnBack.setForeground(null);
        btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
        btnBack.setBackground(null);
        btnBack.setBounds(28, 251, 89, 71);
        panel.add(btnBack);

        JLabel lblNewLabel = new JLabel("Number");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNewLabel.setBounds(179, 188, 75, 21);
        panel.add(lblNewLabel);

        textField_1 = new JTextField();
        textField_1.setBounds(280, 185, 245, 30);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel Add = new JLabel("");
        Add.setHorizontalAlignment(SwingConstants.CENTER);
        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("Add.png")));
        Add.setFont(new Font("Times New Roman", Font.BOLD, 17));
        Add.setBounds(34, 112, 135, 131);
        panel.add(Add);
    }
}