package com.karolmajta.flipit.model;

public class PieceP2Diag extends AsymmetricPiece {

	public PieceP2Diag(EOrientation o) {
		super(EPiece.P2_DIAG, o);
	}

	@Override
	public Piece copy() {
		return new PieceP2Diag(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP2Diag(o);
	}

}
