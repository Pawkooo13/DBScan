package com.company;

import java.util.ArrayList;

public class Cluster {

    private final int MinPts;
    private final double Epsilon;
    ArrayList<Point> ListOfPoints;
    ArrayList<Point> ToCheckListOfPoints = new ArrayList<>();
    ArrayList<Point> cluster = new ArrayList<>();
    static ArrayList<Point> Noise = new ArrayList<>();
    ArrayList<Point> Seeds = new ArrayList<>();
    static ArrayList<ArrayList<Point>> result = new ArrayList<>();

    public Cluster(ArrayList<Point> ListOfPoints,final int MinPts,final double Epsilon){
        this.ListOfPoints = ListOfPoints;
        this.MinPts = MinPts;
        this.Epsilon = Epsilon;
        for(Point P : ListOfPoints) {
            ToCheckListOfPoints.add(P);
        }
    }

    public ArrayList<Point> getNoise(){
        return Noise;
    }

    private ArrayList<Point> NeighboursChecking(Point A){
        ArrayList<Point> List = new ArrayList<>();
        for (Point P : ToCheckListOfPoints) {
            if (Point.DistanceBetweenPoints(A, P) <= Epsilon) {
                List.add(P);
            }
        }
        return List;
    }

    private boolean ExpandCluster2(Point A){
        Seeds = NeighboursChecking(A);
        if(Seeds.size() < MinPts){
            Noise.add(A);
            return false;
        }else{
            ToCheckListOfPoints.remove(A);
            for (Point P : Seeds) {
                cluster.add(P);
            }
            Seeds.remove(A);
            while(Seeds.size() > 0){
                Point X = Seeds.get(0);
                ArrayList<Point> List = NeighboursChecking(X);
                if(List.size() >= MinPts){
                    for (Point P : List) {
                        if(!cluster.contains(P) && ToCheckListOfPoints.contains(P)) {
                            Seeds.add(P);
                        }
                        Noise.remove(P);
                    }
                }
                Noise.remove(X);
                Seeds.remove(X);
                ToCheckListOfPoints.remove(X);
                if(!cluster.contains(X)) {
                    cluster.add(X);
                }
            }
        }
        return true;
    }

    public ArrayList<ArrayList<Point>> DBScan(){
        for (Point P : ListOfPoints) {
            if(ToCheckListOfPoints.contains(P)){
                if(ExpandCluster2(P)){
                    ArrayList<Point> List = new ArrayList<>();
                    for (Point X : cluster) {
                        List.add(X);
                    }
                    result.add(List);
                    cluster.clear();
                }
            }
        }
        return result;
    }
}

