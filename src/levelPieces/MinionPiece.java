package levelPieces;

import gameEngine.Moveable;
import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;

public class MinionPiece extends GamePiece implements Moveable{
	private boolean hitEnd = false;

	public MinionPiece(char symbol, String name, int location) {
		super(symbol, name, location);
		
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		return InteractionResult.NONE;		
	}
	
	@Override
	public void draw() {
		System.out.println('m');
	}
	
	@Override 
	public void move(Drawable[] gameBoard, int playerLocation) {
		if (!hitEnd) {
			int i = this.getLocation();
			while (gameBoard[i] != null && i < GameEngine.BOARD_SIZE) {
				i++;
				if (gameBoard[i] == null) {
					this.setLocation(i);
				}
			}
			
		}
				
		
		if ((this.getLocation() == playerLocation) && (gameBoard[this.getLocation() + 1] == null)) {
			this.setLocation(playerLocation + i);
		} else if (gameBoard[this.getLocation() + i] == null) {
			this.setLocation(this.getLocation() + 1);
		} else if (gameBoard[this.getLocation() + 1] != null) {
			int i = 0;
			while (gameBoard[i] != null) {
				i++;
			}
			this.setLocation(this.getLocation() + i);
		}		
	}
}
