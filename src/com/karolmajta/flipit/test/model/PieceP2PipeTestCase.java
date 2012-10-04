package com.karolmajta.flipit.test.model;

import java.util.HashSet;
import java.util.Set;

import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.PieceP2Pipe;

import junit.framework.TestCase;

public class PieceP2PipeTestCase extends TestCase {
	
	public void testGetRequiredNeighbors() {
		PieceP2Pipe pNorth = new PieceP2Pipe(EOrientation.NORTH);
		PieceP2Pipe pEast = new PieceP2Pipe(EOrientation.EAST);
		PieceP2Pipe pSouth = new PieceP2Pipe(EOrientation.SOUTH);
		PieceP2Pipe pWest = new PieceP2Pipe(EOrientation.WEST);
		
		Set<EOrientation> eNorth = new HashSet<EOrientation>();
		eNorth.add(EOrientation.NORTH);
		eNorth.add(EOrientation.SOUTH);
		Set<EOrientation> eEast = new HashSet<EOrientation>();
		eEast.add(EOrientation.EAST);
		eEast.add(EOrientation.WEST);
		Set<EOrientation> eSouth = new HashSet<EOrientation>();
		eSouth.add(EOrientation.SOUTH);
		eSouth.add(EOrientation.NORTH);
		Set<EOrientation> eWest = new HashSet<EOrientation>();
		eWest.add(EOrientation.WEST);
		eWest.add(EOrientation.EAST);
		
		assertEquals(eNorth, pNorth.getRequiredNeighbors());
		assertEquals(eEast, pEast.getRequiredNeighbors());
		assertEquals(eSouth, pSouth.getRequiredNeighbors());
		assertEquals(eWest, pWest.getRequiredNeighbors());
	}

}
