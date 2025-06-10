package org.lessons.lesson38.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
public class Cart {
    private int id;
    private List<Product> products;

//    public double getCost() {
//        double sum = 0;
//        for (int i = 0; i < products.size(); i++) {
//            sum += products.get(i).getPrice();
//        }
//        return sum;
//    }

    public void deleteProduct(int productId) {
        products = products.stream().filter(product -> product.getId() != productId).toList();
    }
}
