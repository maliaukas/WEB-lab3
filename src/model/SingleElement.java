package model;

public abstract class SingleElement implements Element {
    @Override
    public int count() {
        return 1;
    }
}
