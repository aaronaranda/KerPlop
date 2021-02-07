package levelPieces;

import gameEngine.Drawable;

import gameEngine.InteractionResult;

public class TreasurePiece extends GamePiece {

	public TreasurePiece(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}
}
