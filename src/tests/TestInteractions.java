package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.*;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.PiratePiece;
import levelPieces.BlindZombiePiece;
import levelPieces.FeyPiece;
import levelPieces.TreasurePiece;
import levelPieces.WizardPiece;
import levelPieces.SkeletonPiece;


public class TestInteractions {
	
	@Test
	public void testTreasure(){
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		//treasure on 4, player on 5
		// none result
		TreasurePiece treasure = new TreasurePiece('T', "treasure", 4);
		gameBoard[4] = treasure;
		InteractionResult result = treasure.interact(gameBoard, 5);
		assert(result == InteractionResult.NONE);
		
		//treasure on 4, player on 4, get point result
		TreasurePiece treasure1 = new TreasurePiece('T', "treasure", 4);
		gameBoard[4] = treasure1;
		InteractionResult result1 = treasure1.interact(gameBoard, 5);
		assert(result1 == InteractionResult.GET_POINT);
	}
	
	@Test
	public void testWizard(){
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		//Wizard on 4, player on 5, none result
		WizardPiece wizard = new WizardPiece('W', "Wizard", 4);
		gameBoard[4] = wizard;
		InteractionResult result = wizard.interact(gameBoard, 5);
		assert(result == InteractionResult.NONE);
				
		//Wizard on 4, player on 4, kill result
		WizardPiece wizard1 = new WizardPiece('W', "Wizard", 4);
		gameBoard[4] = wizard1;
		InteractionResult result1 = wizard1.interact(gameBoard, 5);
		assert(result1 == InteractionResult.KILL);
	}
	
	@Test
	public void testPirate(){
		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		BlindZombiePiece zombie = new BlindZombiePiece('Z', "zombie", 7);
		gameBoard[7] = zombie;
		
		//pirate at 9, player at 14, hit result
		PiratePiece pirate = new PiratePiece('R', "pirate",9);
		gameBoard[9] = pirate;
		InteractionResult result = pirate.interact(gameBoard, 14);
		assert(result == InteractionResult.HIT);
		
		//pirate at 9, player at 7 none result
		PiratePiece pirate1 = new PiratePiece('R', "pirate",9);
		gameBoard[9] = pirate1;
		InteractionResult result1 = pirate1.interact(gameBoard, 7);
		assert(result1 == InteractionResult.NONE);
		
		//pirate at 9, player at 9, kill result
		PiratePiece pirate2 = new PiratePiece('R', "pirate",9);
		gameBoard[9] = pirate2;
		InteractionResult result2 = pirate2.interact(gameBoard, 9);
		assert(result2 == InteractionResult.KILL);
		
		//pirate at 9, player at 8, hit result
		PiratePiece pirate3 = new PiratePiece('R', "pirate",9);
		gameBoard[9] = pirate3;
		InteractionResult result3 = pirate3.interact(gameBoard, 8);
		assert(result3 == InteractionResult.HIT);

	}
	
	@Test
	public void testFey(){
		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		//Fey on 4, player on 5, non result
		FeyPiece fey = new FeyPiece('W', "fey", 4);
		gameBoard[4] = fey;
		InteractionResult result = fey.interact(gameBoard, 5);
		assert(result == InteractionResult.NONE);
						
		//Fey on 4, player on 4, advance result
		FeyPiece fey1 = new FeyPiece('W', "fey", 4);
		gameBoard[4] = fey1;
		InteractionResult result1 = fey1.interact(gameBoard, 4);
		assert(result1 == InteractionResult.ADVANCE);
		
	}
	
	@Test
	public void testSkeleton(){
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		//First test
		SkeletonPiece skeleton = new SkeletonPiece('S', "skeleton", 8);
		gameBoard[8] = skeleton;
		//Kill result, skeleton position = player position
		InteractionResult result = skeleton.interact(gameBoard, 8);
		assertEquals(result, InteractionResult.KILL);
		gameBoard[8] = null;
		
		//Second Test
		gameBoard[0] = skeleton;
		InteractionResult result2 = skeleton.interact(gameBoard, 0);
		assertEquals(result2, InteractionResult.KILL);
		gameBoard[0] = null;
		
		//Third Test
		gameBoard[1] = skeleton;
		//Testing for NONE interaction.
		InteractionResult result3 = skeleton.interact(gameBoard, 2);
		assertEquals(result3, InteractionResult.NONE);			
	}
	


}
