package com.karolmajta.flipit.model;

import java.util.HashSet;
import java.util.Set;

public class PieceP1 extends AsymmetricPiece {

	public PieceP1(EOrientation o) {
		super(EPiece.P1, o);
	}

	@Override
	public Piece copy() {
		return new PieceP1(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP1(o);
	}

	@Override
	public Set<EOrientation> getRequiredNeighbors() {
		Set<EOrientation> res = new HashSet<EOrientation>();
		switch(getEOrientation()) {
			case NORTH:
				res.add(EOrientation.NORTH);
				break;
			case EAST:
				res.add(EOrientation.EAST);
				break;
			case SOUTH:
				res.add(EOrientation.SOUTH);
				break;
			case WEST:
				res.add(EOrientation.WEST);
				break;
		}
		return res;
	}
	
}
