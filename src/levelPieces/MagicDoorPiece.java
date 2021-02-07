package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class MagicDoorPiece implements Drawable {
	public int location;
	private char symbol;
	private String name;
	
	public MagicDoorPiece(char symbol, String name, int location) {	
			this.symbol = symbol;
			this.name = name;
			this.location = location;
	}
	
	@Override
	public void draw() {
		System.out.print(this.symbol);	
	}
	
	
}