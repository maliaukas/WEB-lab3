package model;

import java.util.regex.Pattern;

public class Code extends SingleElement {
    static Pattern pattern = Pattern.compile("<code>.+?</code>");

    String code;

    public Code(String s) {
        code = s;
    }

    public static Pattern getPattern() {
        return pattern;
    }

    @Override
    public String toString() {
        return "Code{" +
                "code='" + code + '\'' +
                '}';
    }
}