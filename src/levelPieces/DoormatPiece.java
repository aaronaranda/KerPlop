package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class DoormatPiece implements Drawable{
	public int location;

	public DoormatPiece(char symbol, String name, int location) {	
			this.location = location;
	}

	
	@Override
	public void draw() {
		System.out.println('w');
	}
	

}
