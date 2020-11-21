package test;

import static org.junit.Assert.*;

import org.junit.Test;

import src.ArrayTrieSize26.ArrayTrieSize26;
import src.ArrayTrieSize26.ArrayTrieSize26Node;

public class ArrayTrieSize26Test {
    public ArrayTrieSize26 trie;

    @Test
    public void testInsert() {
        this.trie = new ArrayTrieSize26();
        this.trie.insert("hello");
        ArrayTrieSize26Node curr = this.trie.root;
        assertNotNull(curr.getChildrenAtIndex('h' - 'a'));
        assertNull(curr.getChildrenAtIndex('s' - 'a'));
        curr = curr.getChildrenAtIndex('h' - 'a');
        assertNotNull(curr.getChildrenAtIndex('e' - 'a'));
        curr = curr.getChildrenAtIndex('e' - 'a');
        assertNotNull(curr.getChildrenAtIndex('l' - 'a'));
        curr = curr.getChildrenAtIndex('l' - 'a');
        assertNotNull(curr.getChildrenAtIndex('l' - 'a'));
        curr = curr.getChildrenAtIndex('l' - 'a');
        assertNotNull(curr.getChildrenAtIndex('o' - 'a'));
        curr = curr.getChildrenAtIndex('o' - 'a');
        assertTrue(curr.isWord());
    }

    @Test
    public void testSearch() {
        this.trie = new ArrayTrieSize26();
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
        this.trie = new ArrayTrieSize26();
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
        this.trie = new ArrayTrieSize26();
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
