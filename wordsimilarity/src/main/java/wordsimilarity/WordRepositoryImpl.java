package wordsimilarity;

import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;

@Repository
public class WordRepositoryImpl implements WordsRepository {
    private static final String DB_PATH = "words_clean.txt";

    private final Map<Word, Set<String>> wordsDB = new HashMap<>();
    private int wordCount = 0;

    public WordRepositoryImpl() throws IOException {
        System.out.println("Start reading dictionary from file");
        readFileToDB();
        System.out.println("Done reading dictionary from file");
    }

    private void readFileToDB() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(DB_PATH);
        if (resourceAsStream == null) {
            throw new RuntimeException("DB file not found");
        }

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

        String wordStr;
        while ((wordStr = bufferedReader.readLine()) != null) {
            addWordToDB(wordStr);
            wordCount++;
        }
    }

    private void addWordToDB(String wordStr) {
        Word word = WordUtils.stringToWord(wordStr);
        if (wordsDB.containsKey(word)) {
            wordsDB.get(word).add(wordStr);
        } else {
            Set<String> wordStrSingleton = new HashSet<>(Collections.singletonList(wordStr));
            wordsDB.put(word, wordStrSingleton);
        }
    }

    @Override
    public Set<String> findSimilarWords(Word word) {
        return wordsDB.getOrDefault(word, new HashSet<>());
    }

    @Override
    public int size() {
        return wordCount;
    }
}
