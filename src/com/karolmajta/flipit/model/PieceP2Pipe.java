package com.karolmajta.flipit.model;

import java.util.HashSet;
import java.util.Set;

public class PieceP2Pipe extends AxisSymmetricPiece {

	public PieceP2Pipe(EOrientation o) {
		super(EPiece.P2_PIPE, o);
	}

	@Override
	public Piece copy() {
		return new PieceP2Pipe(getEOrientation());
	}

	@Override
	public Piece copy(EOrientation o) {
		return new PieceP2Pipe(o);
	}

	@Override
	public Set<EOrientation> getRequiredNeighbors() {
		Set<EOrientation> res = new HashSet<EOrientation>();
		switch(getEOrientation()) {
			case NORTH:
				res.add(EOrientation.NORTH);
				res.add(EOrientation.SOUTH);
				break;
			case EAST:
				res.add(EOrientation.EAST);
				res.add(EOrientation.WEST);
				break;
			case SOUTH:
				res.add(EOrientation.SOUTH);
				res.add(EOrientation.NORTH);
				break;
			case WEST:
				res.add(EOrientation.WEST);
				res.add(EOrientation.EAST);
				break;
		}
		return res;
	}
	
}
