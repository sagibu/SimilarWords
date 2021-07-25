package wordsimilarity;

import java.util.HashMap;
import java.util.Map;

public class WordUtils {
    public static Word stringToWord(String wordStr) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (char c : wordStr.toCharArray()) {
            charCounts.merge(c, 1, Integer::sum);
        }

        return new Word(charCounts);
    }
}
