package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Point> ListOfPoints = Point.ListOfPoints(200,0,10);
        Cluster Cluster = new Cluster(ListOfPoints,15,1.5);
        ArrayList<ArrayList<Point>> result = Cluster.DBScan();
        ArrayList<Point> Noise = Cluster.getNoise();

        int counter=0;

        for(int i=0;i<result.size();i++) {
            counter = counter + result.get(i).size();
            System.out.println("Cluster: " + result.get(i).size());
        }

        System.out.println("Sum of clusters: " + counter);
        System.out.println("Noise: " + Noise.size());
        System.out.println("Total: " + (counter + Noise.size()));
        new MyFrame();

    }
}
