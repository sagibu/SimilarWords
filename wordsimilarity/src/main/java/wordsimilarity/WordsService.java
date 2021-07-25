package wordsimilarity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WordsService {
    @Autowired
    WordsRepository wordsRepository;

    private int numOfRequests = 0;
    private int avgRequestTime = 0;

    public Map<String, Set<String>> getSimilarWords(String wordStr) {
        long startTime = System.nanoTime();
        Map<String, Set<String>> result = new HashMap<>();
        Set<String> similarWords = wordsRepository.findSimilarWords(WordUtils.stringToWord(wordStr))
                .stream()
                .filter((String word) -> !word.equals(wordStr))
                .collect(Collectors.toSet());
        result.put("similar", similarWords);
        long endTime = System.nanoTime();
        updateStats(endTime - startTime);
        return result;
    }

    public Stats getStats() {
        return new Stats(wordsRepository.size(), numOfRequests, avgRequestTime);
    }

    private synchronized void updateStats(long timeDiff) {
        numOfRequests++;
        avgRequestTime = (int)((long) avgRequestTime * (numOfRequests - 1) + timeDiff) /
                numOfRequests;
    }
}
