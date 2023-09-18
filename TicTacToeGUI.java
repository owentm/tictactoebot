package otm2876.truman.edu;

/**
 * @author Dr. Kafi Rahman
 * @author Mr. Owen Murphy
 */

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGUI implements ActionListener {
	

	// cMove is the index stored from the compMove function, that allows the 
	// integer position to be inserted into the GUI panel
	public int cMove;
	final int SIZE = 9;
	
	// stop will be used for input validation to make sure that the player cannot select 
	// a panel after someone wins/a tie happens
	boolean stop = false;
	
	// make a gameBoard to store the array, and objects to make moves
	public Board gameBoard = new Board();

	public CompPlayer computer = new CompPlayer(gameBoard);
	public HumanPlayer human = new HumanPlayer(gameBoard);
	
	// Buttons to hold the selection values
	JButton boardButtons[] = new JButton[SIZE];

	// buttons to restart or exit the game
	JButton bRestart;
	JButton bExit;

	// to provide status message
	JLabel gameStatusLabel;
	JFrame gWindow; // main window object

	boolean moveToggleFlag = false; // toggles computer/user move
	int gameMoveCount = 0; // counts the number of moves to determine draw, etc

	// constructor
	public TicTacToeGUI(String title) {

		// creating a JFrame window with the title
		gWindow = new JFrame(title);

		// The JPanel holds the buttons
		JPanel upperLayerPanel = new JPanel();
		upperLayerPanel.setLayout(new GridLayout(3, 3));
		// creating memory for the buttons
		for (int i = 0; i < SIZE; i++) {
			boardButtons[i] = new JButton();
			boardButtons[i].setText(Integer.toString(i + 1));
			boardButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 20));
			boardButtons[i].addActionListener(this);

			// adding the button to the Panel
			upperLayerPanel.add(boardButtons[i]);
		}

		// Panel holding buttons at the south side
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(2, 1));

		bRestart = new JButton("Restart Game");
		bRestart.setFont(new Font("SansSerif", Font.PLAIN, 16));
		bRestart.addActionListener(this);

		bExit = new JButton("Exit Game");
		bExit.setFont(new Font("SansSerif", Font.PLAIN, 16));
		bExit.addActionListener(this);

		gameStatusLabel = new JLabel("   Welcome. Your Turn. Select any button above to begin ..");
		gameStatusLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		gameStatusLabel.setPreferredSize(new Dimension(100, 40));

		southPanel.add(gameStatusLabel, BorderLayout.CENTER);

		JPanel lowerButtonPanel = new JPanel();
		lowerButtonPanel.setLayout(new GridLayout(1, 2));
		lowerButtonPanel.add(bRestart, BorderLayout.WEST);
		lowerButtonPanel.add(bExit, BorderLayout.EAST);
		southPanel.add(lowerButtonPanel);

		// adding all the panels to the main window
		gWindow.setLayout(new BorderLayout());
		gWindow.add(upperLayerPanel, BorderLayout.CENTER);
		gWindow.add(southPanel, BorderLayout.SOUTH);

		gWindow.setSize(500, 500);
		gWindow.setVisible(true);
		gWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * exit game closes the GUI window
	 */
	public void exitGame() 
	{
		gWindow.dispose();
	}

	// this resets the buttons text values
	/**
	 * reset game makes all of the panels have the original numbers, and sets all the colors
	 * to black, and it also makes it so stop, which restricts player movements, is 
	 * set back to false
	 */
	public void resetGame() {
		// creating memory for the buttons
		for (int i = 0; i < SIZE; i++) {
			// reset the button text here
			String number = Integer.toString(i + 1); // when going through each element, make
														// the current index a string (plus one to
														// account for 0 index, and put string into
														// the value for the button

			boardButtons[i].setText(number);
			boardButtons[i].setForeground(Color.BLACK); // set all of the buttons all back to black
			for(int index = 0; index < SIZE; index++)
			{
				gameBoard.gameBoard[index] = '+';
			}
			
			stop = false;
			

		}

		gameMoveCount = 0;

		// other actions can be taken here
	}

	
	
	

	/**
	 * action performed handles most of the program
	 * this function makes it so when an event happens, the computer makes 
	 * its move, and then sees to see if anyone wins
	 * @param event is the event that the function catches
	 */
	public void actionPerformed(ActionEvent event)
	{
		
		
		
		
		
		// if the event source is the restart button then
		if (event.getSource().equals(bRestart)) 
		{
			// reset the game
			resetGame();
			gameStatusLabel.setText("Welcome. Your Turn. Select any button above to begin ..");
			gWindow.setTitle(" TicTacToe game ");

		} 
		
		else if (event.getSource().equals(bExit)) 
		{
			exitGame();
		} 
		
		else 
		{ // determine which cell button triggered the action event
			for (int i = 0; i < SIZE; i++) {
				if (event.getSource().equals(boardButtons[i])) { // button found
					
					// if the cell has already been selected then do not do anything
					// as well as this, if stop is true, meaning that someone has won,
					// do not allow any further input
					if (boardButtons[i].getText().equals("H") == false
							&& boardButtons[i].getText().equals("C") == false && stop == false) 
					{

						// this is the selected cell number
						
						gameStatusLabel.setText("  You have selected cell no " + (i + 1));

						// update the button text to indicate computer/human
						
						// make the gameBoard update, to allow for computations
						gameBoard.gameBoard[i] = 'H';
						
						boardButtons[i].setText("H");
						boardButtons[i].setForeground(Color.BLUE);
						
						// if human has won, immediately stop
						if(gameBoard.playerHasWon() == 'H')
						{
							gameStatusLabel.setText("Human has won! Please restart to play again!");
							gWindow.setTitle("Human wins! Restart to play again");
							stop = true;
							break;
						}
						
					
						
						moveToggleFlag = !moveToggleFlag;

						gameMoveCount++; // keep counting the moves
						
					
						
						// compute the next move, therefore setting the cMove variable
						computer.CompNextMove();
						cMove = computer.move;
						gameBoard.gameBoard[cMove] = 'C';
						
						
						
						
						// update GUI to reflect this
						boardButtons[cMove].setText("C");
						boardButtons[cMove].setForeground(Color.RED);
						
					
						
						
						
						
				
						// now see if computer has won
						if(gameBoard.playerHasWon() == 'C')
						{
							gameStatusLabel.setText("Computer Has won! Better luck next time");
							gWindow.setTitle("Computer wins! Restart to play again");
							stop = true;
							break;
						}
						// now, count another move to account for the move taken 
						// by the computer
						gameMoveCount++;
						
						
						
						
						//finally, compute tie
						if (gameMoveCount >= SIZE) { // if this is the last move
							gameStatusLabel.setText("    The Game Over! Restart the game to continue ...");
							gWindow.setTitle("TicTacToe [Game Over!]");
						}
						else
						{
							
						}

					} // new move: if condition ends

					

				} // main if inside the loop ends
			} // for loop ends
		} // else block ends
	} // actionPerformed function ends

	// main driver program
	// now, simply create an object of the GUI class, and let the event handler do the hard work
	public static void main(String[] args) {
		// create an object of the TikTakToe class

		TicTacToeGUI gameWindow = new TicTacToeGUI("TicTacToe Game");
	
	

}
}