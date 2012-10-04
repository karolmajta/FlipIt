package com.karolmajta.flipit.test.model;

import java.util.Set;

import com.karolmajta.flipit.model.CenterSymmetricPiece;
import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.EPiece;
import com.karolmajta.flipit.model.Piece;

import junit.framework.TestCase;

public class CenterSymmetricPieceTestCase extends TestCase {

	class SolidPiece extends CenterSymmetricPiece {
		SolidPiece(EPiece t, EOrientation o) {
			super(t, o);
		}
		@Override
		public Piece copy() {
			return null;
		}
		@Override
		public Piece copy(EOrientation o) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Set<EOrientation> getRequiredNeighbors() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public void testEquals() {
		/*
		 * Pieces are always equals to each other if underlying
		 * Type is equal.
		 */
		SolidPiece a = new SolidPiece(EPiece.P0, EOrientation.NORTH);
		SolidPiece b = new SolidPiece(EPiece.P0, EOrientation.SOUTH);
		SolidPiece c = new SolidPiece(EPiece.P1, EOrientation.NORTH);
		
		// we check also for sanity, so if a eq b then b eq a
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
		
		assertFalse(a.equals(c));
		assertFalse(c.equals(a));
	}
	
}
