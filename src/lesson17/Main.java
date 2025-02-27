package lesson17;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.0),
                new Product("Coffee Maker", "Appliances", 80.0),
                new Product("Headphones", "Electronics", 150.0),
                new Product("Blender", "Appliances", 50.0)
        );

        Map<String, Double> result = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

      Optional<Map.Entry<String, Double>> maxValue = result.entrySet().stream().max(Map.Entry.comparingByValue());

        System.out.println("Результат: " + result);

        maxValue.ifPresent(entry -> System.out.println("Max: " + entry.getValue() + " Категорії: " + entry.getKey()));
    }
}
