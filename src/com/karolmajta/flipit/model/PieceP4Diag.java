package com.karolmajta.flipit.model;

import java.util.HashSet;
import java.util.Set;

public class PieceP4Diag extends CenterSymmetricPiece {

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
