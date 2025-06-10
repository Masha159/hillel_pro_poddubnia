package org.lessons.lesson38;

import org.lessons.lesson38.model.Cart;
import org.lessons.lesson38.model.Product;
import org.lessons.lesson38.repository.CartRepository;
import org.lessons.lesson38.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component

public class Runner implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CartRepository cartRepository;

    @Override
    public void run(String... args) {
        System.out.println("console program");
        Scanner scanner = new Scanner(System.in);
        System.out.println("to get list of products enter 1");
        System.out.println("to create a cart enter 2");
        System.out.println("to delete product from the cart enter 3");

        while (true) {
            String line = scanner.nextLine();

            System.out.println(line);
            if (line.equals("1")) {
                System.out.println("products:\n"
                        + productRepository.getAll().stream().map(Product::toString).collect(Collectors.joining("\n"))
                );
            }
            if (line.equals("2")) {
                System.out.println("enter ids of products (don't forget about spaces between numbers)\n");
                line = scanner.nextLine();
                List<Product> products = Arrays.stream(line.split(" ")).map(Integer::parseInt).map(productRepository::getProductById).toList();
                System.out.println(cartRepository.createCart(products));
            }
            if (line.equals("3")) {
                System.out.println("enter id of cart and id of product to delete it from the cart");
                line = scanner.nextLine();
                List<Integer> ids = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
                Cart cart = cartRepository.getCartById(ids.get(0));
                cart.deleteProduct(ids.get(1));
                cartRepository.updateCart(cart);
                System.out.println(cart);
            }
        }
    }
}