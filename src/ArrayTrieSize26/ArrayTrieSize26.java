package src.ArrayTrieSize26;

public class ArrayTrieSize26 {
    public ArrayTrieSize26Node root;

    public ArrayTrieSize26() {
        this.root = new ArrayTrieSize26Node();
    }

    // Insert a word into the Trie.
    public void insert(String word) {
        ArrayTrieSize26Node curr = this.root;
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (curr.getChildrenAtIndex(ch - 'a') == null) {
                curr.setChildrenAtIndex(ch - 'a');
            } 
            curr = curr.getChildrenAtIndex(ch - 'a');
        }
        curr.setIsWord(true);
        curr.setWord(word);
    }

    // Search a given word in the Trie.
    public boolean search(String word) {
        ArrayTrieSize26Node curr = this.root;
        char[] wordArray = word.toCharArray();
        for (char ch : wordArray) {
            if (curr.getChildrenAtIndex(ch - 'a') == null) return false;
            curr = curr.getChildrenAtIndex(ch - 'a');
        }
        return curr.isWord();
    }

    // Return if any word in the Trie starts with the given prefix.
    public boolean prefixWith(String prefix) {
        ArrayTrieSize26Node curr = this.root;
        char[] prefixArray = prefix.toCharArray();
        for (char ch : prefixArray) {
            if (curr.getChildrenAtIndex(ch - 'a') == null) return false;
            curr = curr.getChildrenAtIndex(ch - 'a');
        }
        return true;
    }

    // Delete a word in the Trie
    public void delete(String word) {
        if (!search(word)) return;
        deleteHelper(this.root, word);
    }

    private boolean deleteHelper(ArrayTrieSize26Node root, String word) {
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
        boolean deleted = deleteHelper(root.getChildrenAtIndex(first - 'a'), word.substring(1));
        if (deleted) root.deleteChildrenAtIndex(first - 'a');
        if (root.isLeaf() && !root.isWord()) {
            return true;
        }
        return false;
    }
}
