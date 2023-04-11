package codeactivity.example.tttgame.lastPhase;

class Square {
	
	public String placeHolder; // Stores the output of a square
		
	
	
	int getPlaceHolder() {						// return placeHolder when it's a number
		return Integer.parseInt(placeHolder);
	}
	
	boolean setPlaceHolder(int placeHolder) {	// converts an integer and stores it as a string
		this.placeHolder = Integer.toString(placeHolder);
		return true;
	}
	
	
	String getStringPlaceHolder() {				// return placeHolder when it's a mark
		return placeHolder;
	}
	
	
	boolean setPlaceHolder(String placeHolder) { // stores the input string if placeHolder is not already a valid mark
		if(this.placeHolder == "X" || this.placeHolder == "O") {
			return false;
		}else {
			this.placeHolder = placeHolder;
			return true;
		}

	}
	
	
	boolean isAvailable() {			// A square is available when it's not been played by either mark, X or O
		if(this.placeHolder == "X" || this.placeHolder == "O" || this.placeHolder == "-") {
			return false;
		}else {
			return true;
		}
	}
	
}
