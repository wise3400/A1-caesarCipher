/* *****************************************************************************
 *              ALL STUDENTS COMPLETE THESE SECTIONS
 * Title:            Caesar Cipher
 * Files:            None
 * Semester:         Spring 2022
 * 
 * Author:           Wilson Seet, wilson.seet@colorado.edu
 * 
 * Description:		 A Caesar Cipher code that encrypt and decrypt messages, using user inputs. 
 * 
 * Written:       	 1/25/22
 * 
 * Credits:          Ruo helped me with debugging and Daniel reminded me how to write methods. My high school CS teacher helped me understand the assignment.
 * 
 **************************************************************************** */

import java.util.Scanner;
/**
 * This is the Caesar Cipher class. It includes methods and implementation of asking the user to enter a message to decrypt or encrypt.
 * Void methods of encryption and decryption by passing the string to encrypt and the key. (More comments on the bottom to describe how they work)
 *
 * <p>Bugs: No bugs. Except for removing special characters which Ruo helped me with during class. 
 *
 * @author Wilson Seet
 */
public class CaesarCipher 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String in1 = "";
	    
		// prompts user to enter a message.
	    System.out.println("Enter your message: ");
	    
	    // storing the message in user_input
	    Scanner user_input = new Scanner(System.in);
	    
	    // allows for spacing
	    in1 += user_input.nextLine();
	    
	    // converts everything to upper case.
	    String in1Upper = in1.toUpperCase();
	    
	    //ask user to enter key or enter -1 to decrypt all 25 keys
	    System.out.println("Enter your key (> 0 , <26) or enter -1 to try decrypting with all keys: ");
	    int enterNum = user_input.nextInt();
		
	    // enter -1 if you don't know the key
	    if (enterNum == -1) 
	    {
	      System.out.println("Ok - trying all keys to decode message " + in1Upper);
	     //a loop that goes through all 1 to 26. But really it is 25.
	     for (int i = 1; i < 26; i++) 
	     {
	         // print out ALL DECRYPTION
	         System.out.print("Trying key = " + i + " " + "Decryption: " );
	         
	         //call decryption method and pass in parameters
	         decryption(in1Upper, i);
	         System.out.println();
	      }
	       return;
	        
	      }  
	    // while loop: if you enter less than 0 or greater than 26, gives you error.
	    // and prompts you again.
	    else
	    {
	        while (enterNum < 0 || enterNum > 26) 
	        {
	          System.out.println("Error your key must be > 0");
	          System.out.println("Enter your key (> 0 , <26): ");
	          enterNum = user_input.nextInt();
	        }

	    }
	    
	    // brings and asks the user the menu option: 1 for encryption, 2 decrypt
	    System.out.println("Enter 1 for encryption, 2 for decryption: ");
	    int menu1 = user_input.nextInt();
	    
	    // while loop: if the menu is not 1 or 2. gives an error and prompts user again
	    while (menu1 < 1 || menu1 > 2) 
	    {
	      System.out.println("Error your menu selection must be 1 or 2.");
	      System.out.println("Enter 1 for encryption, 2 for decryption: ");
	      menu1 = user_input.nextInt();
	    }
	    
	    //if user pressed 1 bring them encryption and do work.
	    if (menu1 == 1) 
	    {
	      //call encryption and pass in parameters and do work.
	      encryption(in1Upper, enterNum);
	    }
	    
	    //if user pressed 2 bring them decryption and do work.
	    if (menu1 == 2) 
	    {
	       //call decryption and pass in parameters and do work.
	      decryption(in1Upper, enterNum);
	    }
	  }

	// encryption begins. This is encryption method passing stringToencrypt and key.
    public static void encryption(String stringToencrypt, int key )
    {
          //go through the string 
          for (int i = 0; i < stringToencrypt.length(); i++) 
          {
            // converts distance from A. Similar to letter index
            int letterValue = stringToencrypt.charAt(i) - 'A';
            
            // shifting number by the key
            letterValue += key;

            // if letterValue is higher than Z
            if (letterValue >= 26) // 26 = 0 27 = 1 28 = 2
            {
              // Go back to A
              letterValue = letterValue - 26;
            }
            
            //this gets rid of characters and makes space
            if(letterValue < 0 || letterValue > 25)
            {
              System.out.print(stringToencrypt.charAt(i));
            }
           
            else
            {
            	// Converts numbers to the letters
	            char newLetter = (char) ('A' + letterValue);
	            // print out the letters
	            System.out.print(newLetter);

            }
        }
    } 
    
    //decryption. This is decryption method passing stringToDecrypt and key.
    public static void decryption(String stringToDecrypt, int key)
    {
       for (int i = 0; i < stringToDecrypt.length(); i++) 
       {
         // converts distance from A. Similar to letter index
         int letterValue = stringToDecrypt.charAt(i) - 'A';
         
         // shifting number backwards because of decryption
         letterValue -= key;

         // if letterValue is lower than A: symbol signs
         if (letterValue < 0) // -1 = 25 -2 = 24 -3 = 23
         {
           // Go back to A
           letterValue = letterValue + 26;
         }
         
         //this gets rid of characters and makes space
         if(letterValue < 0 || letterValue > 25)
         {
           System.out.print(stringToDecrypt.charAt(i));
         }
         
         else
         {
         
         // Converts numbers to the letters
         char newLetter = (char) ('A' + letterValue);
         // print out the letters
         System.out.print(newLetter);

         }
         
       }

   }	
}
