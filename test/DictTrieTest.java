package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.AutoCompleteDictionary.DictTrie;
import src.AutoCompleteDictionary.DictTrieNode;


public class DictTrieTest {
    public DictTrie trie;

    @Test
    public void testInsert() {
        this.trie = new DictTrie();
        this.trie.insert("hello");
        DictTrieNode curr = this.trie.root;
        assertNotNull(curr.getChildren().get('h'));
        assertNull(curr.getChildren().get('s'));
        curr = curr.getChildren().get('h');
        assertNotNull(curr.getChildren().get('e'));
        curr = curr.getChildren().get('e');
        assertNotNull(curr.getChildren().get('l'));
        curr = curr.getChildren().get('l');
        assertNotNull(curr.getChildren().get('l'));
        curr = curr.getChildren().get('l');
        assertNotNull(curr.getChildren().get('o'));
        curr = curr.getChildren().get('o');
        assertTrue(curr.isWord());
    }

    @Test
    public void testSearch() {
        this.trie = new DictTrie();
        this.trie.insert("hello");
        this.trie.insert("he");
        this.trie.insert("she");
        this.trie.insert("meet");
        assertTrue(this.trie.search("hello"));
        assertTrue(this.trie.search("he"));
        assertTrue(this.trie.search("she"));
        assertTrue(this.trie.search("meet"));
        assertFalse(this.trie.search("nice"));
        assertFalse(this.trie.search("meeting"));
    }

    @Test
    public void testPrefixWith() {
        this.trie = new DictTrie();
        this.trie.insert("hello");
        this.trie.insert("he");
        this.trie.insert("she");
        this.trie.insert("meet");
        assertTrue(this.trie.prefixWith("he"));
        assertTrue(this.trie.prefixWith("h"));
        assertTrue(this.trie.prefixWith("sh"));
        assertTrue(this.trie.prefixWith("me"));
        assertFalse(this.trie.prefixWith("ni"));
        assertFalse(this.trie.prefixWith("meeti"));
    }

    @Test
    public void testDelete() {
        this.trie = new DictTrie();
        this.trie.insert("he");
        this.trie.insert("hello");
        this.trie.insert("she");
        assertTrue(this.trie.search("hello"));
        assertTrue(this.trie.search("he"));
        assertTrue(this.trie.search("she"));
        this.trie.delete("he");
        this.trie.delete("she");
        assertFalse(this.trie.search("she"));
        assertFalse(this.trie.prefixWith("sh"));
        assertFalse(this.trie.search("he"));
        assertFalse(this.trie.search("she"));
        assertTrue(this.trie.prefixWith("he"));
        assertTrue(this.trie.prefixWith("hell"));
        assertTrue(this.trie.search("hello"));
    }
}
