package lesson3;

public class Main {
    private static final double CONV_F = 0.5556;

    public static void main(String[] args) {
        System.out.println("Converter App.");
        System.out.println("Version 1.2.");
        double fhrnht = 68;
        double clssFromFhrnht = convFhrnhtToClss(fhrnht);
        System.out.println("Result is " + clssFromFhrnht + " Fahrenheit.");
    }

    private static double convFhrnhtToClss(double fhrnht) {
        return CONV_F * (fhrnht - 32);
    }
}
