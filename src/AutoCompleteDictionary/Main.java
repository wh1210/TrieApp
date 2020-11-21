package src.AutoCompleteDictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        DictTrie dictionary = new DictTrie();
        initializeDict(dictionary);
        dictionary.search("dicta");
        System.out.println(dictionary.wordRecommendation("dict"));
    }

    public static List<String> readWords(String file) {
        BufferedReader reader;
        List<String> words = new LinkedList<>();
		try {
			reader = new BufferedReader(new FileReader(file));
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

    public static void initializeDict(DictTrie dictionary) {
        List<String> words = readWords("words_alpha.txt");
        List<String> common_words = readWords("most_common_used_words.txt");
        for (String word : words) {
            dictionary.insert(word);
        }
        for (String word : common_words) {
            // sanity check here
            // boolean found = dictionary.search(word);
            // if (!found) System.out.println(word);
            dictionary.search(word);
        }
    }
}
