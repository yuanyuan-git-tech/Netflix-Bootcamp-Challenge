package com.company.Summative1YuanyuanZhao.models;

public class Word {
    int id;
    String word;
    String definition;

    public Word() {
    }

    public Word(String word, String definition, int id) {
        this.word = word;
        this.definition = definition;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
