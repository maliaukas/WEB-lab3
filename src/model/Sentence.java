package model;

import java.util.regex.Pattern;

/**
 * Класс Предложение. Его дочерними элементами могут быть слова и знак препинания.
 *
 * @author Александра Малявко
 * @version 2020
 */

public class Sentence extends MultipleElements {

    static Pattern pattern = Pattern.compile("(.)+?" +
            "(\\.\\.\\.|" +                //...
            "!!!|" +                       //!!!
            "\\?\\?\\?|" +                 //???
            "\\?!|" +                      //?!
            "!\\.\\.|" +                   //!..
            "\\?\\.\\.|" +                 //?..
            "\\.|!|\\?)");                 //. or ! or ?);

    private final String sentence;

    public Sentence(String s) {
        super();
        sentence = " " + s.trim();
    }

    public static Pattern getPattern() {
        return pattern;
    }

    public String getSentence() {
        return sentence;
    }

    @Override
    public String toString() {
        return "\n\nSentence{" +
                "sentence='" + sentence + '\'' +
                ", children=" + children +
                "}";
    }
}