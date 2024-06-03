package lapr4.jobs4u.applicationmanagement.domain;

import java.util.HashMap;
import java.util.Map;

public class FilePartition implements Runnable {

    private final String text;
    private Map<String, Integer> topWords;

    protected FilePartition(final String text) {
        this.text = text;
    }

    protected FilePartition() {
        this.text = "";
    }

    public static File valueOf(final String file) {
        return new File(file);
    }

    @Override
    public int hashCode() {
        return this.text.hashCode();
    }

    @Override
    public String toString() {
        return this.text;
    }

    @Override
    public void run() {
        topWords = new HashMap<>();
        final String[] texts = text.split("(?<=\\p{L})(?=\\p{P})|(?<=\\p{P})(?=\\p{L})|\\s+");
        Integer value;
        for (String word : texts) {
            value = 1;
            word = word.replaceAll("[^a-zA-Z0-9'@.]", "").toLowerCase();
            if (word.isEmpty() || (word.length() == 1 && word.matches("\\P{Alnum}"))) {
                continue;
            }
            if (topWords.containsKey(word))
                value = topWords.get(word) + 1;

            addCount(word, value);
        }

    }

    private synchronized void addCount(String word, Integer value) {
        topWords.put(word, value);
    }

    public Map<String, Integer> getTopWords() {
        return topWords;
    }
}