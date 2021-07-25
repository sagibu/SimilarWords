package wordsimilarity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Stats {
    private int totalWords;
    private int totalRequests;
    private int avgProcessingTimeNs;
}
