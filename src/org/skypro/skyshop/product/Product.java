package org.skypro.skyshop.product;

import org.skypro.skyshop.Search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) throws IllegalArgumentException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название товара не может быть пустым");
        }
        this.name = name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String toString() {
        return name + ": " + getPrice() + " руб.";
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return name;
    }
}

