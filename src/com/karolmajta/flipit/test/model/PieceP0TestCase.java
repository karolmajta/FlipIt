package com.karolmajta.flipit.test.model;

import java.util.HashSet;
import java.util.Set;

import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.PieceP0;

import junit.framework.TestCase;

public class PieceP0TestCase extends TestCase {
	
	public void testGetRequiredNeighbors() {
		PieceP0 p = new PieceP0();
		Set<EOrientation> expected = new HashSet<EOrientation>();
		Set<EOrientation> actual = p.getRequiredNeighbors();
		assertEquals(expected, actual);
	}
	
}
