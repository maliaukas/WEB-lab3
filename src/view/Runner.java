package view;

import controller.FileReader;
import controller.SentenceParser;
import controller.TextParser;
import controller.TextUtils;
import model.Element;
import model.Text;
import model.Word;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

public class Runner {

    public static Locale askLocale() {
        System.out.println("""
                Пожалуйста, выберите язык /
                Please select the language /
                Калі ласка, выберыце мову :
                1. Русский
                2. English
                3. Беларуская""");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> new Locale("ru", "RU");
            case 2 -> new Locale("en", "US");
            case 3 -> new Locale("be", "BY");
            default -> Locale.getDefault();
        };
    }

    public static void main(String[] args) {
        File file = new File("D:\\WEB\\WEB-lab3\\src\\resources");
        URL[] urls;
        try {
            urls = new URL[]{file.toURI().toURL()};
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }

        ClassLoader loader = new URLClassLoader(urls);
        Locale locale = askLocale();
        ResourceBundle resourceBundle =
                ResourceBundle.getBundle("lab3", locale, loader);

        SentenceParser sentenceParser = new SentenceParser();
        TextParser parser = new TextParser(sentenceParser);
        String toParse;
        try {
            toParse = FileReader.read("src\\file.txt");
        } catch (IOException exception) {
            System.err.print(exception.getLocalizedMessage());
            return;
        }

        List<Element> lst = parser.parse(toParse);
        Text text = new Text(lst);

        System.out.println("\n----- " + resourceBundle.getString("text.parsing.result"));
        System.out.println(text);

        System.out.println("\n----- " + resourceBundle.getString("rebuilt.text"));
        System.out.println(text.getValue());

        System.out.println("\n----- " + resourceBundle.getString("sentences.sorted"));
        TextUtils.printSentencesSortedByWordCount(text);

        ArrayList<Word> words = TextUtils.getWordsSortedByVowelsPercent(text);

        System.out.println("\n----- " + resourceBundle.getString("words.sorted"));
        for (Word w : words) {
            System.out.println("\t" + w.getValue());
        }
    }
}
