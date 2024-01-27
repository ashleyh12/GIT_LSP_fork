package org.howard.edu.lsp.assignment2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Wordcounting {

	public static void main(String[] args) throws IOException{
		//grab the file using a relative path
		Path path = Paths.get(System.getProperty("user.dir"))
				.resolve("words.text");
		//Buffer Reads text from a character-input stream, buffering characters so as 
//		to provide for the efficient reading of characters... more efficient than Scanner
		BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
		FileInputStream fin = new FileInputStream("words.text");
		
		//creating the HashMap
		Map<String, Integer> frequency = new HashMap<>();
		
		//reading each line from the .txt file
		String line;
		while ((line = reader.readLine()) != null)
		{
			//splitting the words 
			String [] words = line.split(" ");
			
			//counting the frequency of each word found in the file
			for (String word: words) {
				word = word.toLowerCase(); //converting the words to lowercase (ex: Design and design are seen as the same)
				frequency.put(word, frequency.getOrDefault(word, 0) + 1);
			}
			
		}

	}

}
