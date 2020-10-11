package view;

import controller.FileReader;
import controller.SentenceParser;
import controller.TextParser;
import model.Element;
import model.Text;

import java.io.IOException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        SentenceParser sentenceParser = new SentenceParser();
        TextParser parser = new TextParser(sentenceParser);
        String text;
        try {
            text = FileReader.read("src\\file.txt");
        } catch (IOException exception) {
            System.out.print(exception.getLocalizedMessage());
            return;
        }

        //System.out.println(text);

        List<Element> lst = parser.parse(text);
        Text t = new Text(lst);
//        for (Element el : lst) {
//            System.out.println(el.toString());
//            System.out.println();
//        }

        System.out.println(t);
    }
}
