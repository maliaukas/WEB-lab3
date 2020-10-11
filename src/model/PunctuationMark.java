package model;

import java.util.regex.Pattern;

public class PunctuationMark extends SingleElement {
    private String mark;

    static Pattern pattern = Pattern.compile(
            "\\.\\.\\.|" +                  //...
            "!!!|" +                        //!!!
            "\\?\\?\\?|\\?!|" +             //???
            "!\\.\\.|" +                    //!..
            "\\?\\.\\.|" +                  //?..
            "[!\"\\#$%&()*+,\\-./:;<=>?@\\[\\\\\\]^_‘{|}~]");

    public PunctuationMark(String mark) {
        this.mark = mark;
    }

    public static Pattern getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "PunctuationMark{" +
                "mark='" + mark + '\'' +
                '}';
    }
}