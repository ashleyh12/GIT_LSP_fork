package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Wordcounting {

    public static void main(String[] args) throws IOException {
        // Grab the file using a relative path
        Path path = Paths.get(System.getProperty("user.dir"))
                .resolve("words.text");

        // Buffer Reads text from a character-input stream, buffering characters so as 
        // to provide for the efficient reading of characters... more efficient than Scanner
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
        	
        	
            // Creating the HashMap
            Map<String, Integer> frequency = new HashMap<>();

            // Reading each line from the .txt file
            String line;
            while ((line = reader.readLine()) != null) {
            	
            	
                // Splitting the words 
                String[] words = line.split(" ");

                // Counting the frequency of each word found in the file
                for (String word : words) {
                    word = word.toLowerCase(); // Converting the words to lowercase (ex: Design and design are seen as the same)
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1); //making the word = key, frequency = value being incremented
                }
            }

            // Display the word frequency
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) 
        {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}

