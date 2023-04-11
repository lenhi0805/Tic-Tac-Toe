package codeactivity.example.tttgame.lastPhase;

public abstract class Player {

	private String name;
	private String mark;
	
	public Player(String name, String mark) {
		this.setName(name);
		this.setMark(mark);
	}

	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	String getMark() {
		return mark;
	}
	void setMark(String mark) {
		this.mark = mark;
	}

	
	public abstract int selectBoard();
	
	public abstract int selectSquare();
	
}
