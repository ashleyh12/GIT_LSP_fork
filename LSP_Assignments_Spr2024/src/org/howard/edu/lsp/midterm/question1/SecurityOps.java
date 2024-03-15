package org.howard.edu.lsp.midterm.question1;

public class SecurityOps 
{	
		    public static String encrypt(String text) 
		    {
		    	/**
		    	 * returning an empty string if the input is null/empty
		    	 */
		    	if (text == null || text.isEmpty()) 
		    	{
		            return "";
		        }
		    	
		        /**
		         * appending even-indexed characters to StringBuilder and evenChars. 
		         *  odd-index characters to another StringBuilder oddChars
		        */
		        StringBuilder encryptedText = new StringBuilder(); 
		        StringBuilder evenChars = new StringBuilder();
		        StringBuilder oddChars = new StringBuilder();
		        
		        /*
		         *  iterating through the characters of the input text
		         */
		        for (int i = 0; i < text.length(); i++) { //starting at zero
		            char ch = text.charAt(i); //retrieves the character at index i from the string text
		            //  assigns the retrieved character to the variable 'ch'
		            if (Character.isLetterOrDigit(ch)) {
		                if (i % 2 == 0) {
		                    evenChars.append(ch); // appending the even-index characters to  ch 
		                } else {
		                    oddChars.append(ch); // append odd-index characters to  ch 
		                }
		            }
		        }
		        
		        /*
		         * appending the  even and odd characters to the encrypted text
		         */
		        encryptedText.append(evenChars).append(oddChars);
		        
		        return encryptedText.toString(); //returning the final encrypted string
		    }
		

	}

