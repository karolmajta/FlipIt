package com.karolmajta.flipit.model;

public abstract class AsymmetricPiece extends Piece {
	
	protected AsymmetricPiece(EPiece t, EOrientation o) {
		super(t, o);
	}
	
	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Piece)) {
			return this == other;
		}
		Piece p = (Piece)other;
		boolean sameType;
		if(this.getEPiece() == p.getEPiece()) {
			sameType = true;
		} else {
			sameType = false;
		}
		
		if(!sameType) {
			return sameType;
		} else {
			if(this.getEOrientation() == p.getEOrientation()) {
				return true;
			} else {
				return false;
			}
		}
	}
}
