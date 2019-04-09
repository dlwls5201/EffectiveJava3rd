package chapter02.item05;

import java.util.List;

// 부적절한 static 유틸리티 사용 예 - 유연하지 않고 테스트 할 수 없다.
public class SpellChecker {

    private static final Lexicon dictionary = new KoreanDictionary();

    private SpellChecker() {
        // Noninstantiable
    }

    public static boolean isValid(String word) {
        throw new UnsupportedOperationException();
    }


    public static List<String> suggestions(String typo) {
        throw new UnsupportedOperationException();
    }
}

interface Lexicon {}

class KoreanDictionary implements Lexicon {}