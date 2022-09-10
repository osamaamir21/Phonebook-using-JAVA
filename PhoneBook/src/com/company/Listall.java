package com.company;


import java.awt.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class Listall extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JTable table_1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Listall frame = new Listall();
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
    public Listall() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 634, 482);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 10));
        panel.setBounds(0, 0, 618, 443);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("View Data");
        btnNewButton.setBackground(Color.BLACK);
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String filePath = "C:\\Users\\ali\\Desktop\\table.txt";
                File file = new File(filePath);

                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    // get the first line
                    // get the columns name from the first line
                    // set columns name to the jtable model
                    String firstLine = br.readLine().trim();
                    String[] columnsName = firstLine.split(",");
                    DefaultTableModel model = (DefaultTableModel)table_1.getModel();
                    model.setColumnIdentifiers(columnsName);

                    // get lines from txt file
                    Object[] tableLines = br.lines().toArray();

                    // Extract data from lines
                    // set data to jtable model
                    for(int i = 0; i < tableLines.length; i++)
                    {
                        String line = tableLines[i].toString().trim();
                        String[] dataRow = line.split("/");
                        model.addRow(dataRow);
                    }


                } catch (Exception ex) {
                    // Logger.getLogger(TextFileDataToJTable.class.getName()).log(Level.SEVERE, null, ex);
                }



                tree data = new tree();
                JFrame f = new JFrame();

                if(data.name==null && data.number==null) {

                    JOptionPane.showMessageDialog(f, "There is No any Number in Contact Directory");

                }




                for ( Map.Entry<String,String> entry : tree.phoneBook.entrySet() ) {

                    // System.out.println("   " + entry.getKey() + ": " + entry.getValue() );
                }





            }
        });
        btnNewButton.setBounds(230, 45, 162, 23);
        panel.add(btnNewButton);

        JButton btnBack = new JButton("");
        btnBack.setBorder(null);
        btnBack.setBackground(null);
        Image img = new ImageIcon(this.getClass().getResource("back.png")).getImage();
        btnBack.setIcon(new ImageIcon(img));
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
        btnBack.setBounds(34, 27, 89, 71);
        panel.add(btnBack);

        table_1 = new JTable();
        table_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
        table_1.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                }
        ));
        table_1.setBounds(66, 116, 515, 238);
        panel.add(table_1);

    }
}

