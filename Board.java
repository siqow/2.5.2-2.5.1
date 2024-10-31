/*
 * Activity 2.5.2
 *
 * A Board class the PhraseSolverGame
 */
import java.io.File;
import java.util.Scanner;

public class  Board
{
  private String solvedPhrase;
  private String phrase;
  private int currentLetterValue; 

  /* your code here - constructor(s) */
  /**
   * Outputs the phrase that the user should see to make their guesses
   * Doesn't take any arguments
   * loads the phrase and sets the letter value (by calling the functions)
   * @param none
   * @return none
   * @see phrase
  **/ 
  public Board()
  {
    solvedPhrase = "";
    phrase = "";
    currentLetterValue = 0;
    phrase = loadPhrase();
    setLetterValue();
    System.out.println("Phrase: " + phrase);
  }

  /* your code here - accessor(s) */
  /**
   * returns a String of the solved phrase
   * doesn't take any parameters 
   * @param none
   * @return solvedPhrase
  **/
  public String getSolvedPhrase() { 
    return solvedPhrase;
  }

  /**
   * returns an integer of the value of the letter 
   * doesn't take any parameters 
   * @param none
   * @return currentLetterValue
  **/
  public int getLetterValue() { 
    return currentLetterValue;
  }
  
  
  /* your code here - mutator(s)  */

  /* ---------- provided code, do not modify ---------- */
  /**
   * no return value, only update the variables 
   * generates a random integer between 0 and 1000 
   * sets this random integer to the currentLetterValue
   * doesn't take any parameters 
   * @param none
   * @return none
  **/
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  /**
   * returns a boolean, representing if the phrase is solved or not 
   * takes a parameter of the player's currently solved phrase 
   * check if the player's guess equals the phrase 
   * @param guess a string of the player's guess
   * @return boolean whether the phrase is solved or not
  **/
  public boolean solvePhrase(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

  /**
   * returns a String, with all the dashes for the letter the player hasn't guessed and the proper letter for the one they have guessed
   * doesn't take any parameters
   * checks the phrase if it is solved and updates the phrase (with the player's guesses)
   * @return solvedPhrase if the phrase is solved (all letters are guessed)
  **/
  private String loadPhrase()
  {
    String tempPhrase = "";
    
    int numOfLines = 0;
    try 
    {
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        tempPhrase = sc.nextLine().trim();
        numOfLines++;
      }
    } catch(Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
		int randomInt = (int) ((Math.random() * numOfLines) + 1);
    
    try 
    {
      int count = 0;
      Scanner sc = new Scanner(new File("phrases.txt"));
      while (sc.hasNextLine())
      {
        count++;
        String temp = sc.nextLine().trim();
        if (count == randomInt)
        {
          tempPhrase = temp;
        }
      }
    } catch (Exception e) { System.out.println("Error reading or parsing phrases.txt"); }
    
    for (int i = 0; i < tempPhrase.length(); i++)
    {
      if (tempPhrase.substring(i, i + 1).equals(" "))
      {
        solvedPhrase += "  ";
      }  
      else
      {
        solvedPhrase += "_ ";
      }
    }  
    
    return tempPhrase;
  }  
  /** 
   * this method takes in one parameter, which is a string (or more like a character) of the letter the player guesses
   * the function loops through the phrase that they are supposed to guess
   * if they guess a letter in the phrase, it is revealed
   * the boolean of the letter being solved is then returned
   * @param guess the player's guess (a letter)
   * @return foundLetter if the letter was found in the phrase
  **/
  public boolean guessLetter(String guess)
  {
    // a boolean representing is a letter was found in the phrase
    boolean foundLetter = false;
    // a String of the new phrase with all the newly guessed letter revealed
    String newSolvedPhrase = "";
    
    // loop through the phrase
    for (int i = 0; i < phrase.length(); i++)
    {
      // if the guessed letter is in the phrase
      if (phrase.substring(i, i + 1).equals(guess))
      {
        // update the newSolvedPhrase variable
        newSolvedPhrase += guess + " ";
        // change the boolean to true (because it was found)
        foundLetter = true;
      }
      else
      {
        // otherwise, do not reveal the letter
        newSolvedPhrase += solvedPhrase.substring(i * 2, i * 2 + 1) + " ";  
      }
    }
    // update the public solved phrase vairable (so that it can be updated for the whole game)
    solvedPhrase = newSolvedPhrase;
    // return the letter that was found
    return foundLetter;
  } 
} 