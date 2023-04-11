package codeactivity.example.tttgame.lastPhase;

import java.util.Scanner;

public class Actualplayer extends Player {
	
	Scanner input = new Scanner(System.in);
	
	
	
	// When a HumanPlayer is instantiated, their name and mark are stored
	public Actualplayer(String name, String mark) {
		super(name, mark);
	
	}

	
	// Method for actual player to choose the board they want to play
	@Override
	public int selectBoard() {
		int board;
		
		do { // Loop until the input value for board is valid, which is in 0-8 range
			System.out.println("Please select a valid board: ");
			board = input.nextInt();
			
		}while(board < 0 || board > 8);
		
		System.out.println("Selected Board : " + board);
		
		return board;
	}

	
	// Method for actual player to choose the square of a board they want to play
	@Override
	public int selectSquare() {
		int square;
		
		do { // Loop until the input value for square is valid, which is in 0-8 range
			System.out.println("Please select a valid square on the selected board: ");
			square = input.nextInt();
			
		}while(square < 0 || square > 8);
		
		System.out.println("Selected Square : " + square);
		
		return square;
	}

	
}
