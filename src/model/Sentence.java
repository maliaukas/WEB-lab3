package model;

import java.util.List;
import java.util.regex.Pattern;

public class Sentence extends MultipleElements {
    static Pattern pattern = Pattern.compile("(.)+?" +
            "(\\.\\.\\.|" +                //...
            "!!!|" +                       //!!!
            "\\?\\?\\?|" +                 //???
            "\\?!|" +                      //?!
            "!\\.\\.|" +                   //!..
            "\\?\\.\\.|" +                 //?..
            "\\.|!|\\?)");                 //. or ! or ?);
    private String sentence;

    public Sentence(String s) {
        super();
        sentence = s.trim();
    }

    public Sentence(List<Element> lst) {
        super(lst);
    }

    public static Pattern getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentence='" + sentence + '\'' +
                ", children=" + children +
                '}';
    }

    public String getSentence() {
        return sentence;
    }
}