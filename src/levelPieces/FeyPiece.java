//Authors: Lauren Loe and Aaron Aranda

package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.InteractionResult;
import java.util.Random;

public class FeyPiece extends GamePiece implements Moveable {
	private Random randomLocation = new Random();
	private int location;


	public FeyPiece(char symbol, String name, int location) {
		super(symbol, name, location);
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
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Moves randomly
		location = this.getLocation();
		while (gameBoard[location] != null || location == playerLocation) {
			location = randomLocation.nextInt(GameEngine.BOARD_SIZE);
		}  
		gameBoard[this.getLocation()] = null;
		this.setLocation(location);
		gameBoard[location] = this;
	}
	
	
}
