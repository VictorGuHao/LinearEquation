public class QuadraticRoots
{
    ComplexNumber root1;
    ComplexNumber root2;

    public QuadraticRoots(double r1, double r2)
    {
        root1 = new ComplexNumber(r1, 0);
        root2 = new ComplexNumber(r2, 0);
    }

    public QuadraticRoots(ComplexNumber r1)
    {
        root1 = new ComplexNumber(r1.getRealMagnitude(), r1.getImaginaryMagnitude());
        root2 = new ComplexNumber(r1.getRealMagnitude(), -r1.getImaginaryMagnitude());
    }

    public ComplexNumber getRoot1()
    {
        return root1;
    }

    public ComplexNumber getRoot2()
    {
        return root2;
    }

    public String toString()
    {
        return "(" + root1.toString() + ", " + root2.toString() + ")";
    }

    public boolean areValid()
    {
        /*
        double real1 = root1.getRealMagnitude();
        double real2 = root2.getRealMagnitude();
        double imagin1 = root1.getImaginaryMagnitude();
        double imagin2 = root2.getImaginaryMagnitude();
        return (real1 == real2 && imagin1 == -imagin2) || (imagin1 == 0 && imagin2 == 0);
        */
        return (root1.getRealMagnitude() == root2.getRealMagnitude() && root1.getImaginaryMagnitude() == -root2.getImaginaryMagnitude()) || (root1.getImaginaryMagnitude() == 0 && root2.getImaginaryMagnitude() == 0);
    }
}
