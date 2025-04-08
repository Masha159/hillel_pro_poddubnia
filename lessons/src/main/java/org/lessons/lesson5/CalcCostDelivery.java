package org.lessons.lesson5;

public class CalcCostDelivery extends CalcCostBase {

    private final static double deliveryPrice = 7;
    //to calculation of the cost of goods with delivery
    @Override
    public double calcCost(Product product) {
        return super.calcCost(product) + deliveryPrice;
    }
}
