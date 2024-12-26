package lesson2;

public class Main {
        private static final double CONV_M = 1.60934;

        public static void main(String[] args) {
            System.out.println("Converter App.");
            System.out.println("Version 1.1.");
            double mls = 10;
            double kms = 100;
            double kilometers = convMlsToKms(mls);
            double miles = convKmsToMls(kms);

            System.out.println("Result is " + kilometers + " kilometers and " + miles + " kilometers.");
        }

        private static double convMlsToKms(double mls) {
            return mls * CONV_M;
        }

        private static double convKmsToMls(double kms) {
            return kms / CONV_M;
        }
}
