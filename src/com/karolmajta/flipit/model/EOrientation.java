package com.karolmajta.flipit.model;

public enum EOrientation {
	NORTH,
	EAST,
	SOUTH,
	WEST;
	
	public static EOrientation getOpposite(EOrientation e) {
		switch(e) {
			case NORTH:
				return EOrientation.SOUTH;
			case EAST:
				return EOrientation.WEST;
			case SOUTH:
				return EOrientation.NORTH;
			case WEST:
				return EOrientation.EAST;
			default:
				return null;
		}
	}
	
	public static EOrientation getNext(EOrientation o) {
		switch(o) {
			case NORTH:
				return EOrientation.EAST;
			case EAST:
				return EOrientation.SOUTH;
			case SOUTH:
				return EOrientation.WEST;
			case WEST:
				return EOrientation.NORTH;
			default:
				return null;
		}
	}
}
