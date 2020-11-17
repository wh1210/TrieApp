package src.ArrayTrie;

public class ArrayTrieNode{
    protected String word;
    protected boolean isWord;
    protected ArrayTrieNode[] children;
    // // By default, we are using 26 lower case letters, so the size is 26.
    // public final int size = 26;
    // The whole size of ASCII table is 256.
    public final int size = 256;

    public ArrayTrieNode(String word) {
        this.word = word;
        this.children = new ArrayTrieNode[size];
    }

    public ArrayTrieNode() {
        this.children = new ArrayTrieNode[size];
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

    public ArrayTrieNode[] getChildren() {
        return children;
    }

    public void setChildren(ArrayTrieNode[] children) {
        this.children = children;
    }

    public ArrayTrieNode getChildrenAtIndex(int index) {
        return this.children[index];
    }

    public void setChildrenAtIndex(int index) {
        this.children[index] = new ArrayTrieNode();
    }

    public void deleteChildrenAtIndex(int index) {
        this.children[index] = null;
    }

    public boolean isLeaf() {
        for (ArrayTrieNode node : this.children) {
            if (node != null) return false;
        }
        return true;
    }
}