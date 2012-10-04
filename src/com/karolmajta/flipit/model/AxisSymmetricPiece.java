package com.karolmajta.flipit.model;

public abstract class AxisSymmetricPiece extends Piece {

	protected AxisSymmetricPiece(EPiece t, EOrientation o) {
		super(t, o);
	}

	@Override
	public boolean equals(Object other) {
		if(!(other instanceof Piece)) {
			return this == other;
		}
		Piece p = (Piece)other;
		
		boolean sameType;
		if(this.getEPiece() == p.getEPiece()) {
			sameType = true;
		} else {
			sameType = false;
		}
		if(!sameType) {
			return sameType;
		}
		
		EOrientation thisOri = getEOrientation();
		EOrientation otherOri = p.getEOrientation();
		
		switch(thisOri) {
			case NORTH:
				if(otherOri == EOrientation.NORTH ||
				   otherOri == EOrientation.SOUTH) {
					return true;
				} else {
					return false;
				}
			case EAST:
				if(otherOri == EOrientation.EAST ||
				   otherOri == EOrientation.WEST) {
					return true;
				} else {
					return false;
				}
			case SOUTH:
				if(otherOri == EOrientation.NORTH ||
				   otherOri == EOrientation.SOUTH) {
					return true;
				} else {
					return false;
				}
			case WEST:
				if(otherOri == EOrientation.EAST ||
				   otherOri == EOrientation.WEST) {
					return true;
				} else {
					return false;
				}
			default:
				return false;
		}
	}

}
