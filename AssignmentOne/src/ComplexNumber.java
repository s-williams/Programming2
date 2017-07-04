/**
 * Models a complex number
 */
public class ComplexNumber {
    private double real;
    private double imaginary;

    //Constructor
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    //Constructor with default values
    public ComplexNumber() {
        this.real = 0;
        this.imaginary = 0;
    }

    //Returns the complex number squared
    public ComplexNumber square() {
        double newReal = real * real - imaginary * imaginary;
        double newImag = 2 * real * imaginary;
        return new ComplexNumber(newReal, newImag);
    }

    //Returns the square of the modulus
    public double modulusSquared() {
        return Math.sqrt(real * real + imaginary * imaginary);
    }

    //Returns the addition of this complex number and the given complex number
    public ComplexNumber add(ComplexNumber complexNumber) {
        double newReal = complexNumber.getReal() + getReal();
        double newImag = complexNumber.getImaginary() + getImaginary();
        return new ComplexNumber(newReal, newImag);
    }

    //Prints the number
    public void getComplexNumber() {
        System.out.println(real + " + " + imaginary + "i");
    }

    //Sets real
    public void setReal(double real) {
        this.real = real;
    }

    //Sets imaginary
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    //Gets real
    public double getReal() {
        return real;
    }

    //Gets imaginary part
    public double getImaginary() {
        return imaginary;
    }
}