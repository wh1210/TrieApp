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
        TrieNode currNode = this.root;
        boolean deleted = deleteHelper(currNode, word);
        if (deleted && currNode.isLeaf()) currNode = null;
    }

    private boolean deleteHelper(TrieNode currNode, String word) {
        char first = word.charAt(0);
        // Is leaf node and already use the whole word.
        if (word.length() == 0 && currNode.isLeaf()) {
            currNode = null;
            return true;
        }
        // Not leaf node and already use the whole word.
        if (word.length() == 0 && !currNode.isLeaf()) {
            currNode.setWord("");
            currNode.setIsWord(false);
            return false;
        }
        // Not leaf node.
        currNode = currNode.getChildrenAtIndex(first);
        boolean deleted = deleteHelper(currNode, word.substring(1));
        if (deleted && currNode.isLeaf()) {
            currNode = null;
            return true;
        }
        return false;
    }
}
