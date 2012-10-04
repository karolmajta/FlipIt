package com.karolmajta.flipit.model;

public class PieceP1 extends AsymmetricPiece {

	public PieceP1(EOrientation o) {
		super(EPiece.P1, o);
	}

	@Override
	public Piece copy() {
		return new PieceP1(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP1(o);
	}
	
}
