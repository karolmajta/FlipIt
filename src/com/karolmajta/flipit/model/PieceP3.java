package com.karolmajta.flipit.model;

public class PieceP3 extends AsymmetricPiece {

	public PieceP3(EOrientation o) {
		super(EPiece.P3, o);
	}

	@Override
	public Piece copy() {
		return new PieceP3(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP3(o);
	}

}
