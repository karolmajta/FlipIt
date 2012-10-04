package com.karolmajta.flipit.model;

import java.util.HashSet;
import java.util.Set;

public class PieceP3 extends AsymmetricPiece {

	public PieceP3(EOrientation o) {
		super(EPiece.P3, o);
	}

	@Override
	public Piece copy() {
		return new PieceP3(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP3(o);
	}
	
	@Override
	public Set<EOrientation> getRequiredNeighbors() {
		Set<EOrientation> res = new HashSet<EOrientation>();
		switch(getEOrientation()) {
			case NORTH:
				res.add(EOrientation.NORTH);
				res.add(EOrientation.WEST);
				res.add(EOrientation.EAST);
				break;
			case EAST:
				res.add(EOrientation.EAST);
				res.add(EOrientation.NORTH);
				res.add(EOrientation.SOUTH);
				break;
			case SOUTH:
				res.add(EOrientation.SOUTH);
				res.add(EOrientation.EAST);
				res.add(EOrientation.WEST);
				break;
			case WEST:
				res.add(EOrientation.WEST);
				res.add(EOrientation.SOUTH);
				res.add(EOrientation.NORTH);
				break;
		}
		return res;
	}

}
