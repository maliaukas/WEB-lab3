package model;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Текст, полученный в результате работы цепочки парсеров
 */

public class Text extends MultipleElements {

    static Pattern pattern = Pattern.compile(".+");

    public Text(List<Element> children) {
        super(children);
    }

    public static Pattern getPattern() {
        return pattern;
    }

    public String getText() {
        StringBuilder builder = new StringBuilder();
        for (Element el : children) {
            //TODO implement
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return "Text{" +
                "children=" + children +
                '}';
    }
}
