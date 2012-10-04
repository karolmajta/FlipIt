package com.karolmajta.flipit.model;

import java.util.Set;

public interface IPiece {
	
	public EPiece getEPiece();
	public EOrientation getEOrientation();
	public Piece copy();
	public Piece copy(EOrientation o);
	public Set<EOrientation> getRequiredNeighbors();
}
