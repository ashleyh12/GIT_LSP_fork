package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;


public class Wordcounting {

    public static void main(String[] args) throws IOException {
    	
    	
//         Retrieve the words.text file using a relative path
        Path path = Paths.get(System.getProperty("user.dir")).resolve("src/org/howard/edu/lsp/assignment2/words.txt");

        // Buffer Reads text from a character-input stream, buffering characters
    	
    	
    	
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) 
        {
            Map<String, Integer> frequency = getWordFrequency(reader);

            // Display the word frequency 
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) 
            {
                System.out.println(entry.getKey() + ": " + entry.getValue()); //making the word = key, frequency = value being incremented
            }
        }
    }

    // Go through each word and count its frequency.
    private static Map<String, Integer> getWordFrequency(BufferedReader reader) throws IOException {
    	
        // Creating the LinkedHashMap
        Map<String, Integer> frequency = new LinkedHashMap<>(); //linked hash map stores the word frequency and sorts the output in order

        // Read the first line from the .txt file
        String line = reader.readLine();

        // Includes the first word in the file
        if (line != null) 
        {
            String[] words = line.split("\\s+");
            for (String word : words) 
            {
            	//if the first word has a length of 4 or more and doesn't contain a number, then print it
            	//we use “.*\\d.*” as regex to denote that the string contains at least one digit (https://www.baeldung.com/java-string-number-presence)
                if (word.length() >= 4 && !word.matches(".*\\d.*")) 
                {
                	word = word.replaceAll("[^a-zA-Z0-9']", "");
                    word = word.toLowerCase();
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        
        // Reading the rest of the lines and counting the frequency of each word until we reach the end of the file
        while ((line = reader.readLine()) != null) 
        {
            String[] words = line.split("\\s+");
            
            for (String word : words) 
            {
            	//if the rest of the words in the file have a length >=4 and doesn't have a number

                if (word.length() >= 4 && !word.matches(".*\\d.*")) 
                {
                	word = word.replaceAll("[^a-zA-Z0-9']", "");
                    word = word.toLowerCase();
                    frequency.put(word, frequency.getOrDefault(word, 0) + 1);
                }
            }
        }

        return frequency;
    }

}




