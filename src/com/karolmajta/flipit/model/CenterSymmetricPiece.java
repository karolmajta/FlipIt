package com.karolmajta.flipit.model;

public abstract class CenterSymmetricPiece extends Piece {

	protected CenterSymmetricPiece(EPiece t, EOrientation o) {
		super(t, o);
	}

	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Piece)) {
			return this == other;
		}
		Piece p = (Piece)other;
		
		if(getEPiece() == p.getEPiece()) {
			return true;
		} else {
			return false;
		}
	}
	
}
