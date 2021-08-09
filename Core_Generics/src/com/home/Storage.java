package com.home;

public class Storage<T extends MyNum,U extends Transport> {
    T identificator;
    U element;

    public Storage(T identificator) {
        this.identificator = identificator;
    }

    public T getIdentificator() {
        return identificator;
    }

    public U getElement() {
        return element;
    }

    public void setElement(U element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "Storage:" +
                "\n\tidentificator=" + identificator +
                "\n\telement=" + element +
                '\n';
    }
}
