package src.test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.Trie;
import src.TrieNode;

public class TrieTest {
    public Trie trie;

    @Test
    public void testInsert() {
        this.trie = new Trie();
        this.trie.insert("hello");
        TrieNode curr = this.trie.root;
        assertNotNull(curr.getChildrenAtIndex('h'));
        assertNull(curr.getChildrenAtIndex('s'));
        curr = curr.getChildrenAtIndex('h');
        assertNotNull(curr.getChildrenAtIndex('e'));
        curr = curr.getChildrenAtIndex('e');
        assertNotNull(curr.getChildrenAtIndex('l'));
        curr = curr.getChildrenAtIndex('l');
        assertNotNull(curr.getChildrenAtIndex('l'));
        curr = curr.getChildrenAtIndex('l');
        assertNotNull(curr.getChildrenAtIndex('o'));
        curr = curr.getChildrenAtIndex('o');
        assertTrue(curr.isWord());
    }

    @Test
    public void testSearch() {
        this.trie = new Trie();
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
        this.trie = new Trie();
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
        this.trie = new Trie();
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
