package com.karolmajta.flipit.model;

import java.util.Random;
import java.util.Set;

public class Board implements IBoard {
	private Piece [][] pieces;
	
	public Board(Piece [][] pcs) throws IllegalArgumentException {
		if(pcs.length < 1 || pcs[0].length < 1) {
			throw new IllegalArgumentException(
					"Pieces array has 0 rows or 0 cols.");
		}
		
		pieces = new Piece [pcs.length][pcs[0].length];
		for(int i=0; i<pcs.length; i++) {
			for(int j=0; j<pcs[0].length; j++) {
				pieces[i][j] = pcs[i][j].copy();
			}
		}
	}

	@Override
	public int[] getSize() {
		int rows = pieces.length;
		int cols = pieces[0].length;
		return new int [] {rows, cols};
	}

	@Override
	public Piece[][] getPieces() {
		Piece [][] piecesCopy = new Piece [pieces.length][pieces[0].length];
		for(int i=0; i<pieces.length; i++) {
			for(int j=0; j<pieces[0].length; j++) {
				piecesCopy[i][j] = pieces[i][j].copy();
			}
		}
		return piecesCopy;
	}

	@Override
	public Board flip(int r, int c) throws IllegalArgumentException {
		int [] size = getSize();
		if(size[0]-1 < r || size[1]-1 < c) {
			throw new IllegalArgumentException(
					"Cannot flip element (non-existent coordinate)");
		}
		Piece [][] pieces = getPieces();
		
		Piece oldPiece = pieces[r][c];
		Piece newPiece = oldPiece.copy(
				EOrientation.getNext(oldPiece.getEOrientation()));
		
		pieces[r][c] = newPiece;
		return new Board(pieces);
	}

	@Override
	public boolean isSolved() {
		boolean solved = true;
		for(int i=0; i<pieces.length; i++) {
			for(int j=0; j<pieces[0].length; j++) {
				Set<EOrientation> required = pieces[i][j].getRequiredNeighbors();
				for(EOrientation o : required) {
					Piece n;
					try {
						n = getNeighbor(i, j, o);
					} catch(ArrayIndexOutOfBoundsException e) {
						return false;
					}
					if(!n.getRequiredNeighbors().contains(EOrientation.getOpposite(o))) {
						return false;
					}
				}
			}
		}
		return solved;
	}

	@Override
	public Board shuffle(int times) {
		Random r = new Random();
		Board b = this;
		for(int i=0; i<times; i++) {
			int rowNum = r.nextInt(b.getSize()[0]);
			int colNum = r.nextInt(b.getSize()[1]);
			b = b.flip(rowNum, colNum);
		}
		if(b.isSolved()) {
			b = b.shuffle(times);
		}
		return b;
	}

	private Piece getNeighbor(int x, int y, EOrientation e) {
		int [] coords;
		switch(e) {
			case NORTH:
				coords = new int [] {x-1, y};
				break;
			case EAST:
				coords = new int [] {x, y+1};
				break;
			case SOUTH:
				coords = new int [] {x+1, y};
				break;
			case WEST:
				coords = new int [] {x, y-1};
				break;
			default:
				coords = null;
				break;
		}
		return pieces[coords[0]][coords[1]];
	}
	
}
