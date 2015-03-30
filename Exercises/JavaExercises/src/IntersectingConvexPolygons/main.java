package IntersectingConvexPolygons;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    
    public boolean intersectingPolygon(Polygon p1 , Polygon p2){
       ArrayList<Point2D>  p1Points = new ArrayList<>();
        p1Points.addAll(Arrays.asList(p1.getPoints()));
        ArrayList<Point2D>  p2Points = new ArrayList<>();
        p2Points.addAll(Arrays.asList(p2.getPoints()));
        p1Points.add(p1Points.get(0));
        p2Points.add(p2Points.get(0));
        
        for(int i=0; i< p1Points.size() -1; i++)
        {
            for(int j=0; j< p2Points.size() -1; j++)
            {
                Line l1 = new Line(p1Points.get(i), p1Points.get(i+1));
                Line l2 = new Line(p2Points.get(j), p2Points.get(j+1));
                double D = l1.getA()*l2.getB() - l1.getB()*l2.getA();
                double Dx = l1.getC()*l2.getB() - l1.getB()*l2.getC();
                double Dy = l1.getA()*l2.getC() - l1.getC()*l2.getA();
                if(D == 0 )
                {
                    if(Dx!=0||Dy!=0)
                    {
                        continue;
                    }
                    if(Dx==0&&Dy==0)
                    {
                        return true;
                    }
                }
                if(isbetween(intersectingLines(l1,l1),p1Points.get(i),p1Points.get(i+1)))
                {
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public boolean pointInPolygon(Point2D point, Polygon polygon){
        Point2D maxPoint = MaxPointInPolygon(polygon);
        maxPoint.setLocation(maxPoint.getX()+10, maxPoint.getY()+20); 
        return false;
    }
    
    private boolean isbetween(Point2D pointCkeck,Point2D point1,Point2D point2){
        if(point1.getX() > pointCkeck.getX() && point2.getX() < pointCkeck.getX())
        {
            return true;
        }
        
        if(point1.getX() < pointCkeck.getX() && point2.getX() > pointCkeck.getX())
        {
            return true;
        }
        return false;
    }
    
    private Point2D intersectingLines(Line l1, Line l2)
    {
        Point2D result = new Point();
        double D = l1.getA()*l2.getB() - l1.getB()*l2.getA();
        double Dx = l1.getC()*l2.getB() - l1.getB()*l2.getC();
        double Dy = l1.getA()*l2.getC() - l1.getC()*l2.getA();
        if(D != 0)
        {
            result.setLocation(Dx/D,Dy/D);
            return result;
        }
        return null;
    }
    
    private Point2D MaxPointInPolygon(Polygon polygon){
        Point2D [] points = polygon.getPoints();
        Point2D resultPoint = null;
        resultPoint.setLocation(Double.MIN_VALUE, Double.MIN_VALUE);
        for (Point2D point : points) {
            if (resultPoint.getX() < point.getX()) {
                resultPoint.setLocation(point.getX(),resultPoint.getY());
            }
            if (resultPoint.getY() < point.getY()) {
                 resultPoint.setLocation(resultPoint.getX(),point.getY());
            }
        }
        return resultPoint;
    }
}
