package controller;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class TextUtils {

    private static final ArrayList<Character> vowels = new ArrayList<>(
            Arrays.asList('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я',
                    'a', 'e', 'i', 'o', 'u', 'y'));

    /**
     * Метод, который выводит все предложения заданного текста
     * в порядке возрастания количества слов в каждом из них.
     *
     * @param text текст, предложения которого будут выведены
     */

    public static void printSentencesSortedByWordCount(Text text) {
        ArrayList<Sentence> sentences = new ArrayList<>();
        for (Element element : text.getElements()) {
            if (element.getClass() == Sentence.class) {
                sentences.add(((Sentence) element));
            }
        }
        sentences.sort(Comparator.comparingInt(MultipleElements::count));

        for (Sentence s : sentences) {
            System.out.println(s.getSentence());
        }
    }

    /**
     * Метод, сортирующий слова текста по возрастанию доли гласных букв
     * (отношение количества гласных к общему количеству букв в слове).
     *
     * @param text текст, слова которого подлежат сортировке
     * @return отсортированный список слов
     */

    public static ArrayList<Word> getWordsSortedByVowelsCount(Text text) {
        ArrayList<Word> words = new ArrayList<>();
        for (Element element : text.getElements()) {
            if (element.getClass() == Sentence.class) {
                for (Element sentElement : ((Sentence) element).getElements()) {
                    if (sentElement.getClass() == Word.class)
                        words.add((Word) sentElement);
                }
            }
        }

        words.sort(Comparator.comparing(TextUtils::getVowelsPercent));

        for (Word w : words) {
            System.out.println(w.getWord() + " " + getVowelsPercent(w));
        }

        return words;
    }

    /**
     * Метод, вычисляющий процентное соотношение кол-ва гласных букв в слове к длине слова
     *
     * @param w слово
     * @return процентное соотношение (кол-во гласных) / (общее кол-во букв)
     */

    private static double getVowelsPercent(Word w) {
        String word = w.getWord();
        return 1.0 * word.chars().filter
                (ch -> vowels.contains(Character.toLowerCase((char) ch)))
                .count() / word.length();
    }
}
