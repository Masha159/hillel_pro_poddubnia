package org.lessons.lesson37.repository;

import org.lessons.lesson37.model.Order;
import org.lessons.lesson37.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepository {
    private final Map<Integer, Product> productMap = new HashMap<Integer, Product>();
    public Product getProductById(int id){
        return productMap.get(id);
    }

    public Product creatProduct(Product product){
        return productMap.put(product.getId(), product);
    }

    public Product updateProduct(Product product){
        if (getProductById(product.getId()) == null){
            throw new RuntimeException("Product does not exist");
        }
        return productMap.put(product.getId(), product);
    }

    public void deleteProduct(int id){
        productMap.remove(id);
    }
}
