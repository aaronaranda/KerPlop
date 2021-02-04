package gameEngine;

import java.util.ArrayList;

import levelPieces.BumbleBeePiece;
import levelPieces.DoormatPiece;
import levelPieces.GamePiece;
import levelPieces.KangaloPiece;
import levelPieces.MinionPiece;
import levelPieces.PrizePiece;
import levelPieces.SniperPiece;
import levelPieces.UnicornPiece;

public class LevelSetup {
	private Drawable[] board;
	private ArrayList<Moveable> movingPieces;
	private ArrayList<GamePiece> interactingPieces;
	private int playerStart;
		
	public void createLevel(int levelNum) {
		if(levelNum ==1) {
			MinionPiece minion = new MinionPiece('m', "minion", 7);
			KangaloPiece kangalo = new KangaloPiece('k', "kangalo", 1);
			DoormatPiece doormat1 = new DoormatPiece('w',"doormat1",4);
			DoormatPiece doormat2 = new DoormatPiece('w',"doormat1",18);
			SniperPiece sniper = new SniperPiece('S',"sniper",5);
			UnicornPiece unicorn = new UnicornPiece('U',"unicorn",19);
			PrizePiece prize1 = new PrizePiece('X',"prize1",3);
			PrizePiece prize2 = new PrizePiece('X',"prize1",13);
			playerStart = 10;
			movingPieces.add(sniper);
			movingPieces.add(unicorn);
			movingPieces.add(minion);
			interactingPieces.add(prize1);
			interactingPieces.add(prize2);
			interactingPieces.add(kangalo);
			interactingPieces.add(sniper);
			interactingPieces.add(unicorn);
			board = new Drawable[8];
			board[0] = kangalo;
			board[1] = prize1;
			board[2] = doormat1;
			board[3] = sniper;
			board[4] = minion;
			board[5] = prize2;
			board[6] = doormat2;
			board[7] = unicorn;
		}
		else if (levelNum == 2) {
			KangaloPiece kangalo = new KangaloPiece('k', "kangalo", 1);
			SniperPiece sniper = new SniperPiece('S',"sniper",18);
			PrizePiece prize1 = new PrizePiece('X',"prize1",5);
			PrizePiece prize2 = new PrizePiece('X',"prize1",8);
			BumbleBeePiece bumble1 = new BumbleBeePiece('B',"bumble1",9);
			BumbleBeePiece bumble2 = new BumbleBeePiece('B',"bumble2",11);
			playerStart = 10;
			movingPieces.add(sniper);
			interactingPieces.add(prize1);
			interactingPieces.add(prize2);
			interactingPieces.add(kangalo);
			interactingPieces.add(sniper);
			interactingPieces.add(bumble1);
			interactingPieces.add(bumble2);
			board = new Drawable[6];
			board[0] = prize1;
			board[1] = prize2;
			board[2] = bumble1;
			board[3] = bumble2;
			board[4] = kangalo;
			board[5] = sniper;
		} 

	}

	public Drawable[] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// TODO Auto-generated method stub
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return playerStart;
	}

}
