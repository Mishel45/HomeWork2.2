package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    int specialCount = 0;
    private final Product[] basket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
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
        boolean isEmpty = true;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("в корзине ничего нет");
        } else {
            System.out.println("Итого: " + getTotalCost() + " руб.");
            System.out.println("Специальных товаров: " + specialCount);
        }
    }

    public boolean containsProduct(String name) {
        for (Product product : basket) {
            if (product != null && product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}
