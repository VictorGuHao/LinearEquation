public class ComplexNumber
{
    private double a;
    private double b;

    public ComplexNumber(double realPart, double imaginaryPart)

    {
        a = realPart;
        b = imaginaryPart;
    }

    public ComplexNumber(ComplexNumber other)
    {
        this.a = other.a;
        this.b = other.b;
    }

    public double getRealMagnitude()
    {
        return a;
    }

    public double getImaginaryMagnitude()
    {
        return b;
    }

    public String toString()
    {
        return a + " + " + b + "i";
    }

    public void add(double scalar)
    {
        a = a + scalar;
    }

    public void add(ComplexNumber other)
    {
        this.a = this.a + other.b;
        this.b = this.b + other.b;
    }

    public void subtract(double scalar)
    {
        a = a - scalar;
    }

    public void subtract(ComplexNumber other)
    {
        this.a = this.a - other.a;
        this.b = this.b - other.b;
    }

    public void multiply(double scalar)
    {
        a = a * scalar;
        b = b * scalar;
    }

    public void multiply(ComplexNumber other)
    {
        double tempA = this.a * other.a - (this.b * other.b);
        double tempB = this.a * other.b + this.b * other.a;
        a = tempA;
        b = tempB;
    }

    public boolean divideBy(double scalar)
    {
        if (scalar == 0)
            return false;
        else
        {
            a = a / scalar;
            b = b / scalar;
            return true;
        }
    }

    public boolean divideBy(ComplexNumber other)
    {
        double c = other.a;
        double d = other.b;
        if (c == 0 && d == 0)
            return false;
        double tempA = (a * c + b * d) / (c * c + d * d);
        double tempB = (-a * d + c * b) / (c * c + d * d);
        a = tempA;
        b = tempB;
        return true;
    }
}
