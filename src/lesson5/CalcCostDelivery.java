package lesson5;

public class CalcCostDelivery extends CalcCostBase {

    private final static double deliveryPrice = 7;

    // Розрахунок вартості товару,
    // з урахуванням вартості доставки
    @Override
    public double calcCost(Product product) {

        return super.calcCost(product) + deliveryPrice;
    }
}
