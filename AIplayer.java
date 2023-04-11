package codeactivity.example.tttgame.lastPhase;

public class AIplayer extends Player {
	
	// When a ComputerPlayer is instantiated, their name and mark are stored
	public AIplayer(String name, String mark) {
		super(name, mark);
	}
	
	
	
	// Method for computer player to choose the board they want to play
	@Override
	public int selectBoard() {
		System.out.println("Please select a valid board: ");
		
		 
		// Call random method to get a value for board
		int board = randomNumber(9);
		System.out.println("Select Board : " + board);
		
		return board;
	}


	// Method for actual player to choose the square of a board they want to play
	@Override
	public int selectSquare() {
		System.out.println("Please select a valid square on the selected board: ");
		
		// Call random method to get a value for square
		int square = randomNumber(9);
		System.out.println("Select Square : " + square);
		
		return square;
	}
	
	
	// Random method to return a random number within 0-8 range
	private int randomNumber(int range) {
		return (int) (Math.random() * 9);
	}
	
}
