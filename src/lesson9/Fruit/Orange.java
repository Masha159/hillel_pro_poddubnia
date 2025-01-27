package lesson9.Fruit;

public class Orange extends Fruit implements Comparable<Orange>{

    private double weightOrange = 1.5;
    @Override
    public int compareTo(Orange o) {
        return 0;
    }
    @Override
    public double getWeight() {
        return weightOrange;
    }
}
