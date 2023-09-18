package otm2876.truman.edu;

public class Board  {

	char[] gameBoard = new char[9]; // 3*3 array for gameBoard
	public static final int SIZE = 9;
	public static final char EMPTY = '+';
	public Board() 
	{

		//Initialize the array
		for (int i = 0; i < SIZE; i++) 
		{
			gameBoard[i] = EMPTY;
		}

	}
	
	public void drawBoard()// display function to display the content of the array( tic tac toe)
	 
	{
	 
	for (int i = 0; i < SIZE; i++) {
	 
	System.out.print("| " + gameBoard[i] + " |");
	 
	if (
	(i + 1) % 3 == 0)
	 
	System.out.println();
	 
	}
	 
	System.out.println();
	 
	}
	

	/////////////////////////////////
	
	
	// Finding if someone won or not
	public char playerHasWon() {

		//Check each row

		//Check each column

		/////////////////////////////////////////

		String sumOfChars = "";// making a string from the array elements.
		for( int index = 0; index < SIZE; index++)
		{
			sumOfChars = sumOfChars + gameBoard[index];

		}
		/**
		 * I would not like to make a comment for all of these if loops, so I will explain
		 * all of them here.
		 * this takes every single possibility of a win, the horizontal first, second, and 
		 * third row, and the vertical first, second, or third column, and if there are the win
		 * conditions in each of the spaces (those being H, or C), then the function will 
		 * return the letter corresponding to the winner.
		 */
		
		if(sumOfChars.charAt(0) == 'H' && sumOfChars.charAt(1) == 'H' &&
				sumOfChars.charAt(2) == 'H')
		{
			return 'H';
		}
		
		if(sumOfChars.charAt(0) == 'H' && sumOfChars.charAt(3) == 'H' &&
				sumOfChars.charAt(6) == 'H')
		{
			return 'H';
		}
		
		if(sumOfChars.charAt(3) == 'H' && sumOfChars.charAt(4) == 'H' &&
				sumOfChars.charAt(5) == 'H')
		{
			return 'H';
		}
		
		if(sumOfChars.charAt(1) == 'H' && sumOfChars.charAt(4) == 'H' &&
				sumOfChars.charAt(7) == 'H')
		{
			return 'H';
		}
		if(sumOfChars.charAt(6) == 'H' && sumOfChars.charAt(7) == 'H' &&
				sumOfChars.charAt(8) == 'H')
		{
			return 'H';
		}
		if(sumOfChars.charAt(2) == 'H' && sumOfChars.charAt(5) == 'H' &&
				sumOfChars.charAt(8) == 'H')
		{
			return 'H';
		}
		if(sumOfChars.charAt(0) == 'H' && sumOfChars.charAt(4) == 'H' &&
				sumOfChars.charAt(8) == 'H')
		{
			return 'H';
		}
		if(sumOfChars.charAt(2) == 'H' && sumOfChars.charAt(4) == 'H' &&
				sumOfChars.charAt(6) == 'H')
		{
			return 'H';
		}
		
		////////////////////////////////////////////////////////////////////////
		
		if(sumOfChars.charAt(0) == 'C' && sumOfChars.charAt(1) == 'C' &&
				sumOfChars.charAt(2) == 'C')
		{
			return 'C';
		}
		
		if(sumOfChars.charAt(0) == 'C' && sumOfChars.charAt(3) == 'C' &&
				sumOfChars.charAt(6) == 'C')
		{
			return 'C';
		}
		
		if(sumOfChars.charAt(3) == 'C' && sumOfChars.charAt(4) == 'C' &&
				sumOfChars.charAt(5) == 'C')
		{
			return 'C';
		}
		
		if(sumOfChars.charAt(1) == 'C' && sumOfChars.charAt(4) == 'C' &&
				sumOfChars.charAt(7) == 'C')
		{
			return 'C';
		}
		if(sumOfChars.charAt(6) == 'C' && sumOfChars.charAt(7) == 'C' &&
				sumOfChars.charAt(8) == 'C')
		{
			return 'C';
		}
		if(sumOfChars.charAt(2) == 'C' && sumOfChars.charAt(5) == 'C' &&
				sumOfChars.charAt(8) == 'C')
		{
			return 'C';
		}
		if(sumOfChars.charAt(0) == 'C' && sumOfChars.charAt(4) == 'C' &&
				sumOfChars.charAt(8) == 'C')
		{
			return 'C';
		}
		if(sumOfChars.charAt(2) == 'C' && sumOfChars.charAt(4) == 'C' &&
				sumOfChars.charAt(6) == 'C')
		{
			return 'C';
		}
		

		if (sumOfChars.indexOf(EMPTY) < 0)// looking if there is any '+' left.
		// if not then it means the gameBoard is full and it is a tie
		{	return 'T';}
		
		
		
		

		//Check the diagonals


		// Otherwise nobody has won yet
		return ' ';

	}



}