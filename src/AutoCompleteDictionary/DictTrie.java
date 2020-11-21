package src.AutoCompleteDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DictTrie {
    public DictTrieNode root;

    public DictTrie() {
        this.root = new DictTrieNode();
    }

    // Insert a word into the Trie. And increase the word count.
    public void insert(String word) {
        DictTrieNode curr = this.root;
        curr.getCount().put(word, curr.getCount().getOrDefault(word, 0) + 1);
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (!curr.getChildren().containsKey(ch)) curr.getChildren().put(ch, new DictTrieNode());
            curr = curr.getChildren().get(ch);
            curr.getCount().put(word, curr.getCount().getOrDefault(word, 0) + 1);
        }
        curr.setIsWord(true);
        curr.setWord(word);
    }

    // Search a given word in the Trie. And increase the word count.
    public boolean search(String word) {
        DictTrieNode curr = this.root;
        curr.getCount().put(word, curr.getCount().getOrDefault(word, 0) + 1);
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (!curr.getChildren().containsKey(ch)) return false;
            curr = curr.getChildren().get(ch);
            curr.getCount().put(word, curr.getCount().getOrDefault(word, 0) + 1);
        }
        return curr.isWord();
    }

    // Return if any word in the Trie starts with the given prefix.
    public boolean prefixWith(String prefix) {
        DictTrieNode curr = this.root;
        char[] prefixArray = prefix.toCharArray();
        for (char ch : prefixArray) {
            if (!curr.getChildren().containsKey(ch)) return false;
            curr = curr.getChildren().get(ch);
        }
        return true;
    }

    // Delete a word in the Trie
    public void delete(String word) {
        if (!search(word)) return;
        deleteHelper(this.root, word);
    }

    private boolean deleteHelper(DictTrieNode root, String word) {
        // Is leaf node and already use the whole word.
        if (word.length() == 0 && root.isLeaf()) {
            return true;
        }
        // Not leaf node and already use the whole word.
        if (word.length() == 0 && !root.isLeaf()) {
            root.setWord("");
            root.setIsWord(false);
            return false;
        }

        char first = word.charAt(0);
        boolean deleted = deleteHelper(root.getChildren().get(first), word.substring(1));
        if (deleted) root.getChildren().remove(first);
        if (root.isLeaf() && !root.isWord()) {
            return true;
        }
        return false;
    }

    // Autocomplete
    public List<String> wordRecommendation(String prefix) {
        List<String> words = new ArrayList<>();

        DictTrieNode curr = this.root;
        char[] prefixArray = prefix.toCharArray();
        for (char ch : prefixArray) {
            if (!curr.getChildren().containsKey(ch)) return words;
            curr = curr.getChildren().get(ch);
        }

        Map<String, Integer> count = curr.getCount();
        PriorityQueue<Pair> pq = new PriorityQueue<>(11, (a, b) -> (a.count == b.count ? a.word.compareTo(b.word) : b.count - a.count));

        for (String s : count.keySet()) {
            pq.add(new Pair(s, count.get(s)));
        }

        // limit the recommendation result size to be 10.
        int counts = 10;
        while (!pq.isEmpty() && counts > 0) {
            words.add(pq.poll().word);
            counts--;
        }

        return words;
    }

    // A class used to be compared in heap.
    private class Pair {
        public String word;
        public int count;
        public Pair(String word, int count) {
            this.word = word; this.count = count;
        }
    }
}

