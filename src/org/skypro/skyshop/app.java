package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

class app {
    public static void main(String[] args) {
        System.out.println("Уважаемый наставник представляю твоему вниманию домашнее задание за " +
                "23 апреля.(ООП. Наследование, абстрактные классы) ");
        System.out.println();

        Product product1 = new SimpleProduct("Ножовка", 150);
        Product product2 = new FixPriceProduct( "Топор");
        Product product3 = new SimpleProduct("Молоток", 230);
        Product product4 = new DiscountedProduct( "Мастерок", 180, 25);
        Product product5 = new FixPriceProduct("Рулетка");
        Product product6 = new SimpleProduct("Уровень", 380);

        ProductBasket basket1 = new ProductBasket();
        System.out.println("Добавление продукта в корзину.");
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);

        System.out.println("Печать содержимого корзины с несколькими товарами.");
        basket1.printBasket();
        System.out.println();

        System.out.println("Добавление продукта в заполненную корзину, в которой нет свободного места.");
        basket1.addProduct(product6);
        System.out.println();

        System.out.println("Получение стоимости корзины с несколькими товарами.");
        System.out.println("В корзине товаров на сумму: " + basket1.getTotalCost() + " руб.");
        System.out.println();

        System.out.println("Поиск товара, который есть в корзине.");
        System.out.println(basket1.containsProduct("Мастерок"));
        System.out.println();

        System.out.println("Поиск товара, которого нет в корзине.");
        System.out.println(basket1.containsProduct("Гвоздодер"));
        System.out.println();

        System.out.println("Очистка корзины. Печать содержимого пустой корзины.");
        basket1.clearBasket();
        basket1.printBasket();
        System.out.println();

        System.out.println("Получение стоимости пустой корзины.");
        System.out.println("В корзине товаров на сумму: " + basket1.getTotalCost() + " руб.");
        System.out.println();

        System.out.println("Поиск товара по имени в пустой корзине.");
        System.out.println(basket1.containsProduct("Мастерок"));
        System.out.println();

    }
}