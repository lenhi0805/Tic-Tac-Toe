package codeactivity.example.tttgame.lastPhase;

public interface Iboard {
	
	void print();
	void possible_move(int whichBoard);
	void choose_board();
	boolean makeMove(String player, int board, int square);
	boolean checkRows();
	boolean checkCols();
	boolean checkLeftRightDiagonal();
	boolean checkRightLeftDiagonal();
	boolean isFull(int whichBoard);
	boolean isTie();
	
}
