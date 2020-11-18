package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import src.ArrayTrie.ArrayTrie;
import src.MapTrie.MapTrie;

public class TrieComparison {
    public static void main(String[] args) {
        List<String> words = readWords();
        System.out.println("The words dictionary size is: " + words.size());
        ArrayTrie arrayTrie = new ArrayTrie();
        MapTrie mapTrie = new MapTrie();

        System.out.println("The time for arrayTrie to add all words is: " + arrayTrieInsertTime(arrayTrie, words));
        System.out.println("The time for mapTrie to add all words is: " + mapTrieInsertTime(mapTrie, words));

        System.out.println("The time for arrayTrie to search ten words is: " + arrayTrieSearchTime(arrayTrie));
        System.out.println("The time for mapTrie to search ten words is: " + mapTrieSearchTime(mapTrie));

        System.out.println("The time for arrayTrie to delete ten words is: " + arrayTrieDeleteTime(arrayTrie));
        System.out.println("The time for mapTrie to delete ten words is: " + mapTrieDeleteTime(mapTrie));
    }

    public static List<String> readWords() {
        BufferedReader reader;
        List<String> words = new LinkedList<>();
		try {
			reader = new BufferedReader(new FileReader("words_alpha.txt"));
			String word = reader.readLine();
			while (word != null) {
				words.add(word);
				word = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return words;
    }

    public static long arrayTrieInsertTime(ArrayTrie arrayTrie, List<String> words) {
        long startTime = System.nanoTime();

        for (String word : words) {
            arrayTrie.insert(word);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long mapTrieInsertTime(MapTrie mapTrie, List<String> words) {
        long startTime = System.nanoTime();

        for (String word : words) {
            mapTrie.insert(word);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long arrayTrieSearchTime(ArrayTrie arrayTrie) {
        long startTime = System.nanoTime();

        arrayTrie.search("hello");
        arrayTrie.search("zooidiophilous");
        arrayTrie.search("wrappering");
        arrayTrie.search("vicegerentship");
        arrayTrie.search("scalenohedrons");
        arrayTrie.search("paramagnetically");
        arrayTrie.search("leguminiform");
        arrayTrie.search("defunctionalization");
        arrayTrie.search("azotobacterieae");
        arrayTrie.search("backpedaling");

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long mapTrieSearchTime(MapTrie mapTrie) {
        long startTime = System.nanoTime();

        mapTrie.search("hello");
        mapTrie.search("zooidiophilous");
        mapTrie.search("wrappering");
        mapTrie.search("vicegerentship");
        mapTrie.search("scalenohedrons");
        mapTrie.search("paramagnetically");
        mapTrie.search("leguminiform");
        mapTrie.search("defunctionalization");
        mapTrie.search("azotobacterieae");
        mapTrie.search("backpedaling");

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long arrayTrieDeleteTime(ArrayTrie arrayTrie) {
        long startTime = System.nanoTime();

        arrayTrie.delete("hello");
        arrayTrie.delete("zooidiophilous");
        arrayTrie.delete("wrappering");
        arrayTrie.delete("vicegerentship");
        arrayTrie.delete("scalenohedrons");
        arrayTrie.delete("paramagnetically");
        arrayTrie.delete("leguminiform");
        arrayTrie.delete("defunctionalization");
        arrayTrie.delete("azotobacterieae");
        arrayTrie.delete("backpedaling");

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }

    public static long mapTrieDeleteTime(MapTrie mapTrie) {
        long startTime = System.nanoTime();

        mapTrie.delete("hello");
        mapTrie.delete("zooidiophilous");
        mapTrie.delete("wrappering");
        mapTrie.delete("vicegerentship");
        mapTrie.delete("scalenohedrons");
        mapTrie.delete("paramagnetically");
        mapTrie.delete("leguminiform");
        mapTrie.delete("defunctionalization");
        mapTrie.delete("azotobacterieae");
        mapTrie.delete("backpedaling");

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        return duration;
    }
}
