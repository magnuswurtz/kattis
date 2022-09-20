import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import java.awt.geom.Point2D;

/**
 * Watchdog
 */
public class Watchdog {

    public static double distanceToClosestEdge(int size, Point2D point){
        double distance = point.getX();
        if (size - point.getX() < distance) {
            distance = size - point.getX();
        }
        if (size-point.getY() < distance) {
            distance = size-point.getY();
        }
        if(point.getY() < distance){
            distance = point.getY();
        }  
        return distance;
    }
    public static double distanceToFurthestHatch(Point2D point, List<Point2D> hatchPoints){
        double LongestDistance = 0;

        for (Point2D hatchPoint : hatchPoints) {
            double a = Math.abs(hatchPoint.getY()-point.getY());
            double b = Math.abs(hatchPoint.getX()-point.getX());
            double distance = Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2));

            if(distance > LongestDistance){
                LongestDistance = distance;
            }
        }
        return LongestDistance;
    }

    public static ArrayList<Point2D> determineLeashPoints(int size, List<Point2D> hatchPoints){
        ArrayList<Point2D> LeashPoints = new ArrayList<>();
        ArrayList<Point2D> CoordinatSystem = new ArrayList<>();
        
        for(int x = 0 ; x<=size ; x++){ //setup coordinatsystem
            for (int y = 0; y <=size ; y++) {
                CoordinatSystem.add(new Point2D.Double(x,y));
            }
        }
        for (Point2D point : CoordinatSystem) {
            if (distanceToClosestEdge(size, point)>=distanceToFurthestHatch(point, hatchPoints)){
                LeashPoints.add(point);
            }
        }
        return LeashPoints;
    }

    public static void printLeashPoints(List<Point2D> leashPoints, List<Point2D> HatchCoordinats){
        leashPoints.removeAll(HatchCoordinats);

        if(leashPoints.size() == 0){
            System.out.println("poodle");
        }else{
        leashPoints.sort(Comparator.comparing(Point2D::getX).thenComparing(Point2D::getY));
        int pointX = (int) leashPoints.get(0).getX();
        int pointY = (int) leashPoints.get(0).getY();
        System.out.println(pointX+ " " + pointY);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nCases = sc.nextInt();
        

        while (nCases>0) {
            List<Point2D> HatchCoordinats = new ArrayList<>();
            nCases--;
            int size = sc.nextInt();
            int nHatches = sc.nextInt();
            while (nHatches>0) {
                nHatches--;
                HatchCoordinats.add(new Point2D.Double(sc.nextInt(),sc.nextInt()));
            }
            List<Point2D> leashPoints = determineLeashPoints(size, HatchCoordinats);
            printLeashPoints(leashPoints, HatchCoordinats);
        }

        // List<Point2D> HatchCoordinats = new ArrayList<>();

        // HatchCoordinats.add(new Point2D.Double(6,6));
        // HatchCoordinats.add(new Point2D.Double(5,4));
        // List<Point2D> leashPoints = determineLeashPoints(10, HatchCoordinats);
        // printLeashPoints(leashPoints);
    }
}