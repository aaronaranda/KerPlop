package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class DoormatPiece extends GamePiece{

	public DoormatPiece(char symbol, String name, int location) {	
		super(symbol, name, location);		
	}
	
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		return null;
	}
	
	@Override
	public void draw() {
		System.out.println('w');
	}
	

}
