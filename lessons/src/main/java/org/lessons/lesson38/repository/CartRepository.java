package org.lessons.lesson38.repository;

import org.lessons.lesson38.model.Cart;
import org.lessons.lesson38.model.Product;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CartRepository {
    private final Map<Integer, Cart> cartMap = new HashMap<>();
    int idCounter = 0;

    public int createCart(List<Product> products){
        Cart cart = new Cart();
        cart.setId(idCounter);
        cart.setProducts(products);
        idCounter++;
        cartMap.put(cart.getId(), cart);
        return cart.getId();
    }

    public Cart getCartById(int id) {
        return cartMap.get(id);
    }

    public void deleteCartById(int id) {
        cartMap.remove(id);
    }

    public void updateCart(Cart cart){
        cartMap.put(cart.getId(), cart);
    }
}