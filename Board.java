package codeactivity.example.tttgame.lastPhase;

public class Board implements Iboard{
	
	private Square[] boxes;
	private String winner;


	
	// When a board is instantiated, 9 squares will be created within it, 
	// with first square containing number 0, second square containing number 1, and so on,
	// 9th square containing number 8
	Board(){
		game();
	}
	private void game() {
		boxes = new Square[9];
		for(int i = 0; i < boxes.length; i++) {
			boxes[i] = new Square();
			boxes[i].setPlaceHolder(i);
		}
	}
	
	
	public void printFirstRow() { // Print the first 3 squares of a board
		for(int i = 0; i < 3; i++) {
			if(boxes[i].placeHolder == "X" || boxes[i].placeHolder == "O" || boxes[i].placeHolder == "-") {
				System.out.print(" " + boxes[i].getStringPlaceHolder() + " |");
			}else {
				System.out.print(" " + boxes[i].getPlaceHolder() + " |");
			}
		}	
	}
	
	public void printSecondRow() { // Print the next 3 squares of a board
		for(int i = 3; i < 6; i++) {
			if(boxes[i].placeHolder == "X" || boxes[i].placeHolder == "O" || boxes[i].placeHolder == "-") {
				System.out.print(" " + boxes[i].getStringPlaceHolder() + " |");
			}else {
				System.out.print(" " + boxes[i].getPlaceHolder() + " |");
			}
		}
	}
	
	public void printThirdRow() { // Print the last 3 squares of a box
		for(int i = 6; i < 9; i++) {
			if(boxes[i].placeHolder == "X" || boxes[i].placeHolder == "O" || boxes[i].placeHolder == "-") {
				System.out.print(" " + boxes[i].getStringPlaceHolder() + " |");
			}else {
				System.out.print(" " + boxes[i].getPlaceHolder() + " |");
			}
		}
	}
	

	
	// Method to return a mark from a input number square
	public String getMark (int square) {
		
		return boxes[square].getStringPlaceHolder();
	}

	
	// Method to return the winner of a board
	public String getBoardWinner() {
		if(checkRows() || checkCols() || checkLeftRightDiagonal() || checkRightLeftDiagonal()) {
			return winner;
		}else {
			return null;
		}
	}
	
	
	@Override
	public void print() {
		
	}
	public void possible_move(int whichBoard) {
		
	}
	public void choose_board() {
		
	}
	

	// Make move with given mark, board, and square within the board
	@Override
	public boolean makeMove(String mark, int board, int square) {
		
		return boxes[square].setPlaceHolder(mark);
	}
	
	
	
	@Override
	public boolean checkRows() {						// Win by having 3 of the same mark on the same row
		for(int square = 0; square < 9; square+=3) {
			if(checkRow(square)) {
				return true;
			}
		}
		
		return false;
	}
	private boolean checkRow(int square) {		        // Check to see if there are 3 of the same mark in a given row,
														// then store the winner of the board
		if(boxes[square].getStringPlaceHolder().equals(boxes[square+1].getStringPlaceHolder()) 
			&& boxes[square].getStringPlaceHolder().equals(boxes[square+2].getStringPlaceHolder())
			&& boxes[square].getStringPlaceHolder() != "-") {
			
			winner = boxes[square].getStringPlaceHolder();
			return true;
			
		}
				
		return false;
	}
	
	
	@Override
	public boolean checkCols() {						// Win by having 3 of the same mark on the same column
		for(int square = 0; square < 3; square++) {
			if(checkCol(square)) {
				return true;
			}
		}
		
		return false;
	}
	private boolean checkCol(int square) {				// Check to see if there are 3 of the same mark in a given column,
														// then store the winner of the board
		if(boxes[square].getStringPlaceHolder().equals(boxes[square+3].getStringPlaceHolder()) 
			&& boxes[square].getStringPlaceHolder().equals(boxes[square+6].getStringPlaceHolder())
			&& boxes[square].getStringPlaceHolder() != "-") {
			
			winner = boxes[square].getStringPlaceHolder();
			return true;
				
		}
		
		return false;
	}
	

	@Override
	public boolean checkRightLeftDiagonal() {			// Win by having 3 of the same mark diagonally starting from top right,
														// then store the winner of the board
		if(boxes[2].getStringPlaceHolder().equals(boxes[4].getStringPlaceHolder()) 
				&& boxes[2].getStringPlaceHolder().equals(boxes[6].getStringPlaceHolder())
				&& boxes[2].getStringPlaceHolder() != "-") {
			
			winner = boxes[2].getStringPlaceHolder();
			return true;
			
		}
		
		return false;
	}

	
	@Override
	public boolean checkLeftRightDiagonal() {			// Win by having 3 of the same mark diagonally starting from top left,
														// then store the winner of the board
		if(boxes[0].getStringPlaceHolder().equals(boxes[4].getStringPlaceHolder()) 
				&& boxes[0].getStringPlaceHolder().equals(boxes[8].getStringPlaceHolder())
				&& boxes[0].getStringPlaceHolder() != "-") {
			
			winner = boxes[0].getStringPlaceHolder();
			return true;
			
		}
		
		return false;
	}


	@Override
	public boolean isFull(int whichBoard) { 	// Check to see if a given board is full by checking if all boxes are not available
		for(int i = 0; i < boxes.length; i++) { 
			if (boxes[i].isAvailable()) {
				return false;
			}
		}
		
		return true;
	}
	

	@Override
	public boolean isTie() {
		return true;
	}

	
}
