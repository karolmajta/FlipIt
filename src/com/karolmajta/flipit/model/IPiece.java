package com.karolmajta.flipit.model;

public interface IPiece {
	
	public EPiece getEPiece();
	public EOrientation getEOrientation();
	public Piece copy();
	public Piece copy(EOrientation o);

}
