package model;

/**
 * Абстрактный класс SingleElement, представляющий собой элемент,
 * который не может иметь дочерних элементов
 *
 * @author Александра Малявко
 * @version 2020
 */

public abstract class SingleElement implements Element {
    @Override
    public int count() {
        return 1;
    }
}
