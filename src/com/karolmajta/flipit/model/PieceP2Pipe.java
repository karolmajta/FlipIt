package com.karolmajta.flipit.model;

public class PieceP2Pipe extends AxisSymmetricPiece {

	public PieceP2Pipe(EOrientation o) {
		super(EPiece.P2_PIPE, o);
	}

	@Override
	public Piece copy() {
		return new PieceP2Pipe(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP2Pipe(o);
	}
	
}
