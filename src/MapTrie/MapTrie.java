package src.MapTrie;

public class MapTrie {
    public MapTrieNode root;

    public MapTrie() {
        this.root = new MapTrieNode();
    }

    // Insert a word into the Trie.
    public void insert(String word) {
        MapTrieNode curr = this.root;
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (!curr.getChildren().containsKey(ch)) curr.getChildren().put(ch, new MapTrieNode());
            curr = curr.getChildren().get(ch);
        }
        curr.setIsWord(true);
        curr.setWord(word);
    }

    // Search a given word in the Trie.
    public boolean search(String word) {
        MapTrieNode curr = this.root;
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (!curr.getChildren().containsKey(ch)) return false;
            curr = curr.getChildren().get(ch);
        }
        return curr.isWord();
    }

    // Return if any word in the Trie starts with the given prefix.
    public boolean prefixWith(String prefix) {
        MapTrieNode curr = this.root;
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

    private boolean deleteHelper(MapTrieNode root, String word) {
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
}
