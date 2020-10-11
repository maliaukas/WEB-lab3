package model;

import java.util.regex.Pattern;

public class Word extends SingleElement {
    private String word;

    static Pattern pattern = Pattern.compile("[а-яА-Яa-zA-Z0-9'`\\-]+");

    public Word(String word) {
        this.word = word;
    }

    public static Pattern getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                '}';
    }
}
