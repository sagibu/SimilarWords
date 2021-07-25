package wordsimilarity;

import java.util.Set;

public interface WordsRepository {
    Set<String> findSimilarWords(Word word);
    int size();
}
