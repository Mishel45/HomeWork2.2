package org.skypro.skyshop.exceptions;

import java.io.IOException;

public class BestResultNotFoundException extends IOException {
    public BestResultNotFoundException(String search) {
        super("Для поискового запроса: '" + search + "' не нашлось подходящего результата.");
    }
}
