package com.karolmajta.flipit.test.model;

import java.util.HashSet;
import java.util.Set;

import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.PieceP1;

import junit.framework.TestCase;

public class PieceP1TestCase extends TestCase {

	public void testGetRequiredNeighbors() {
		PieceP1 pNorth = new PieceP1(EOrientation.NORTH);
		PieceP1 pEast = new PieceP1(EOrientation.EAST);
		PieceP1 pSouth = new PieceP1(EOrientation.SOUTH);
		PieceP1 pWest = new PieceP1(EOrientation.WEST);
		
		Set<EOrientation> eNorth = new HashSet<EOrientation>();
		eNorth.add(EOrientation.NORTH);
		Set<EOrientation> eEast = new HashSet<EOrientation>();
		eEast.add(EOrientation.EAST);
		Set<EOrientation> eSouth = new HashSet<EOrientation>();
		eSouth.add(EOrientation.SOUTH);
		Set<EOrientation> eWest = new HashSet<EOrientation>();
		eWest.add(EOrientation.WEST);
		
		assertEquals(eNorth, pNorth.getRequiredNeighbors());
		assertEquals(eEast, pEast.getRequiredNeighbors());
		assertEquals(eSouth, pSouth.getRequiredNeighbors());
		assertEquals(eWest, pWest.getRequiredNeighbors());
	}
	
}
