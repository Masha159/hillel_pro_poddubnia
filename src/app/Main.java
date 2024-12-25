package app;

public class Main {
    private static final double CONV_K = 2.20462;
    private static final double CONV_M = 1.60934;

    public static void main(String[] args) {
        System.out.println("Converter App.");
        System.out.println("Version 1.0.");
        double kgs = 5;
        double pnds = 12;
        double mls = 10;
        double kms = 100;
        double pounds = convKgsToPounds(kgs);
        double kilos = convPoundsToKgs(pnds);
        double kilometers = convMlsToKms(mls);
        double miles = convKmsToMls(kms);

                System.out.println("Result is " + pounds + " pounds and "
                        + kilos + " kgs.");
        System.out.println("Result is " + kilometers + " kilometers and " + miles + " kilometers.");
    }


    private static double convKgsToPounds(double kgs) {
        return kgs * CONV_K;
    }

    private static double convPoundsToKgs(double pnds) {
        return pnds / CONV_K;
    }

    private static double convMlsToKms(double mls) {
        return mls * CONV_M;
    }

    private static double convKmsToMls(double kms) {
        return kms / CONV_M;
    }
}