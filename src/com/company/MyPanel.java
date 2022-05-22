package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyPanel extends JPanel {

    Font font = new Font("BOLD",Font.BOLD,10);

    public MyPanel(){
        this.setBounds(0,50,600,600);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        final double width = Math.round(Point.max_x)-Math.round(Point.min_x);
        final double height = Math.round(Point.max_y)-Math.round(Point.min_y);
        final double x = 500/width;
        final double y = 500/height;

        final int a = (int) Math.floor(Point.min_x);
        final int b = (int) Math.floor(Point.min_y);

        for(int i=0;i<=width;i++){
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine((int)(50+(x*i)),50,(int)(50+(x*i)),550);
            g2d.setColor(Color.BLACK);
            g2d.setFont(font);
            g2d.drawString(String.valueOf((width+i+a)-width),(int)(50+(x*i)),565);
        }
        for(int i=0;i<=height;i++){
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawLine(50,(int) (50+(y*i)),550,(int)(50+(y*i)));
            g2d.setColor(Color.BLACK);
            g2d.setFont(font);
            g2d.drawString(String.valueOf(height-i+b),30,(int) (50+(y*i)));
        }
        for(int i=0;i<Cluster.result.size();i++){
            float red = new Random().nextFloat();
            float green = new Random().nextFloat();
            float blue = new Random().nextFloat();
            g2d.setColor(new Color(red,green,blue));
            for(int j=0;j<Cluster.result.get(i).size();j++){
                Point P = Cluster.result.get(i).get(j);
                g2d.fillOval((int) (45+((P.x-a)*x)),(int) (545-((P.y-b)*y)),10,10);
            }
        }
        for(int i=0;i<Cluster.Noise.size();i++){
            g2d.setColor(Color.BLACK);
            Point P = Cluster.Noise.get(i);
            g2d.drawRect((int) (45+((P.x-a)*x)),(int) (545-((P.y-b)*y)),10,10);
        }
    }
}
