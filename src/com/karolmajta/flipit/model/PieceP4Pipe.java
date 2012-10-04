package com.karolmajta.flipit.model;

import java.util.HashSet;
import java.util.Set;

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

	@Override
	public Set<EOrientation> getRequiredNeighbors() {
		Set<EOrientation> res = new HashSet<EOrientation>();
		res.add(EOrientation.NORTH);
		res.add(EOrientation.SOUTH);
		res.add(EOrientation.WEST);
		res.add(EOrientation.EAST);
		return res;
	}
	
}
