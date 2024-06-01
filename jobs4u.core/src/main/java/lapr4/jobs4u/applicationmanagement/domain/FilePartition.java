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
        final String[] texts = text.split("\\s+");
        Integer value;
        for (String t : texts) {
            value = 1;
            // if word contains special characters, remove them
            String word = t.replaceAll("[^a-zA-Z0-9']", "").toLowerCase();
            if (word.isEmpty())
                continue;
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