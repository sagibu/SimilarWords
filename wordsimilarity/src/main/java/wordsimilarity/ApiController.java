package wordsimilarity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    WordsService wordsService;

    @RequestMapping("similar")
    public Map<String, Set<String>> getSimilar(@RequestParam String word) {
        return wordsService.getSimilarWords(word);
    }

    @RequestMapping("stats")
    public Stats getStats() {
        return wordsService.getStats();
    }
}
