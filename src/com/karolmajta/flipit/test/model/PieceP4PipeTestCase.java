package com.karolmajta.flipit.test.model;

import java.util.HashSet;
import java.util.Set;

import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.PieceP4Diag;

import junit.framework.TestCase;

public class PieceP4PipeTestCase extends TestCase {
	
	public void testGetRequiredNeighbors() {
		PieceP4Diag pNorth = new PieceP4Diag(EOrientation.NORTH);
		PieceP4Diag pEast = new PieceP4Diag(EOrientation.EAST);
		PieceP4Diag pSouth = new PieceP4Diag(EOrientation.SOUTH);
		PieceP4Diag pWest = new PieceP4Diag(EOrientation.WEST);
		
		Set<EOrientation> e = new HashSet<EOrientation>();
		e.add(EOrientation.NORTH);
		e.add(EOrientation.EAST);
		e.add(EOrientation.WEST);
		e.add(EOrientation.SOUTH);
		
		assertEquals(e, pNorth.getRequiredNeighbors());
		assertEquals(e, pEast.getRequiredNeighbors());
		assertEquals(e, pSouth.getRequiredNeighbors());
		assertEquals(e, pWest.getRequiredNeighbors());
	}

}
