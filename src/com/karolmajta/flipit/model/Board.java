package com.karolmajta.flipit.model;

public class Board implements IBoard {
	private Piece [][] pieces;
	private final Piece [][] solution;
	
	public Board(Piece [][] pcs, Piece [][] sol) throws IllegalArgumentException {
		if(pcs.length < 1 || sol.length < 1 || pcs[0].length < 1
				|| sol[0].length < 1) {
			throw new IllegalArgumentException(
					"Pieces array has 0 rows or 0 cols.");
		}
		if(pcs.length != sol.length || pcs[0].length != sol[0].length) {
			throw new IllegalArgumentException(
					"Dimensions of pieces and solution don't match.");
		}
		pieces = new Piece [pcs.length][pcs[0].length];
		for(int i=0; i<pcs.length; i++) {
			for(int j=0; j<pcs[0].length; j++) {
				pieces[i][j] = pcs[i][j].copy();
			}
		}
		solution = new Piece [sol.length][sol[0].length];
		for(int i=0; i<sol.length; i++) {
			for(int j=0; j<sol[0].length; j++) {
				solution[i][j] = sol[i][j].copy();
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
		// we can share solutions among instances cause we don't
		// suppose it will be modified in any way.
		Piece [][] solution = this.solution;
		
		Piece oldPiece = pieces[r][c];
		Piece newPiece = oldPiece.copy(
				getNextEOrientation(oldPiece.getEOrientation()));
		
		pieces[r][c] = newPiece;
		return new Board(pieces, solution);
	}
	
	private EOrientation getNextEOrientation(EOrientation o) {
		switch(o) {
			case NORTH:
				return EOrientation.EAST;
			case EAST:
				return EOrientation.SOUTH;
			case SOUTH:
				return EOrientation.WEST;
			case WEST:
				return EOrientation.NORTH;
			default:
				return null;
		}
	}

	@Override
	public boolean isSolved() {
		boolean solved = true;
		for(int i=0; i<pieces.length; i++) {
			for(int j=0; j<pieces[0].length; j++) {
				solved = solved && pieces[i][j].equals(solution[i][j]);
			}
		}
		return solved;
	}
}
