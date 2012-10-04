package com.karolmajta.flipit.model;

public class PieceP4Pipe extends CenterSymmetricPiece {

	public PieceP4Pipe() {
		super(EPiece.P4_PIPE, EOrientation.NORTH);
	}

	@Override
	public Piece copy() {
		return new PieceP4Pipe();
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP4Pipe();
	}

}
