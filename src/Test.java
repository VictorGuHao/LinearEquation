import java.util.ArrayList;
public class Test
{
    public static void main(String[] avg)
    {
        ArrayList<Coords> thePoints = new ArrayList<Coords>();
        Coords p1 = new Coords(0,5);
        Coords p2 = new Coords(1,5);
        Coords p3 = new Coords(-5,3);
        Coords p4 = new Coords(10,8);
        Coords p5 = new Coords(3,0);
        Coords p6 = new Coords(4,5);
        Coords p7 = new Coords(8,9);
        Coords p8 = new Coords(3,4);
        Coords p9 = new Coords(2,2);
        Coords p10 = new Coords(10,0);
        thePoints.add(p1);
        thePoints.add(p2);
        thePoints.add(p3);
        thePoints.add(p4);
        thePoints.add(p5);
        thePoints.add(p6);
        thePoints.add(p7);
        thePoints.add(p8);
        thePoints.add(p9);
        thePoints.add(p10);
        Coords closestToOrigin = Coords.closestPointToOrigin(thePoints);
        System.out.println(closestToOrigin);
        Coords anotherPoint = new Coords(20,15);
        Coords closestToAnother = anotherPoint.closestPoint(thePoints);
        System.out.println(closestToAnother);
        Coords[] testCoords = {new Coords(0,2), new Coords(1,5), new Coords(5,10), new Coords(15,20), new Coords(2,5), new Coords(0,50)};
        Coords.printCoords(testCoords);
        Coords.sortCoords(testCoords);
        Coords.printCoords(testCoords);
        Coords.sortByDistanceFromOrigin(testCoords);
        Coords.printCoords(testCoords);
        p1.sortByDistanceFromThis(testCoords);
        Coords.printCoords(testCoords);
        p10.sortByDistanceFromThis(testCoords);
        Coords.printCoords(testCoords);
    }
}
