package model;

import java.util.regex.Pattern;

public interface Element {
    int count();

    static Pattern getPattern() {
        return null;
    }
}
