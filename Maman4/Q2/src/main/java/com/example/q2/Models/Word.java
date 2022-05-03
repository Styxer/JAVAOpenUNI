package com.example.q2.Models;

import java.util.List;
import java.util.Objects;

public class Word implements Comparable<Word>  {
    private String word;
    private Meaning meaning;
    private List<Meaning> meanings;
    private String phonetics;

    public Word(String word, Meaning meaning, List<Meaning> meanings, String phonetics) {
        this.word = word;
        this.meaning = meaning;
        this.meanings = meanings;
        this.phonetics = phonetics;
    }

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Meaning getMeaning() {
        return meaning;
    }

    public void setMeaning(Meaning meaning) {
        this.meaning = meaning;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meaning> meanings) {
        this.meanings = meanings;
    }

    public String getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(String phonetics) {
        this.phonetics = phonetics;
    }

    @Override
    public int compareTo(Word word) {
        return this.getWord().compareTo(word.getWord());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word word1)) return false;
        return Objects.equals(getWord(), word1.getWord());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord());
    }
    @Override
    public String toString() {
        return this.word;
    }
}
