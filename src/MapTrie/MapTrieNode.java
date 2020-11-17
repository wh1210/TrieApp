package src.MapTrie;

import java.util.Map;
import java.util.HashMap;

public class MapTrieNode {
    protected String word;
    protected boolean isWord;
    protected Map<Character, MapTrieNode> children;

    public MapTrieNode(String word) {
        this.word = word;
        this.children = new HashMap<>();
    }

    public MapTrieNode() {
        this.children = new HashMap<>();
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

    public Map<Character, MapTrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, MapTrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }
}
