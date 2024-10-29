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
  public String getSolvedPhrase() { 
    return solvedPhrase;
  }
  public int getLetterValue() { 
    return currentLetterValue;
  }
  
  
  /* your code here - mutator(s)  */

  /* ---------- provided code, do not modify ---------- */
  public void setLetterValue()
  {
    int randomInt = (int) ((Math.random() * 10) + 1) * 100;    
    currentLetterValue = randomInt;
  }

  public boolean solvePhrase(String guess)
  {
    if (phrase.equals(guess))
    {
      return true;
    }
    return false;
  }

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
  /*
  this method takes in one parameter, which is a string (or more like a character) of the letter the player guesses
  the function loops through the phrase that they are supposed to guess
    if they guess a letter in the phrase, it is revealed
  the boolean of the letter being solved is then returned 
  */
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