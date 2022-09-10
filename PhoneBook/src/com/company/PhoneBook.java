package com.company;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Dialog.ModalExclusionType;
public class PhoneBook extends JFrame {

    private JPanel contentPane;
    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PhoneBook frame;
                   frame = new PhoneBook();
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
    public PhoneBook() {
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        setTitle("PhoneBook");
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 810, 576);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
        panel.setBackground(Color.WHITE);
        panel.setBounds(0, 0, 794, 537);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblSukkurIbaUniversity = new JLabel("PHONE BOOK");
        lblSukkurIbaUniversity.setHorizontalAlignment(SwingConstants.CENTER);
        lblSukkurIbaUniversity.setFont(new Font("Cambria", Font.BOLD,30));
        lblSukkurIbaUniversity.setForeground(new Color(0, 0, 0));
        lblSukkurIbaUniversity.setBounds(60, 198, 686, 40);
        panel.add(lblSukkurIbaUniversity);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setBackground(Color.GRAY);
        lblNewLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("SIBAU.jpeg")));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(100, 22, 620, 170);
        panel.add(lblNewLabel);

        JButton Search = new JButton("");
        Search.setBorder(null);
        Search.setBackground(null);
        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("Search.png")));
        Search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Search s = new Search();
                s.setVisible(true);
            }


        });
        Search.setBackground(new Color(255, 255, 255));
        Search.setForeground(Color.WHITE);
        Search.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Search.setBounds(440, 233, 161, 179);
        panel.add(Search);

        JButton Add = new JButton("");
        Add.setBorder(null);
        Add.setBackground(null);
        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("Add.png")));
        Add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Add a = new Add();
                a.setVisible(true);
            }
        });
        Add.setForeground(Color.WHITE);
        Add.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Add.setBackground(new Color(255, 255, 255));
        Add.setBounds(47, 258, 167, 122);
        panel.add(Add);

        JButton Remove = new JButton("");
        Remove.setBackground(null);
        Remove.setBorder(null);
        Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("remove.png")));
        Remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Remove r = new Remove();
                r.setVisible(true);
            }
        });
        Remove.setForeground(Color.WHITE);
        Remove.setFont(new Font("Times New Roman", Font.BOLD,291 ));
        Remove.setBackground(new Color(255, 255, 255));
        Remove.setBounds(248, 258, 161, 129);
        panel.add(Remove);

        JButton Display = new JButton("");
        Display.setBackground(null);
        Display.setIcon(new javax.swing.ImageIcon(getClass().getResource("list.png")));
        Display.setBorder(null);
        Display.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Listall l  = new Listall();
                l.setVisible(true);
            }
        });
        Display.setForeground(Color.WHITE);
        Display.setFont(new Font("Times New Roman", Font.BOLD, 20));
        Display.setBackground(new Color(255, 255, 255));
        Display.setBounds(611, 258, 161, 119);
        panel.add(Display);

        JLabel lblNewLabel_1 = new JLabel("Add Contact");
        lblNewLabel_1.setFont(new Font("Urdu Typesetting", Font.BOLD, 19));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(48, 406, 166, 49);
        panel.add(lblNewLabel_1);

        JLabel lblRemoveContact = new JLabel("Remove Contact");
        lblRemoveContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblRemoveContact.setFont(new Font("Urdu Typesetting", Font.BOLD, 19));
        lblRemoveContact.setBounds(243, 406, 166, 49);
        panel.add(lblRemoveContact);

        JLabel lblSearchContact = new JLabel("Search Contact");
        lblSearchContact.setHorizontalAlignment(SwingConstants.CENTER);
        lblSearchContact.setFont(new Font("Urdu Typesetting", Font.BOLD, 19));
        lblSearchContact.setBounds(435, 406, 166, 49);
        panel.add(lblSearchContact);

        JLabel lblViewAll = new JLabel("View All\r\n");
        lblViewAll.setHorizontalAlignment(SwingConstants.CENTER);
        lblViewAll.setFont(new Font("Urdu Typesetting", Font.BOLD, 19));
        lblViewAll.setBounds(611, 406, 166, 49);
        panel.add(lblViewAll);



        tree data= new tree();

        if (data.changed) {

            System.out.println("Saving phone directory changes to file " +
                    data.dataFile.getAbsolutePath() + " ...");
            PrintWriter out;
            try {
                out = new PrintWriter( new FileWriter(data.dataFile) );
            }
            catch (IOException e) {
                System.out.println("ERROR: Can't open data file for output.");
                return;
            }
            for ( Map.Entry<String,String> entry : data.phoneBook.entrySet() )
                out.println(entry.getKey() + "%" + entry.getValue() );
            out.close();
            if (out.checkError())
                System.out.println("ERROR: Some error occurred while writing data file.");
            else
                System.out.println("Done.");
        }
    }
}
