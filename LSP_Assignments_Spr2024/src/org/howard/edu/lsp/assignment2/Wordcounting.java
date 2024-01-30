package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Wordcounting {

    public static void main(String[] args) throws IOException 
    {
        // Retrieve the words.text file using a relative path
        Path path = Paths.get(System.getProperty("user.dir"))
                .resolve("words.text");
        
        // Get the absolute path of the 
        Path absolutePath = path.toAbsolutePath();

        
        

        // Buffer Reads text from a character-input stream, buffering characters so as 

        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) 
        {
        	String line;
        	while ((line = reader.readLine()) != null) 
             {
             
//        	reader.reset(); //first printing out the contents of the .text file in order. Then, going through the file again (beginning to end) to count the frequency
        	Map<String, Integer> frequency = getWordFrequency(reader);
        	
        	// Display the word frequency
        	for (Map.Entry<String, Integer> entry : frequency.entrySet()) 
        	{
        	    System.out.println(entry.getKey() + ": " + entry.getValue());
        	}
        }
        }
     }
        	
       


//go through each word and count its frequency.        	
        	
        private static Map<String, Integer> getWordFrequency(BufferedReader reader) throws IOException {

            // Creating the HashMap
            Map<String, Integer> frequency = new LinkedHashMap<>(); //linked hash map stores the word frequency and sorts the output in order

            // Reading each line from the .txt file
            String line;
            while ((line = reader.readLine()) != null) 
            {
            	
                // Splitting the words (\\s+ as the delimiter, which excludes one or more whitespace characters or words THAT are at the beginning or end of a file
                String[] words = line.split("\\s+"); 

                // Looping through the file and counting the frequency of each word 
                for (String word:words) 
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
	                	// Display the word frequency
                	}

                }
            }
            return frequency;

    }
}

