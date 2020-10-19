package controller;

import model.Element;

import java.util.List;

/**
 * Интерфейс Парсер
 *
 * @author Александра Малявко
 * @version 2020
 */

public interface Parser {
    List<Element> parse(List<Element> l);
}
