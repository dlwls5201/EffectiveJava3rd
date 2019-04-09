package chapter02.item05;

import java.util.List;
import java.util.Objects;

public class SpellChecker2 {

    private final Lexicon2 dictionary;

    public SpellChecker2(Lexicon2 dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }

    public List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Lexicon2 lexicon2 = new KoreanDictionary2();
        Lexicon2 lexiconTest2 = new KoreanDictionaryTest2();

        SpellChecker2 spellChecker2 = new SpellChecker2(lexicon2);
        spellChecker2.isValid("hello");
    }

}

interface Lexicon2 {}

class KoreanDictionary2 implements Lexicon2 {}

class KoreanDictionaryTest2 implements Lexicon2 {}