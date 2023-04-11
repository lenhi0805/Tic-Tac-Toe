# Tic-Tac-Toe
Design
 * An ultimate tictactoe game can either be actual player or computer player, at least 2 players, and play in a Big board which include 9 smaller board inside it
 * A big board will have a has-a relationship with a board, granting a big board access to methods from Board class
 * A board will then be made up of 9 boxes, resembling a normal tictactoe game. 
 * A board will have a has-a relationship with a box, granting a box  access to methods from Box class
 * A box can store the mark that a player wishes to play ( X or O )
 * Before they choose their move, it will print out all the legal moves for board and square. 
 * The first player will be ask to choose a board and a square within that board to put their mark in,
 * or computer player will get a random number between 0-8 for both the board and the square within that board to put their mark in
 * But after the first time, the human player or computer player have to play the board which is number of the box that previous player play
 * If that board is tie, full or already has winner, the player can choose the board by their own
 * The board has a winner will be locked, which means other empty boxes in that board will be filled by "-"
 * The game will be played until someone has won or each of the 9 boards either is full or has a winner
 */
