/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board board;
  private Boolean solved;
  /* your code here - constructor(s) */ 

  /** 
   * initializes all the players and the board 
   * @param none
   * @return none
  **/
  public PhraseSolver()
  {
    player1 = null;
    player2 = null;
    board = null;
    solved = false;
    Player player1 = new Player();
    Player player2 = new Player();
    Board board = new Board();
  }
  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  /** 
   * check if the game is solved
   * @param none
   * @return none
  **/
  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {
      
      /* your code here - game logic */
      
      
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}