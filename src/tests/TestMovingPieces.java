//Authors: Aaron Aranda and Lauren Loe
package tests;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.platform.commons.*;
import org.junit.platform.engine.*;
import org.junit.runner.*;
import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.PiratePiece;
import levelPieces.BlindZombiePiece;

public class TestMovingPieces {
	
	
	@Test
	public void testPirate() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		PiratePiece pirate = new PiratePiece('R', "pirate", 5);
		gameBoard[5] = pirate;
		int count2 = 0;
		int count4 = 0;
		int count7 = 0;
		int count9 = 0;
		int count10 = 0;
		int count14 = 0;
		int count15 = 0;
		int count16 = 0;
		int count21 = 0;
		//Holds a list of all the taken positions by other game pieces.
		ArrayList<Integer> takenPositions = new ArrayList<Integer>() {
			{
				add(1);
				add(3);
				add(5);
				add(6);
				add(8);
				add(18);
				add(20);
			}
		};
		//Test random positions of the pirate 200 times
		for (int i = 0; i < 200; i++) {
			pirate.move(gameBoard, 8);
			//Taken positions: 3, 20, 1, 6, 18, playerPosition(8), 5 (starting position)
			int pos = pirate.getLocation();
			if (takenPositions.contains(pos)) {
				fail("Invalid Position");
			}
			//Count the times the pirate lands on certain spots
			if (pos == 2) count2++;
			if (pos == 4) count4++;
			if (pos == 7) count7++;
			if (pos == 9) count9++;
			if (pos == 10) count10++;
			if (pos == 14) count14++;
			if (pos == 15) count15++;
			if (pos == 16) count16++;
			if (pos == 21) count21++;					
		}
		//Check to see if all positions were visited to show some randomness.
		assert(count2 > 1);
		assert(count4 > 1);
		assert(count7 > 1);
		assert(count9 > 1);
		assert(count10 > 1);
		assert(count14 > 1);
		assert(count15 > 1);
		assert(count16 > 1);
		assert(count21 > 1);		
	}
	
	
	@Test 
	public void testBlindZombie() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		
		//zombie at 3, player at 7
		BlindZombiePiece zombie = new BlindZombiePiece('Z',"zombie", 3);
		gameBoard[3] = zombie;
		zombie.move(gameBoard, 7);
		assert(zombie.getLocation() == 4);
		
		//zombie at 20, player at 7
		BlindZombiePiece zombie2 = new BlindZombiePiece('Z',"zombie", 20);
		gameBoard[20] = zombie;
		zombie2.move(gameBoard, 7);
		assert(zombie.getLocation() == 19);
		
		//zombie at 6, player at 7
		BlindZombiePiece zombie3 = new BlindZombiePiece('Z',"zombie", 6);
		gameBoard[6] = zombie;
		zombie3.move(gameBoard, 7);
		assert(zombie.getLocation() == 8);
		
		//zombie at 0, player at 7
		BlindZombiePiece zombie4 = new BlindZombiePiece('Z',"zombie", 0);
		gameBoard[0] = zombie;
		zombie4.move(gameBoard, 7);
		assert(zombie.getLocation() == 1);
		
	}
	
	
	

}
