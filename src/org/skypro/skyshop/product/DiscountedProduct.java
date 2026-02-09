package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount; // Процент скидки (0-100)

    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        // Рассчитываем итоговую цену: базовая цена минус величина скидки
        // Используем double для точности при делении, затем приводим к int
        return (int) (basePrice * (1.0 - discount / 100.0));
    }
    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": со скидкой " + getPrice() + " (скидка " + discount + "%)";
    }
}
