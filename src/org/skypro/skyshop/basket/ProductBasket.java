package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new HashMap<>();

    public void addProduct(Product product) {
        basket.computeIfAbsent(product.getName(), k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }
    private long getSpecialCount(){
        return basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (basket.isEmpty()) {
            System.out.println("в корзине ничего нет");
            return;
        }
        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
            System.out.println("Итого: " + getTotalCost() + " руб.");
            System.out.println("Специальных товаров: " + getSpecialCount() +" шт.");

    }

    public boolean containsProduct(String name) {
        return basket.containsKey(name);
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removed = basket.remove(name);
        return (removed != null) ? removed : new ArrayList<>();
    }
}
