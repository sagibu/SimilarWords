package wordsimilarity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

@Data
@AllArgsConstructor
public class Word {
    private Map<Character, Integer> charCounts;
}