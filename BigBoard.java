package codeactivity.example.tttgame.lastPhase;

public class BigBoard implements Iboard {

	private Board[] boards; 
	private String[] winner = new String[9]; // Stores the winning mark of each board within the Big Board
	
	
	
	// When a BigBoard in instantiated, Boards are instantiated within the BigBoard, the contents of Big Board is printed
	BigBoard(){
		System.out.println("===== WELCOME TO THE ULTIMATE TIC-TAC-TOE GAME!! =====");
		
		game(); // Boards within the BigBoard are instantiated
	}
	
	private void game() { // 9 Boards are instantiated
		boards = new Board[9]; 
		for(int i = 0; i < boards.length; i++) {
			boards[i] = new Board();
		}
		
		print(); // Print the Big Board
	}
	
	@Override
	public void print() { // Before printing, the method checks to see if any of the Boards has a winner,
						// any square within the winning board that has not been played will be changed to "-" character.
						// The method will print in order with 3 boards at a time and row by row of each board
						// Then, if any, the board and its winner are printed
		
		for(int board = 0; board < 9; board++) {
			if(boards[board].getBoardWinner() != null) {
				for(int square = 0; square < 9; square++) {
					if(boards[board].getMark(square) != "X" && boards[board].getMark(square) != "O") {
						boards[board].makeMove("-", board, square);
					}
				}
			}
		}
		
			
		
		
		for(int board = 0; board < boards.length; board+=3) { // Start with first 3 boards, then next 3, then last 3
			
			for(int row = 0; row < 3; row++) { 				// Start with first, then second, then third row
				System.out.print("     ");
				for(int k = 0; k < 3; k++) { 				// Start with first, then second, then third board of the 3 chosen boards
					System.out.print("   BOARD#" + (board + k) + " |");
					
					if(row == 0) {							
						boards[board + k].printFirstRow();
					} else if(row == 1) {
						boards[board + k].printSecondRow();
					} else {
						boards[board + k].printThirdRow();
					}
				
				}
				System.out.println();
				
			}
		}
		
		for(int board = 0; board < 9; board++) {
			if(boards[board].getBoardWinner() != null) { // Check to see if a board already has a winner, print that stored winner
				
				//if(winner[board] == null) {				 // Check to see if a board has its first winner, store the winner then print it
					winner[board] = boards[board].getBoardWinner();
				//}
				
				System.out.println("The Board#" + board + " winner is " + winner[board]);
			}
		}
		
		System.out.println();
	}
	
	
	
	@Override
	public boolean makeMove(String mark, int board, int square) {
		
		return boards[board].makeMove(mark, board, square);
		
	}
	
	
	@Override
	public boolean checkRows() {					// Win by having 3 of the same mark on the same row
		for(int board = 0; board < 9; board+=3) {
			if(checkRow(board)) {
				return true;
			}
		}
		return false;
	}
	private boolean checkRow(int board) {			// Check to see if there are 3 of the same mark in a given row
		if(winner[board] == winner[board+1] && winner[board] == winner[board+2] && winner[board] != null) {
			return true;
		}

		return false;
	}
	
	@Override
	public boolean checkCols() {					// Win by having 3 of the same mark on the same column
		for(int board = 0; board < 3; board++) {
			if(checkCol(board)) {
				return true;
			}
		}
		
		return false;
	}
	private boolean checkCol(int board) {			// Check to see if there are 3 of the same mark in a given column
		if(winner[board] == winner[board+3] && winner[board] == winner[board+6] && winner[board] != null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean checkRightLeftDiagonal() {		// Win by having 3 of the same mark diagonally starting from top right
		if(winner[2] == winner[4] && winner[2] == winner[6] && winner[2] != null) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public boolean checkLeftRightDiagonal() {		// Win by having 3 of the same mark diagonally starting from top left
		if(winner[0] == winner[4] && winner[0] == winner[8] && winner[0] != null) {
			return true;
		}
		
		return false;
	}
	
	

	@Override
	public boolean isTie() { // Check all the boards to see if any of them is not full and does not have a winner, 
							// then such board can still be played on and thus the game is not tied yet 
		for(int i = 0; i < boards.length; i++) {
			if(winner[i] == null && !boards[i].isFull(i)) {
				return false;
			}
		}
		return true;
	}
	
	public void possible_move(int whichBoard) { // list legal board 
		for (int square = 0 ; square < 9; square ++) {
			if(boards[whichBoard].getMark(square) != "X" && boards[whichBoard].getMark(square) != "O" && boards[whichBoard].getMark(square) != "-") {
				System.out.print(boards[whichBoard].getMark(square) + " ");
			}
			
		}
		System.out.println();
	}
	
	public void choose_board() {
	
		for(int board = 0; board < 9; board++) {
			if(!boards[board].isFull(0)){
				
		}
			System.out.print(board + " "); // list legal square 

		}
		System.out.println();
		
	}
	@Override
	public boolean isFull(int whichBoard) { // Check to see if a board within the Big Board is full
		if(boards[whichBoard].isFull(0)) {
			return true;
		}else {
			return false;
		}
	}
	
	
}
