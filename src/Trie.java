package src;

public class Trie {
    public TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    // Insert a word into the Trie.
    public void insert(String word) {
        TrieNode curr = this.root;
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (curr.getChildrenAtIndex(ch) == null) {
                curr.setChildrenAtIndex(ch);
            } 
            curr = curr.getChildrenAtIndex(ch);
        }
        curr.setIsWord(true);
        curr.setWord(word);
    }

    // Search a given word in the Trie.
    public boolean search(String word) {
        TrieNode curr = this.root;
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (curr.getChildrenAtIndex(ch) == null) return false;
            curr = curr.getChildrenAtIndex(ch);
        }
        return curr.isWord();
    }

    // Return if any word in the Trie starts with the given prefix.
    public boolean prefixWith(String prefix) {
        TrieNode curr = this.root;
        char[] prefixArray = prefix.toCharArray();
        for (char ch : prefixArray) {
            if (curr.getChildrenAtIndex(ch) == null) return false;
            curr = curr.getChildrenAtIndex(ch);
        }
        return true;
    }

    // Delete a word in the Trie
    public void delete(String word) {
        if (!search(word)) return;
        deleteHelper(this.root, word);
    }

    private boolean deleteHelper(TrieNode root, String word) {
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
        boolean deleted = deleteHelper(root.getChildrenAtIndex(first), word.substring(1));
        if (deleted) root.deleteChildrenAtIndex(first);
        if (root.isLeaf() && !root.isWord()) {
            return true;
        }
        return false;
    }
}
