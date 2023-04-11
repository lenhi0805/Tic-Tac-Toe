package codeactivity.example.tttgame.lastPhase;


public class DriverMain {

	public static void main(String[] args) {
		
		// Create a game from TTTGame class where a board will be formed
		TTTGame game = new TTTGame();
		
		// We can have player versus computer, or player versus player, or computer versus computer
		// We can name the players and indicate who goes first, given that X always go first
		//game.setPlayers(new Actualplayer("Player1", Mark.X.getMark()), new AIplayer("Player2", Mark.O.getMark()));
		//game.setPlayers(new Actualplayer("Player1", Mark.X.getMark()), new Actualplayer("Player2", Mark.O.getMark()));
	    game.setPlayers(new AIplayer("Player1", Mark.X.getMark()), new AIplayer("Player2", Mark.O.getMark()));
		
		// Starting the game
		game.start();

	}
}
