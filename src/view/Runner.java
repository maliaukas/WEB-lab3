package view;

import controller.FileReader;
import controller.SentenceParser;
import controller.TextParser;
import controller.TextUtils;
import model.Element;
import model.Text;
import model.Word;

import java.io.IOException;
import java.util.ArrayList;
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

        // System.out.println(text);

        List<Element> lst = parser.parse(text);
        Text t = new Text(lst);
        System.out.println(t);

        System.out.println("Sentences sorted by word count ascending:");
        TextUtils.printSentencesSortedByWordCount(t);

        ArrayList<Word> words = TextUtils.getWordsSortedByVowelsCount(t);

//        System.out.println("Words sorted by vowels count ascending:");
//        for(Word w: words) {
//            System.out.println(w.getWord());
//        }
    }
}
