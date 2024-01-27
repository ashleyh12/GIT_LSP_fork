package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Wordcounting {

    public static void main(String[] args) throws IOException 
    {
        // Retrieve the words.text file using a relative path
        Path path = Paths.get(System.getProperty("user.dir"))
                .resolve("words.text");
        

//        // Display the file path of the file object 
//        // and also the file path of absolute file 
//        System.out.println("Original  path: " + f.getPath()); 
//        System.out.println("Absolute  path: " + absolute);
//        

  

        // Buffer Reads text from a character-input stream, buffering characters so as 
        // to provide for the efficient reading of characters... more efficient than Scanner
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) 
        {
        	Map<String, Integer> frequency = getWordFrequency(reader);
        	
        	// Display the word frequency
        	for (Map.Entry<String, Integer> entry : frequency.entrySet()) 
        	{
        	    System.out.println(entry.getKey() + ": " + entry.getValue());
        	}
        }
        }
        	
        	

//go through each word and count its frequency.        	
        	
        private static Map<String, Integer> getWordFrequency(BufferedReader reader) throws IOException {

            // Creating the HashMap
            Map<String, Integer> frequency = new HashMap<>();

            // Reading each line from the .txt file
            String line;
            while ((line = reader.readLine()) != null) 
            {
            	
            	
                // Splitting the words (.split excludes white space )
                String[] words = line.split(" ");

                // Looping through the file and counting the frequency of each word 
                for (String word : words) 
                {
                	//we use “.*\\d.*” as regex to denote that the string contains at least one digit (https://www.baeldung.com/java-string-number-presence)
                	if (word.length() < 3 || word.matches(".*\\d.*"))
                	{
                		continue;
                	}
                	else
                	{
	                    word = word.toLowerCase(); // Converting the words to lowercase (ex: Design and design are seen as the same)
	                    frequency.put(word, frequency.getOrDefault(word, 0) + 1); //making the word = key, frequency = value being incremented
                	}
                }
            }
            return frequency;

    }
}

