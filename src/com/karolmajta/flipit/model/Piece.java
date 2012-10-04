package com.karolmajta.flipit.model;

public abstract class Piece
	implements IPiece {

	private final EPiece underlyingType;
	private final EOrientation orientation;
	
	@Override
	public abstract boolean equals(Object other);
	
	protected Piece(EPiece t, EOrientation o) {
		underlyingType = t;
		orientation = o;
	}

	@Override
	public int hashCode() {
		return underlyingType.ordinal()*10 + orientation.ordinal();
	}
	
	@Override
	public EPiece getEPiece() {
		return underlyingType;
	}
	
	@Override
	public EOrientation getEOrientation() {
		return orientation;
	}
	
}
