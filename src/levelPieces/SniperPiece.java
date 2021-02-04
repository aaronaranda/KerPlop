package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

public class SniperPiece extends GamePiece implements Moveable{
	private Random randomLocation = new Random();
	private int location = randomLocation.nextInt(GameEngine.BOARD_SIZE);
	
	
	
	public SniperPiece(char symbol, String name, int location) {
		super(symbol, name, location);
		// TODO Auto-generated constructor stub
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		//Check if player and Sniper moved to same spot
		if (this.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		}
		
		boolean clearShot = false;
		//If player is more rightward than sniper, distance > 0
		//If sniper is more rightward than player, distance < 0
		int distance = -(this.getLocation() - playerLocation);
		int i = distance / Math.abs(distance);
		while (distance != 0) {
			clearShot = gameBoard[distance + i] != null;
		}
		if (clearShot) {
			return InteractionResult.KILL;
		} else {
			return InteractionResult.NONE;
		}
	}
	
	
	@Override
	public void draw() {
		System.out.println('S');
	}
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Move Sniper
		while (gameBoard[location] != null) {
			location = randomLocation.nextInt(GameEngine.BOARD_SIZE);
		}
		this.setLocation(location);
	}

}
