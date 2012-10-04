package com.karolmajta.flipit.test.model;

import java.util.HashSet;
import java.util.Set;

import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.PieceP4Pipe;

import junit.framework.TestCase;

public class PieceP4DiagTestCase extends TestCase {
	
	public void testGetRequiredNeighbors() {
		PieceP4Pipe pNorth = new PieceP4Pipe();
		PieceP4Pipe pEast = new PieceP4Pipe();
		PieceP4Pipe pSouth = new PieceP4Pipe();
		PieceP4Pipe pWest = new PieceP4Pipe();
		
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
