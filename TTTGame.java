package codeactivity.example.tttgame.lastPhase;

public class TTTGame {
	
	private Player[] players = new Player[2]; // Players can either be actual player or computer player
	private Iboard board; // The board can be of any characteristics like size and how to win, 
							// as long as it implements IBoard interface
	private int currplayer = -1;	//The player index
	
	
	
	// A board is automatically set when TTTGame class is instantiated, which has the fields and methods from BigBoard class
	public TTTGame() {
		setBoard();
	}
	private void setBoard() {
		this.board = new BigBoard();
	}
	
	
	// Method for users to choose whether they want to player against other player or against computer 
	public void setPlayers(Player player1, Player player2) {
		players[0] = player1; // The first player, who has X mark
		players[1] = player2; // The second player, who has O mark
	}
	
	
	
	// Method to carry out the game until someone wins or tie
	public void start() {
		
		// On the very first move, a player, who has X mark, gets to choose which board, 
		// within the big board of the game, they want to start the game on 
		switchPlayer(); 
		System.out.println("Current Player is : " + players[this.currplayer].getMark());
		System.out.println("Possible board move: ");
		
		// Take user's inputs for the board, and the square within said board, they want to make a move on
		// by calling methods from the player's class
		board.choose_board();
		int whichBoard = players[this.currplayer].selectBoard();
		System.out.println("Possible square move: ");
		board.possible_move(whichBoard);
		int whichSquare = players[this.currplayer].selectSquare();
		
		// Make the move with the mark of the first player, the indicated board and square within 
		// using a method from bigBoard class. Then print the board after the first move 
		board.makeMove(players[this.currplayer].getMark(), whichBoard, whichSquare);
		board.print();
		
		
		do { // After the first move, each player will take turn,
			// the board to be played on is determined by the chosen square from the previous move,
			// players can only choose which square within that board the make their moves.
			// This process is repeated until the game is over
			
			switchPlayer();
			System.out.println("Current Player is : " + players[this.currplayer].getMark());
			whichBoard = whichSquare;
			System.out.println("Selected Board : " + whichBoard);
			System.out.println("Possible square move: ");
			board.possible_move(whichBoard);
			whichSquare = players[this.currplayer].selectSquare();
			
			// If statement to check whether the move is legal, meaning the board chosen is not full 
			// and the square chosen is not already played
			if(board.makeMove(players[this.currplayer].getMark(), whichBoard, whichSquare)) {
				board.print();					// Make the move and print the board if the move is legal
			}else { // Attempt to make the illegal move
				
				if(board.isFull(whichBoard)) { 	// When the chosen board is full, current player gets to choose
												// both the board and the square within to make their move
					board.print();
					System.out.println("Current Player is : " + players[this.currplayer].getMark());
					System.out.println("Possible board move: ");
					board.choose_board();
				
					whichBoard = players[this.currplayer].selectBoard();
					System.out.println("Possible square move: ");
					board.possible_move(whichBoard);
					whichSquare = players[this.currplayer].selectSquare();
					
					
					board.print();
				
				}else {							 // When the chosen square is already played
					do { // The player still has to play on predetermined board,
						// but choose a different square to play on that board
						// Repeat until the current player makes a legal move
						System.out.println("Please try again!");
						
						board.print();
						System.out.println("Current Player is : " + players[this.currplayer].getMark());
						System.out.println("Select Board : " + whichBoard);
						System.out.println("Possible square move: ");
						board.possible_move(whichBoard);
				        
						whichSquare = players[this.currplayer].selectSquare();	
						
					}while(!board.makeMove(players[this.currplayer].getMark(), whichBoard, whichSquare));
				
					board.print();
				}
				
			}
				
		} while(!gameOver());
		
	}
	
	
	
	// Method to switch player after each turn
	private void switchPlayer() {
		if(this.currplayer == -1 || this.currplayer == 1) { // Switch to player with X mark
			this.currplayer = 0;
		}else {																// Switch to player with O mark
			this.currplayer = 1;
		}
	}
	
	
	// Method to indicate when the game is over, which is either due to someone's won or it's a tie game
	private boolean gameOver() {
		if(isWinner()) { 							// The case where someone's won
			// The player who just made a move right before a winner is detected is the winner
			System.out.println("The game winner is : " + players[this.currplayer].getMark());
			return true;
		}else if(board.isTie()) { 					// The case where board runs out of possible move, leading to a tie
			System.out.println("game is tie");
			return true;
		}
		
		return false;
	}
	private boolean isWinner() { // Method to find out who the winner is
		if(board.checkRows()) { 					// Win by having 3 of the same mark on the same row
			return true;
		}else if(board.checkCols()) { 				// Win by having 3 of the same mark on the same column
			return true;
		}else if(board.checkLeftRightDiagonal()) { // Win by having 3 of the same mark diagonally starting from top left 
			return true;
		}else if(board.checkRightLeftDiagonal()) { // Win by having 3 of the same mark diagonally starting from top right
			return true;
		}else { 									// None of the above case, so an indication that there is no winner is returned
			return false;
		}
	}

	
}
