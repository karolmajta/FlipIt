package com.karolmajta.flipit.model;

import java.util.HashSet;
import java.util.Set;

public class PieceP0 extends CenterSymmetricPiece {

	public PieceP0() {
		super(EPiece.P0, EOrientation.NORTH);
	}

	@Override
	public Piece copy() {
		return new PieceP0();
	}

	@Override
	public Piece copy(EOrientation o) {
		return copy();
	}

	@Override
	public Set<EOrientation> getRequiredNeighbors() {
		return new HashSet<EOrientation>();
	}
	
}
