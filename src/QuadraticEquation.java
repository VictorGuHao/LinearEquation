public class QuadraticEquation
{
    private double a;
    private double b;
    private double c;

    public QuadraticEquation()
    {
        a = 1;
        b = 0;
        c = 0;
    }

    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation(QuadraticEquation other)
    {
        this.a = other.a;
        this.b = other.b;
        this.c = other.c;
    }

    public QuadraticEquation(double coefficient, Coords vertex)
    {
        double h = vertex.getX();
        double k = vertex.getY();
        this.a = coefficient;
        this.b = -2 * a * h;
        this.c = h * h + k;
    }

    double getDiscriminant()
    {
        return (b * b) - (4 * a * c);
    }

    public boolean hasRealRoots()
    {
        return getDiscriminant() > 0;
    }

    public boolean hasEqualRoots()
    {
        return getDiscriminant() == 0;
    }

    public boolean hasMinimum()
    {
        return a > 0;
    }

    public boolean hasMaximum()
    {
        return a < 0;
    }

    public LinearEquation axisOfSymmetry()
    {
        return new LinearEquation(1, 0, b / (2 * a));
    }

    public Coords vertex()
    {
        double x = -b/(2 * a);
        double y = (a * x * x) + (b * x) + c;
        return new Coords(x, y);
    }

    public LinearEquation derivative()
    {
        return new LinearEquation(-2 * a, 1, -b);
    }

    public QuadraticRoots getRoots()
    {
        if(hasRealRoots())
        {
            return new QuadraticRoots((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a), (-b - Math.sqrt(b * b - 4 * a * c))/ (2 * a));
        }
        ComplexNumber imaginaryRoot = new ComplexNumber(-b/ (2 * a), Math.sqrt(Math.abs(b * b - 4 * a * c)) / (2 * a));
        return new QuadraticRoots(imaginaryRoot);
    }

    public String toString()
    {
        return "y = " + a + "x^2 + " + b + "x + " + c;
    }
}