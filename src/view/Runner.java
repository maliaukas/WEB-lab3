package view;

import controller.FileReader;
import controller.SentenceParser;
import controller.TextParser;
import controller.TextUtils;
import controller.exception.FileReaderException;
import model.Element;
import model.Text;
import model.Word;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Класс Runner, демонстрирующий работу с проектом.
 *
 * @author Александра Малявко
 * @version 2020
 */

public class Runner {

    private static final Logger logger = LogManager.getLogger(Runner.class.getName());

    /**
     * Метод, запрашивающий у пользователя язык приложения
     *
     * @return соответствующую локаль
     */
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
        logger.info("Старт приложения");
        logger.debug("Запрашиваем у пользователя язык приложения");
        Locale locale = askLocale();
        logger.debug("Пользователь выбрал локаль " + locale.toString());
        logger.debug("Получаем соответствующий выбранному языку ResourceBundle");
        ResourceBundle resourceBundle =
                ResourceBundle.getBundle("resources.lab3", locale);

        String toParse;
        try {
            logger.debug("Пытаемся прочитать текст из файла");
            toParse = FileReader.read("src\\file.txt");
        } catch (FileReaderException exception) {
            logger.error("Не получилось прочитать текст из файла");
            System.err.print(exception.getMessage());
            return;
        }
        logger.debug("Получилось прочитать текст из файла");

        logger.debug("Создаем экземпляр класса SentenceParser");
        SentenceParser sentenceParser = new SentenceParser();
        logger.debug("Создаем экземпляр класса TextParser");
        TextParser parser = new TextParser(sentenceParser);

        logger.debug("Парсим полученный из файла текст");
        List<Element> lst = parser.parse(toParse);
        logger.debug("На основе распаршенных элементов создаем экземпляр класса Text");
        Text text = new Text(lst);

        logger.debug("Выводим полученный экземпляр класса Text");
        System.out.println("\n----- " + resourceBundle.getString("text.parsing.result"));
        System.out.println(text);

        logger.debug("Выводим восстановленный текст");
        System.out.println("\n----- " + resourceBundle.getString("rebuilt.text"));
        System.out.println(text.getValue());

        logger.debug("Выводим отсортированные предложения");
        System.out.println("\n----- " + resourceBundle.getString("sentences.sorted"));
        TextUtils.printSentencesSortedByWordCount(text);

        logger.debug("Сортируем слова");
        ArrayList<Word> words = TextUtils.getWordsSortedByVowelsPercent(text);

        logger.debug("Выводим отсортированные слова");
        System.out.println("\n----- " + resourceBundle.getString("words.sorted"));
        for (Word w : words) {
            System.out.println("\t" + w.getValue());
        }
        logger.info("Завершение приложения");
    }
}
