package src.AutoCompleteDictionary;

import java.util.Map;
import java.util.HashMap;

public class DictTrieNode {
    protected String word;
    protected boolean isWord;
    protected Map<String, Integer> count;
    protected Map<Character, DictTrieNode> children;

    public DictTrieNode(String word) {
        this.word = word;
        this.count = new HashMap<>();
        this.children = new HashMap<>();
    }

    public DictTrieNode() {
        this.count = new HashMap<>();
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

    public Map<Character, DictTrieNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, DictTrieNode> children) {
        this.children = children;
    }

    public boolean isLeaf() {
        return this.children.size() == 0;
    }

    public Map<String, Integer> getCount() {
        return count;
    }

    public void setCount(Map<String, Integer> count) {
        this.count = count;
    }
}
