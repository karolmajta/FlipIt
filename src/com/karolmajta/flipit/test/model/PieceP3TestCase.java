package com.karolmajta.flipit.test.model;

import java.util.HashSet;
import java.util.Set;

import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.PieceP3;

import junit.framework.TestCase;

public class PieceP3TestCase extends TestCase {
	
	public void testGetRequiredNeighbors() {
		PieceP3 pNorth = new PieceP3(EOrientation.NORTH);
		PieceP3 pEast = new PieceP3(EOrientation.EAST);
		PieceP3 pSouth = new PieceP3(EOrientation.SOUTH);
		PieceP3 pWest = new PieceP3(EOrientation.WEST);
		
		Set<EOrientation> eNorth = new HashSet<EOrientation>();
		eNorth.add(EOrientation.NORTH);
		eNorth.add(EOrientation.EAST);
		eNorth.add(EOrientation.WEST);
		Set<EOrientation> eEast = new HashSet<EOrientation>();
		eEast.add(EOrientation.EAST);
		eEast.add(EOrientation.NORTH);
		eEast.add(EOrientation.SOUTH);
		Set<EOrientation> eSouth = new HashSet<EOrientation>();
		eSouth.add(EOrientation.SOUTH);
		eSouth.add(EOrientation.WEST);
		eSouth.add(EOrientation.EAST);
		Set<EOrientation> eWest = new HashSet<EOrientation>();
		eWest.add(EOrientation.WEST);
		eWest.add(EOrientation.SOUTH);
		eWest.add(EOrientation.NORTH);
		
		assertEquals(eNorth, pNorth.getRequiredNeighbors());
		assertEquals(eEast, pEast.getRequiredNeighbors());
		assertEquals(eSouth, pSouth.getRequiredNeighbors());
		assertEquals(eWest, pWest.getRequiredNeighbors());
	}

}
