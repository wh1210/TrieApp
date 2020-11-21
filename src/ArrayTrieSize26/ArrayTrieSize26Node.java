package src.ArrayTrieSize26;

public class ArrayTrieSize26Node {
    protected String word;
    protected boolean isWord;
    protected ArrayTrieSize26Node[] children;
    // only have 26 lower case letters.
    public final int size = 26;

    public ArrayTrieSize26Node(String word) {
        this.word = word;
        this.children = new ArrayTrieSize26Node[size];
    }

    public ArrayTrieSize26Node() {
        this.children = new ArrayTrieSize26Node[size];
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

    public ArrayTrieSize26Node[] getChildren() {
        return children;
    }

    public void setChildren(ArrayTrieSize26Node[] children) {
        this.children = children;
    }

    public ArrayTrieSize26Node getChildrenAtIndex(int index) {
        return this.children[index];
    }

    public void setChildrenAtIndex(int index) {
        this.children[index] = new ArrayTrieSize26Node();
    }

    public void deleteChildrenAtIndex(int index) {
        this.children[index] = null;
    }

    public boolean isLeaf() {
        for (ArrayTrieSize26Node node : this.children) {
            if (node != null) return false;
        }
        return true;
    }
}
