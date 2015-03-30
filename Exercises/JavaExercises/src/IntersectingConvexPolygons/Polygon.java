package IntersectingConvexPolygons;

import java.awt.geom.Point2D;

public class Polygon {
    private final Point2D[] points;
    public  Polygon(Point2D [] points){
        this.points = points;
    }

    public Point2D[] getPoints() {
        return points ;
    }
    
}
