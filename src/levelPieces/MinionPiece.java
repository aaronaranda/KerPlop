package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class MinionPiece extends GamePiece {

	public MinionPiece(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void draw() {
		//syso whatever a minion looks like
		System.out.println('m');
	}

}
