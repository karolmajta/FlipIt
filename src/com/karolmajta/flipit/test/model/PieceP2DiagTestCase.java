package com.karolmajta.flipit.test.model;

import java.util.HashSet;
import java.util.Set;

import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.PieceP2Diag;

import junit.framework.TestCase;

public class PieceP2DiagTestCase extends TestCase {

	public void testGetRequiredNeighbors() {
		PieceP2Diag pNorth = new PieceP2Diag(EOrientation.NORTH);
		PieceP2Diag pEast = new PieceP2Diag(EOrientation.EAST);
		PieceP2Diag pSouth = new PieceP2Diag(EOrientation.SOUTH);
		PieceP2Diag pWest = new PieceP2Diag(EOrientation.WEST);
		
		Set<EOrientation> eNorth = new HashSet<EOrientation>();
		eNorth.add(EOrientation.NORTH);
		eNorth.add(EOrientation.WEST);
		Set<EOrientation> eEast = new HashSet<EOrientation>();
		eEast.add(EOrientation.EAST);
		eEast.add(EOrientation.NORTH);
		Set<EOrientation> eSouth = new HashSet<EOrientation>();
		eSouth.add(EOrientation.SOUTH);
		eSouth.add(EOrientation.EAST);
		Set<EOrientation> eWest = new HashSet<EOrientation>();
		eWest.add(EOrientation.WEST);
		eWest.add(EOrientation.SOUTH);
		
		assertEquals(eNorth, pNorth.getRequiredNeighbors());
		assertEquals(eEast, pEast.getRequiredNeighbors());
		assertEquals(eSouth, pSouth.getRequiredNeighbors());
		assertEquals(eWest, pWest.getRequiredNeighbors());
	}
	
}
