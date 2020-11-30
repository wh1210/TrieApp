package src.AutoCompleteDictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DictTrie dictionary = new DictTrie();
        initializeDict(dictionary);
        System.out.println("Please choose the operation(enter the number): ");
        System.out.println("1: search if the word exists");
        System.out.println("2: word recommendation");
        System.out.println("3: exit");
        Scanner console = new Scanner(System.in);
        operations(dictionary, console);
    }

    public static void operations(DictTrie dictionary, Scanner console) {
        String operation;
        boolean keeping = true;
        while (keeping) {
            operation = console.nextLine();
            if (operation.equals("1")) {
                System.out.println("Please input the word you want to check:");
                String word = console.nextLine();
                boolean exist = dictionary.search(word);
                if (exist) {
                    System.out.println("This word exists! You can continue by input operation number.");
                } else {
                    System.out.println("This word doesn't exist! You can continue by input operation number.");
                }
            } else if (operation.equals("2")) {
                System.out.println("Please input the prefix you want to search for:");
                String prefix = console.nextLine();
                System.out.println("These are top 10(if there are) words starting with this prefix(tie-breaker by your search frequency)");
                System.out.println(dictionary.wordRecommendation(prefix));
                System.out.println("You can continue by input operation number.");
            } else if (operation.equals("3")) {
                System.out.println("Thanks for using this dictionary!");
                keeping = false;
                return;
            } else {
                System.out.println("Input is invalid, please input again.");
                System.out.println("Please choose the operation(enter the number): ");
                System.out.println("1: search if the word exists");
                System.out.println("2: word recommendation");
                System.out.println("3: exit");
            }
        }
        
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
