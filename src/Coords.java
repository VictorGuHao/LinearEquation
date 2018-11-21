import java.util.ArrayList;

public class Coords
{
    private double x;
    private double y;

    public Coords()
    {
        //this(0.0);
        x = 0.0;
        y = 0.0;
    }

    public Coords(double x)
    {
        this.x = x;
        y = x;
        //this(x , x);
    }

    public Coords(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Coords(Coords other)
    {
        //this(other.x, other.y);
        x = other.getX();
        y = other.getY();
        /*
        this.x = other.x;
        this.y = other.y;
         */
    }


    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public String toString()
    {
        return  "(" + x + ", " + y +")";
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public void reflectOnXAxis()
    {
        y = -y;
    }

    public void reflectOnYAxis()
    {
        x = -x;
    }

    public void reflectOnOrigin()
    {
        reflectOnYAxis();
        reflectOnXAxis();
    }

    public void translate(double horizontal, double vertical)
    {
        x = x + horizontal;
        y = y + vertical;
    }

    public void dilate(double dilationFactor)
    {
        x *= dilationFactor;
        y *= dilationFactor;
    }

    public double distanceFromOrigin()
    {
        return Math.sqrt(Math.pow(x, 2.0) + Math.pow(y,2.0));
    }

    public double distanceFrom(Coords other)
    {
        return Math.sqrt(Math.pow(other.x - this.x, 2.0) + Math.pow(other.y - this.y, 2.0));
    }

    public boolean equals(Coords other)
    {
        if (this.x == other.x && this.y == y)
        {
            return true;
        }
        return false;
    }

    public double getSlopeOfLineSegment(Coords other)
    {
        return ((other.y - this.y)/(other.x - this.x));
    }

    public boolean slopeOfLineSegmentDefined(Coords other)
    {
        return this.x != other.x;
    }

    public static Coords closestPointToOrigin(ArrayList<Coords> points)
    {
        Coords closestPoint = points.get(0);
        for (Coords p : points)
        {
            if (closestPoint.distanceFromOrigin() > p.distanceFromOrigin())
                closestPoint = p;
        }
        return closestPoint;
    }


    public Coords closestPoint(ArrayList<Coords> points)
    {
        Coords closestPoint = points.get(0);
        for (Coords p : points)
        {
            if (this.distanceFrom(closestPoint) > this.distanceFrom(p))
                closestPoint = p;
        }
        return closestPoint;
    }

    public int compareTo(Coords other)
    {
        if (this.x == other.x)
        {
            if (this.y > other.y)
                return 1;
            if (this.y < other.y)
                return -1;
            return 0;
        }
        if (this.x > other.x)
            return 1;
        return -1;
    }

    public int compareByDistanceFromOrigin(Coords other)
    {
        if (this.distanceFromOrigin() > other.distanceFromOrigin())
            return 1;
        if (this.distanceFromOrigin() < other.distanceFromOrigin())
            return -1;
        return 0;
    }

    public int compareByDistanceFromThis(Coords p1, Coords p2)
    {
        if (distanceFrom(p1) > distanceFrom(p2))
            return 1;
        if (distanceFrom(p1) < distanceFrom(p2))
            return -1;
        return 0;
    }

    public static void sortCoords(Coords[] arr)
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            int lowNumPos = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j].compareTo(arr[lowNumPos]) < 0)
                    lowNumPos = j;
            }
            swap(i, lowNumPos, arr);
        }
    }

    public static void sortByDistanceFromOrigin(Coords[] arr)
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            int lowNumPos = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[j].compareByDistanceFromOrigin(arr[lowNumPos]) < 0)
                    lowNumPos = j;
            }
            swap(i, lowNumPos, arr);
        }
    }

    public void sortByDistanceFromThis(Coords[] arr)
    {
        for(int i = 0; i < arr.length - 1; i++)
        {
            int lowNumPos = i;
            for (int j = i + 1; j < arr.length; j++)
            {
                if (compareByDistanceFromThis(arr[j], arr[lowNumPos]) < 0)
                    lowNumPos = j;
            }
            swap(i, lowNumPos, arr);
        }
    }

    private static void swap(int index1, int index2, Coords[] arr)
    {
        Coords temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public static void printCoords(Coords[] points)
    {
        for (Coords p : points)
            System.out.print(p + ", ");
        System.out.println();
    }
}
