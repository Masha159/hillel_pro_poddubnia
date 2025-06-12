package org.lessons.lesson40.repository;

import org.lessons.lesson38.model.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {
    private final Map<Integer, Product> productMap = new HashMap<Integer, Product>();

    public Product getProductById(int id) {
        Product product = productMap.get(id);
        System.out.println(product.toString());
        return productMap.get(id);
    }

    public ProductRepository() {
        productMap.put(1, new Product(1, "apple", 10));
        productMap.put(2, new Product(2, "pear", 12));
        productMap.put(3, new Product(3, "avocado", 15));
        productMap.put(4, new Product(4, "lemon", 5));
        productMap.put(5, new Product(5, "strawberry", 20));

    }

    public Product creatProduct(Product product) {
        return productMap.put(product.getId(), product);
    }

    public Product updateProduct(Product product) {
        if (getProductById(product.getId()) == null) {
            throw new RuntimeException("Product does not exist");
        }
        return productMap.put(product.getId(), product);
    }

    public void deleteProduct(int id) {
        productMap.remove(id);
    }

    public List<Product> getAll() {
        return productMap.values().stream().toList();
    }
}
