package IntersectingConvexPolygons;

import java.awt.geom.Point2D;


public class Line {
    //agetX()+bgetY()=c
    private final double a;
    private final double b;
    private final double c;
    public Line(Point2D param1, Point2D param2)
    {
        this.a = (param2.getY() - param1.getY());
        this.b = -(param2.getX() - param1.getX());
        this.c = (param2.getY() - param1.getY())*param1.getX() -(param2.getX() - param1.getX())*param1.getY();
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
    
}
