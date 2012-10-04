package com.karolmajta.flipit.model;

public class PieceP0 extends CenterSymmetricPiece {

	public PieceP0() {
		super(EPiece.P0, EOrientation.NORTH);
	}

	@Override
	public Piece copy() {
		return new PieceP0();
	}

	@Override
	public Piece copy(EOrientation o) {
		return copy();
	}
	
}
