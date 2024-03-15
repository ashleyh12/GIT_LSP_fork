package org.howard.edu.lsp.midterm.question1;

public class Driver {

	public static void main(String[] args) {
		/*
		 * sample text "text"
		 */
		String text = "I love CSCI363";
		String encryptedText = SecurityOps.encrypt(text);
		System.out.println("Original text: " + text);
		System.out.println("Encrypted text: " + encryptedText);
		}

	}


