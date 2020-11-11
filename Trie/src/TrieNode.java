package src;

public class TrieNode{
    protected String word;
    protected boolean isWord;
    protected TrieNode[] children;
    // // By default, we are using 26 lower case letters, so the size is 26.
    // public final int size = 26;
    // The whole size of ASCII table is 256.
    public final int size = 256;

    public TrieNode(String word) {
        this.word = word;
        this.children = new TrieNode[size];
    }

    public TrieNode() {
        this.children = new TrieNode[size];
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public TrieNode getChildrenAtIndex(int index) {
        return this.children[index];
    }

    public void setChildrenAtIndex(int index) {
        this.children[index] = new TrieNode();
    }

    public void deleteChildrenAtIndex(int index) {
        this.children[index] = null;
    }

    public boolean isLeaf() {
        for (TrieNode node : this.children) {
            if (node != null) return false;
        }
        return true;
    }
}