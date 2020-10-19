package model;

import java.util.regex.Pattern;

/**
 * Класс Слово
 *
 * @author Александра Малявко
 * @version 2020
 */

public class Word extends SingleElement {
    static Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9'`\\-]+");
    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public static Pattern getPattern() {
        return pattern;
    }

    @Override
    public String getValue() {
        return word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
