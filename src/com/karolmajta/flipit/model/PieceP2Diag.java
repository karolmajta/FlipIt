package com.karolmajta.flipit.model;

import java.util.HashSet;
import java.util.Set;

public class PieceP2Diag extends AsymmetricPiece {

	public PieceP2Diag(EOrientation o) {
		super(EPiece.P2_DIAG, o);
	}

	@Override
	public Piece copy() {
		return new PieceP2Diag(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP2Diag(o);
	}

	@Override
	public Set<EOrientation> getRequiredNeighbors() {
		Set<EOrientation> res = new HashSet<EOrientation>();
		switch(getEOrientation()) {
			case NORTH:
				res.add(EOrientation.NORTH);
				res.add(EOrientation.WEST);
				break;
			case EAST:
				res.add(EOrientation.EAST);
				res.add(EOrientation.NORTH);
				break;
			case SOUTH:
				res.add(EOrientation.SOUTH);
				res.add(EOrientation.EAST);
				break;
			case WEST:
				res.add(EOrientation.WEST);
				res.add(EOrientation.SOUTH);
				break;
		}
		return res;
	}

	
}
