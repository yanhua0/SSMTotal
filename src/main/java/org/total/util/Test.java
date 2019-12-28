package org.total.util;

public class Test {
    private String name;
    private String word;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
