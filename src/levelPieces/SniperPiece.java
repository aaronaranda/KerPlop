package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SniperPiece extends GamePiece {

	public SniperPiece(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResul
		}
		return null;
	}
	
	@Override
	public void draw() {
		System.out.println('S');
	}

}
