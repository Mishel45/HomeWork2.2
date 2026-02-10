package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.Search.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

class app {
    public static void main(String[] args) {
        System.out.println("Уважаемый наставник представляю твоему вниманию домашнее задание за " +
                "30 апреля.(ООП: полиморфизм, интерфейсы) ");
        System.out.println();

        Product product1 = new SimpleProduct("Ножовка", 150);
        Product product2 = new FixPriceProduct("Топор");
        Product product3 = new SimpleProduct("Молоток", 230);
        Product product4 = new DiscountedProduct("Мастерок", 180, 25);
        Product product5 = new FixPriceProduct("Рулетка");
        Product product6 = new SimpleProduct("Уровень для строителя", 380);

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

        SearchEngine engine = new SearchEngine(10);

        engine.add(product1);
        engine.add(product2);
        engine.add(product3);
        engine.add(product4);
        engine.add(product5);
        engine.add(product6);

        engine.add(new Article("Применение ножовки", "Ножовка нужна для распилки досок, " +
                "Веток и других деревянных изделий"));
        engine.add(new Article("Применение топора", "Топор применяется для колки дров и " +
                "валки деревьев"));
        engine.add(new Article("Применение молоток", "Молоток требуется для забивания " +
                "гвоздей в деревянные изделия"));
        engine.add(new Article("Применение рулетки", "Рулетка нужна для измерения длины " +
                "изделий"));
        engine.add(new Article("Применение мастерка", "Мастерок применяется для замешивания" +
                " раствора и кладки кирпичей"));

        System.out.println();
        System.out.println(" Проверка поиска");
        printSearchResults(engine.search("Молот"));
        System.out.println();
        System.out.println(" Проверка поиска 2");
        printSearchResults(engine.search("для"));
        System.out.println();
        System.out.println(" Проверка поиска 3");
        printSearchResults(engine.search("абракадабра"));

    }

    private static void printSearchResults(Searchable[] results) {
        boolean found = false;
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Ничего не найдено");
        }
    }
}