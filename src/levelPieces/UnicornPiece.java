package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class UnicornPiece extends GamePiece {

	public UnicornPiece(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//Check if piece is equal index to playerLocation, return ADVANCE, else NONE
		if (this.getLocation() == playerLocation) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}
	
	@Override
	public void draw() {
		System.out.println('U');
	}

}
