package model;

import java.util.ArrayList;

public abstract class SingleElement implements Element {
    //private static ArrayList<Character> allowedSymbols;

    @Override
    public int count() {
        return 1;
    }
}
