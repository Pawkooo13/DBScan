package com.company;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame{
    MyPanel panel;
    JLabel title;
    Font font = new Font("BOLD",Font.BOLD,30);

    public MyFrame(){
        panel = new MyPanel();
        this.setTitle("Wykres");
        this.setSize(620,700);
        this.setBackground(Color.WHITE);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        title = new JLabel();
        title.setBounds(0,0,620,50);
        title.setText("Klasteryzacja algorytmem DBScan");
        title.setFont(font);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.TOP);

        this.add(panel);
        this.add(title);
    }
}
