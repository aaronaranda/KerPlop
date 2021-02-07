package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SkeletonPiece extends GamePiece implements Drawable {

	public SkeletonPiece(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (this.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
	
	//Non-moving piece
	
}
