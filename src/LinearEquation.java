import javax.sound.sampled.Line;
import javax.swing.plaf.PanelUI;

public class LinearEquation {
    private double a;
    private double b;
    private double c;

    public static boolean areValidParams(double a, double b) {
        if (a == 0.0 && b == 0.0)
            return false;
        return true;
    }

    LinearEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    LinearEquation(double slope, Coords point)
    {
        this(-slope, 1, slope * point.getX() - point.getY());
        /*
        a = -slope;
        b = 1;
        c = slope * point.getX() - point.getY();
        */
    }

    LinearEquation(Coords point1, Coords point2) {
        if (point1.getX() == point2.getX()) {
            a = 1;
            b = 0;
            c = -point1.getX();
        } else {
            a = (point1.getY() - point2.getY());
            b = (point1.getX() - point2.getX());
            c = (point1.getX() * point2.getY() - point2.getX() * point1.getY());
        }
    }

    LinearEquation(LinearEquation other)
    {
        this(other.a, other.b, other.c);
        /*
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
         */
    }

    LinearEquation(LinearEquation other, Coords point)
    {
        this(other.a / other.b, 1, -other.a / other.b * point.getX() - point.getY());
        /*
        a = other.a/other.b;
        b = 1;
        c = -other.a/other.b * point.getX() - point.getY();
        */
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

    public boolean slopeDefine() {
        return b != 0;
    }

    public boolean hasYIntercept()
    {
        return slopeDefine();
    }

    public boolean hasXInterceot()
    {
        return slope() != 0;
    }

    public double slope()
    {
        return -a/b;
    }

    public double yIntercept()
    {
        return -c/b;
    }

    public double xIntercept()
    {
        return -c/a;
    }

    public double slopeOfPerpendicularLine()
    {
        if (this.isVertical())
            return 0;
        return b/a;
    }

    public boolean isIncreasing()
    {
        return slope() > 0;
    }

    public boolean isDecreasing()
    {
        return slope() < 0;
    }

    public boolean isHorizontal()
    {
        return slope() == 0;
    }

    public boolean isVertical()
    {
        return !slopeDefine();
    }

    public boolean isAFunction()
    {
        return !isVertical();
    }

    public boolean isValidLinearEquation()
    {
        return a != 0 && b != 0;
    }

    public boolean isDirectVariation()
    {
        return c == 0;
    }

    public boolean equals(LinearEquation other)
    {
        if (this.isVertical() && other.isVertical() && this.xIntercept() == other.xIntercept())
            return true;
        if (this.slope() == other.slope() && this.yIntercept() == other.yIntercept())
            return true;
        return false;
    }

    public LinearEquation parallelLine(Coords point)
    {
        if (isVertical())
            return new LinearEquation(1,0, -point.getX());
        return new LinearEquation(this.slope(), point);
    }

    public LinearEquation perpendicularLine(Coords point)
    {
        if (isVertical())
            return new LinearEquation(0,1, -point.getY());
        if (isHorizontal())
            return new LinearEquation(1, 0, -point.getX());
        return new LinearEquation(this.slopeOfPerpendicularLine(), point);
    }

    public boolean isPerpendicular(LinearEquation other)
    {
        if (this.isVertical() && other.isHorizontal())
            return true;
        if (this.isHorizontal() && other.isVertical())
            return true;
        if (this.slopeOfPerpendicularLine() == other.slope())
            return true;
        return false;
    }

    public boolean isParallel(LinearEquation other)
    {
        if (this.isVertical() && other.isVertical())
            return true;
        if (this.slope() == other.slope())
            return true;
        return false;
    }

    public Coords pointOfIntersection(LinearEquation other)
    {
        if (isVertical() && other.isHorizontal())
            return new Coords(xIntercept(), other.yIntercept());
        if (isHorizontal() && other.isVertical())
            return new Coords(yIntercept(), xIntercept());
        else
        {
            double d = other.a;
            double e = other.b;
            double f = other.c;
            double x = (f * e - c * e)/(a * e - b * d);
            double y = (a * f - c * d)/(b * d - a * e);
            return new Coords(x, y);
        }
    }

    public double shortestDistanceFrom(Coords point)
    {
        return  point.distanceFrom(pointOfIntersection(perpendicularLine(point)));
    }

    public LinearEquation inverseFunction()
    {
        return new LinearEquation(b, a, c);
    }

    public String toString()
    {
        String equation = "";
        equation = a + "x + " + b + "y + " + c + " = 0";
        return equation;
    }

    public String getSlopeInterceptForm()
    {
        if (isVertical())
            return "There is no slope intercept form for this equation.";
        return "y = " + slope() + "x +" + yIntercept();
    }
}
