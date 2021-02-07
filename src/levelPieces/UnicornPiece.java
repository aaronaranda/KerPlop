package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;
import gameEngine.InteractionResult;
import java.util.Random;

public class UnicornPiece extends GamePiece implements Moveable {
	private Random randomLocation = new Random();
	private int location = randomLocation.nextInt();


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
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Moves randomly
		while (gameBoard[location] != null) {
			location = randomLocation.nextInt(GameEngine.BOARD_SIZE);
		}  
		this.setLocation(location);
	}
	
	
}
