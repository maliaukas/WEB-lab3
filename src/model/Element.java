package model;

import java.util.regex.Pattern;

/**
 * Интерфейс Элемент
 *
 * @author Александра Малявко
 * @version 2020
 */

public interface Element {
    int count();

    static Pattern getPattern() {
        return null;
    }

    String getValue();
}
