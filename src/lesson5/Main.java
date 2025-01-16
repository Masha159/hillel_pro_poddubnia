package lesson5;

public class Main {
    public static void main(String[] args) {
        // get output data
        String[] data = getData();
        //forming an object from input data
        Product product = new Product(data[0],
                Integer.parseInt(data[1]),
                Double.parseDouble(data[2]));
        //to calculate the base cost of the product
        CalcCostBase costBase = new CalcCostBase();
        double baseCost = costBase.calcCost(product);
        //to calculate the cost of the goods, taking into account delivery
        CalcCostDelivery costDelivery = new CalcCostDelivery();
        double deliveryCost = costDelivery.calcCost(product);
        //constructing the output
        String baseOutput = product + "\nCost is " +
                Constants.CURRENCY + " " + baseCost + ".";
        String deliveryOutput = product + "\nCost is " +
                Constants.CURRENCY + " " + deliveryCost + ".";
        //output
        getOutput(baseOutput);
        getOutput(deliveryOutput);
    }

    //Input data set
    public static String[] getData() {
        return new String[] {"abc", "5", "2.5"};
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}
