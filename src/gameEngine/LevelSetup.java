//Authors: Lauren Loe and Aaron Aranda

package gameEngine;

import java.util.ArrayList;

import levelPieces.SkeletonPiece;
import levelPieces.MagicDoorPiece;
import levelPieces.GamePiece;
import levelPieces.WizardPiece;
import levelPieces.BlindZombiePiece;
import levelPieces.TreasurePiece;
import levelPieces.PiratePiece;
import levelPieces.FeyPiece;

public class LevelSetup {
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStart;
	
	//creates level
	public void createLevel(int levelNum) {
		
		//clears arrays
		movingPieces = new ArrayList<Moveable>();
		interactingPieces = new ArrayList<GamePiece>();
		
		//builds level one
		if(levelNum ==1) {
			
			//prints out instructions
			System.out.println("You have entered the first level of the wizard's base in search of treasure. Beware the dangers that are ahead.");
			System.out.println("Level 1 Legend:");
			System.out.println("  P - Player (you)");
			System.out.println("  T - Treasure (Chests full of valuables, they are what you came here for)");
			System.out.println("  Z - Blind Zombie (He doesn't seem to be able to see anything, so he is not much of a threat)");
			System.out.println("  W - Wizard (The owner of this place, he will likely kill you if you get too close");
			System.out.println("  R - Pirate (A pirate in a wizard's base? Not sure why they are here, but this one has a flintlock, best to keep something in between them and you)");
			System.out.println("  F - Fey (A fey creature roaming the halls. Maybe they will be willing to make a deal in order to aid you?)");
			System.out.println("  d - Door (just a regular door)");
			
			//creates pieces
			BlindZombiePiece zombie = new BlindZombiePiece('Z', "minion", 2);
			WizardPiece wizard = new WizardPiece('W', "wizard", 1);
			MagicDoorPiece door1 = new MagicDoorPiece('d',"door1",6);
			MagicDoorPiece door2 = new MagicDoorPiece('d',"door1",18);
			PiratePiece pirate = new PiratePiece('R',"pirate",5);
			FeyPiece fey = new FeyPiece('F',"fey",19);
			TreasurePiece treasure1 = new TreasurePiece('T',"treasure1",3);
			TreasurePiece treasure2 = new TreasurePiece('T',"treasure1",20);
			
			//sets player start
			playerStart = 10;
			
			//adds moving pieces and interacting pieces to appropriate arrays
			movingPieces.add(pirate);
			movingPieces.add(fey);
			movingPieces.add(zombie);
			interactingPieces.add(treasure1);
			interactingPieces.add(treasure2);
			interactingPieces.add(wizard);
			interactingPieces.add(pirate);
			interactingPieces.add(fey);
			
			//creates board and adds pieces to it.
			board = new Drawable[gameEngine.GameEngine.BOARD_SIZE];
			board[1] = wizard;
			board[2] = zombie;
			board[3] = treasure1;
			board[6] = door1;
			board[5] = pirate;
			board[18] = door2;
			board[19] = fey;
			board[20] = treasure2;
			
		}
		
		//builds level 2
		else if (levelNum == 2) {
			
			//prints out instructions
			System.out.println("You have entered the second level of the wizard's base in search of treasure. The dangers have likely changed.");
			System.out.println("Level 2 Legend:");
			System.out.println("  P - Player (you)");
			System.out.println("  T - Treasure (Chests full of valuables, they are what you came here for)");
			System.out.println("  W - Wizard (The owner of this place, he will likely kill you if you get too close");
			System.out.println("  R - Pirate (A pirate in a wizard's base? Not sure why they are here, but this one has a flintlock, best to keep something in between them and you)");
			System.out.println("  S - Skeletion (A set of animated bones. They have swords, be careful)");
			
			//creates pieces
			WizardPiece wizard = new WizardPiece('W', "wizard", 1);
			PiratePiece pirate = new PiratePiece('R',"pirate",18);
			TreasurePiece treasure1 = new TreasurePiece('T',"treasure1",3);
			TreasurePiece treasure2 = new TreasurePiece('T',"treasure2",14);
			SkeletonPiece skeleton1 = new SkeletonPiece('S',"skeleton1",8);
			SkeletonPiece skeleton2 = new SkeletonPiece('S',"skeleton2",12);
			
			//sets player start
			playerStart = 10;
			
			//adds moving pieces and interacting pieces to appropriate arrays
			movingPieces.add(pirate);
			interactingPieces.add(treasure1);
			interactingPieces.add(treasure2);
			interactingPieces.add(wizard);
			interactingPieces.add(pirate);
			interactingPieces.add(skeleton1);
			interactingPieces.add(skeleton2);
			
			//creates board and adds pieces to it.
			board = new Drawable[gameEngine.GameEngine.BOARD_SIZE];
			board[3] = treasure1;
			board[14] = treasure2;
			board[8] = skeleton1;
			board[12] = skeleton2;
			board[1] = wizard;
			board[18] = pirate;
		} 

	}

	//returns board
	public Drawable[] getBoard() {
		return board;
	}

	//returns list of moving pieces
	public ArrayList<Moveable> getMovingPieces() {
		return movingPieces;
	}

	//returns list of interacting pieces
	public ArrayList<GamePiece> getInteractingPieces() {
		return interactingPieces;
	}

	//returns player start location
	public int getPlayerStartLoc() {
		return playerStart;
	}

}
