package otm2876.truman.edu;

public class CompPlayer extends Player{


	char[] gameBoard;
	public CompPlayer(Board obj) {
		gameBoard = obj.gameBoard;
	}
	
	int computerMove()
	{
		return move;
	}

	boolean compuTerWinCheck() {
		

		//Winning approach for Computer
		for(int i =0; i<3; i++)
		{
			// checking if there is a possible row combination that can be used to win and doing all
			// three rows in a loop
			// There is A LOT that I'd have to explain here for it to make sense, so I will
			// just explain it here
			// when the computer computes the best way for it to make a move, instead of computing
			// the move and inserting it into the array here, like it did in the initial program, 
			// it now will just set an int variable that denotes the index space, and then
			// input it into the gameboard in the main GUI .java application.

			if (getRowTotal(gameBoard, i).equals("CC+")) {
				move = i * 3 + 2;
			
				return true;
			}
			else if(getRowTotal(gameBoard,i).equals("C+C")){
				move = i * 3 + 1;
			
				return true;
			}else if (getRowTotal(gameBoard,i).equals("+CC")){
				move = i * 3;
				
				return true;
			}


			// checking if there is a possible column combination that can be used to win
			// and doing all three column in a loop
			if (getColumnTotal(gameBoard, i).equals("CC+")) {
				move = i + 6;
		
				return true;
			} else if (getColumnTotal(gameBoard, i).equals("C+C")) {
				move = i + 3;
			
				return true;
			} else if (getColumnTotal(gameBoard, i).equals("+CC")) {
				move = i;
			
				return true;
			}

		}


		if (getFirstDiagnolTotal(gameBoard).equals("CC+")) {
			move = 8;
			return true;
		} else if (getFirstDiagnolTotal(gameBoard).equals("C+C")) {
			move = 4;
			return true;
		} else if (getFirstDiagnolTotal(gameBoard).equals("+CC")) {
			move = 0;
			return true;
		}

		if (getSecondDiagnolTotal(gameBoard).equals("CC+")) {
			move = 6;
			return true;
		} else if (getSecondDiagnolTotal(gameBoard).equals("C+C")) {
			move = 4;
			return true;
		} else if (getSecondDiagnolTotal(gameBoard).equals("+CC")) {
			move = 2;
			return true;
		}

		return false;
	}
	
	
	


	boolean humanWinCheck() {
		
		// There is A LOT that I'd have to explain here for it to make sense, so I will
		// just explain it here
		// when the computer computes the best way for it to make a move, instead of computing
		// the move and inserting it into the array here, like it did in the initial program, 
		// it now will just set an int variable that denotes the index space, and then
		// input it into the gameboard in the main GUI .java application.
		

		// Winning condition for Human
		for (int i = 0; i < 3; i++) 
		{
			// checking if there is a possible row combination that can be used to win and
			// doing all three rows in a loop

			if (getRowTotal(gameBoard, i).equals("HH+")) 
			{
				move = i * 3 + 2;
				
				return true;
			} 
			else if (getRowTotal(gameBoard, i).equals("H+H"))
			{
				move = i * 3 + 1;
				
				return true;
			} 
			else if (getRowTotal(gameBoard, i).equals("+HH")) 
			{
				move = i * 3;
				
				return true;
			}

			// checking if there is a possible column combination that can be used to win
			// and doing all three column in a loop
			if (getColumnTotal(gameBoard, i).equals("HH+"))
			{
				move = i + 6;
			
				return true;
			} 
			
			else if (getColumnTotal(gameBoard, i).equals("H+H")) 
			{
				move = i + 3;
				
				return true;
			} 
			
			else if (getColumnTotal(gameBoard, i).equals("+HH")) 
			{
				move = i;
				
				return true;
			}

		}

		if (getFirstDiagnolTotal(gameBoard).equals("HH+"))
		{
			move = 8;
			return true;
		} 
		
		else if (getFirstDiagnolTotal(gameBoard).equals("H+H")) 
		{
			move = 4;
			return true;
		} 
		
		else if (getFirstDiagnolTotal(gameBoard).equals("+HH"))
		{
			move = 0;
			return true;
		}

		if (getSecondDiagnolTotal(gameBoard).equals("HH+"))
		{
			move = 6;
			return true;
		}
		
		else if (getSecondDiagnolTotal(gameBoard).equals("H+H")) 
		{
			move = 2;
			return true;
		}
		
		else if (getSecondDiagnolTotal(gameBoard).equals("+HH")) 
		{
			move = 2;
			return true;
		}

		return false;
	}


	public void  CompNextMove()
	{
		// is the computer winning?
		// make the move and stop
		if (compuTerWinCheck() == true)
		{
			compuTerWinCheck();
			return;
		}

		// is the human winning?
		// stop winning condition
		if (humanWinCheck() == true)
		{
			
			return;
		}


		//////////////////////////////////////////////////
		if (gameBoard[4] == '+')// if center is empty put C there. It makes it unbeatable.
		{
			
			move = 4;
			return;
		}

		else {

			// select any unused space and select it
			for (int index = 0; index < Board.SIZE; index++) 
			{
				if (gameBoard[index] == Board.EMPTY) 
				{
					
					move = index;
					return;
				}

			}
		}
	}


	///////////////////////////////////////////////////////////////

	//Getting a string of row elements
	public static String getRowTotal(char[] array, int r) {
		String total = "";

		int row = r * 3;
		// 0: 0 1 2
		// 1: 3 4 5
		// 2: 6 7 8
		total = "" + array[row] + array[row + 1] + array[row + 2];

		return total;
	}
	///////////////////////////////////////////////////////////////

	//Getting a string of column elements
	public static String getColumnTotal(char[] array, int col) {
		String total = "";

		total = "" + array[col] + array[col + 3] + array[col + 6];

		// System.out.println(" this is column matrix "+ total);
		return total;

	}

	//////////////////////////////////////////////////////

	//Getting the diagonal elements
	public static String getFirstDiagnolTotal(char[] array) {

		String total = "";

		total = "" + array[0] + array[4] + array[8];

		return total;
	}

	//////////////////////////////////////////////////////

	public static String getSecondDiagnolTotal(char[] array) {// getting the second diagonal elements
		String total = "";

		total = "" + array[2] + array[4] + array[6];

		return total;
	}

	////////////////////////////////////////////////////////////
}


