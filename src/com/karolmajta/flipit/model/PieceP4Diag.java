package com.karolmajta.flipit.model;

public class PieceP4Diag extends AxisSymmetricPiece {

	public PieceP4Diag(EOrientation o) {
		super(EPiece.P4_DIAG, o);
	}

	@Override
	public Piece copy() {
		return new PieceP4Diag(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP4Diag(o);
	}

}
