//Authors: Lauren Loe and Aaron Aranda

package levelPieces;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import gameEngine.Moveable;
import java.util.Random;

public class PiratePiece extends GamePiece implements Moveable{
	private Random randomLocation = new Random();
	private int location;
	
	
	
	public PiratePiece(char symbol, String name, int location) {
		super(symbol, name, location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		
		boolean clearShot = false;
		//Check if player and Sniper moved to same spot
		if (this.getLocation() == playerLocation) {
			return InteractionResult.KILL;
		} 
		
		//If player is more rightward than pirate, search right
		//If pirate is more rightward than player, search left
				
		if (this.getLocation() > playerLocation) {
			for (int i = this.getLocation() - 1; i >= 0; i--) {
				if (gameBoard[i] != null && i != playerLocation) {
					clearShot = false;
					break;
				} else if (i == playerLocation && gameBoard[i] == null){
					clearShot = true;
					break;
				}
			}
		} else if (this.getLocation() < playerLocation) {
			for (int i = this.getLocation() + 1; i < gameEngine.GameEngine.BOARD_SIZE; i++) {
				if (gameBoard[i] != null && i != playerLocation) {
					clearShot = false;
					 break;
				} else if (i == playerLocation && gameBoard[i] == null){
					clearShot = true;
					break;
					
				}
			}
		}
		if (clearShot){
			return InteractionResult.HIT;
		}
		else {
			return InteractionResult.NONE;
		}
	}
	
	
	
	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		//Move Sniper
		location = this.getLocation();
		while (gameBoard[location] != null || location == playerLocation) {
			location = randomLocation.nextInt(GameEngine.BOARD_SIZE);
		}
		gameBoard[this.getLocation()] = null;	
		this.setLocation(location);
		gameBoard[location] = this;
		
		 
	}

}
