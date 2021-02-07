package levelPieces;

import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class BlindZombiePiece extends GamePiece implements Moveable{
	private boolean moveLeft = false;

	public BlindZombiePiece(char symbol, String name, int location) {
		super(symbol, name, location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;		
	}
	
	
	
	@Override 
	public void move(Drawable[] gameBoard, int playerLocation) {		
		if (!moveLeft) {
			for (int i = this.getLocation(); i < GameEngine.BOARD_SIZE; i++) {
				if (i != playerLocation && gameBoard[i] == null) {
					gameBoard[this.getLocation()] = null;
					this.setLocation(i);
					gameBoard[i] = this;
					break;
				} else if (i + 1 == GameEngine.BOARD_SIZE) {
					moveLeft = true;
					break;
				}
			}
		} else if (moveLeft) {
			for (int i = this.getLocation(); i > GameEngine.BOARD_SIZE; i--) {
				if (i != playerLocation && gameBoard[i] == null) {
					gameBoard[this.getLocation()] = null;
					this.setLocation(i);
					gameBoard[i] = this;
					break;
				} else if (i == 0) {
					moveLeft = false;
					break;
				}
			}
		}
	}
}
	
		
		
		
		
		
		
		
		
		
		
		