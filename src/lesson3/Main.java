package lesson3;

public class Main {
    private static final double CONV_F = 0.5556;
    private static final double CONV_C = 1.8;
    public static void main(String[] args) {
        System.out.println("Converter App.");
        System.out.println("Version 1.2.");
        double fhrnht = 68;
        double clss = 20;
        double clssFromFhrnht = convFhrnhtToClss(fhrnht);
        double fhrnhtFromClss = convClssToFhrnht(clss);
        System.out.println("Result is " + clssFromFhrnht + " Celsius.");
        System.out.println("Result is " + fhrnhtFromClss + " Fahrenheit.");
    }

    private static double convFhrnhtToClss(double fhrnht) {
        return CONV_F * (fhrnht - 32);
    }
    private static double convClssToFhrnht(double clss) { return CONV_C * clss + 32;}
}
