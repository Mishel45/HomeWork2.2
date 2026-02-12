package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductBasket {
    private final List<Product> basket = new ArrayList<>();

    public void addProduct(Product product) {
        basket.add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (Product product : basket) {
            if (product != null) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printBasket() {
        int specialCount = 0;
        if (basket.isEmpty()) {
            System.out.println("в корзине ничего нет");
            return;
        }
        for (Product product : basket) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost() + " руб.");
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean containsProduct(String name) {
        for (Product product : basket) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();
            if (currentProduct.getName().equals(name)) {
                removedProducts.add(currentProduct);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}
