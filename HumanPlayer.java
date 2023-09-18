package otm2876.truman.edu;

import java.util.Scanner;

public class HumanPlayer extends Player {

	char[] gameBoard;

	public HumanPlayer(Board obj) {
		gameBoard = obj.gameBoard;
	}

	/**
	 * Function designed to return board position
	 * @return board position
	 */
	public int boardPosition() {

		return move;
	}

	/**
	 * function designed to set board position, when next move is processed
	 * @param m int to set onto move
	 */
	public void setBoardPosition(int m) {
		move = m;
	}

	/**
	 * function used to handle all moves by the human
	 */
	public void CompNextMove() 
	{
	
			gameBoard[boardPosition()] = 'H';
		
	}

}