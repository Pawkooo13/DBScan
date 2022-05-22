package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Point{

    final double x;
    final double y;
    static double min_x=10000;
    static double max_x=-10000;
    static double min_y=10000;
    static double max_y=-10000;

    public Point(final double x , final double y){
        this.x=x;
        this.y=y;
    }

    public static double DistanceBetweenPoints(Point A,Point B){
        return Math.sqrt((B.x-A.x)*(B.x-A.x) + (B.y-A.y)*(B.y-A.y));
    }

    public static ArrayList<Point> ListOfPoints(int amount,double min, double max){
        ArrayList<Point> List = new ArrayList<>();
        for(int i=0;i<amount;i++){
            double x = ThreadLocalRandom.current().nextDouble(min, max);
            double y = ThreadLocalRandom.current().nextDouble(min, max);
            x = round(x);
            y = round(y);
            Point A = new Point(x,y);
            if(A.x < min_x){
                min_x=A.x;
            }
            if(A.x > max_x){
                max_x=A.x;
            }
            if(A.y < min_y){
                min_y=A.y;
            }
            if(A.y > max_y){
                max_y=A.y;
            }
            List.add(A);
        }
        return List;
    }

    private static double round(double number){
        number = number*100;
        number = Math.round(number);
        number = number/100;
        return number;
    }
}
