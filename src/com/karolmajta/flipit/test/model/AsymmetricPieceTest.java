package com.karolmajta.flipit.test.model;

import java.util.Set;

import com.karolmajta.flipit.model.AsymmetricPiece;
import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.EPiece;
import com.karolmajta.flipit.model.Piece;

import junit.framework.TestCase;

public class AsymmetricPieceTest extends TestCase {

	class SolidPiece extends AsymmetricPiece {
		protected SolidPiece(EPiece t, EOrientation o) {
			super(t, o);
		}
		@Override
		public Piece copy() {
			// TODO Auto-generated method stub
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
		 * Equals only if both EDirection and EPiece are same
		 */
		SolidPiece a = new SolidPiece(EPiece.P1, EOrientation.NORTH);
		SolidPiece b = new SolidPiece(EPiece.P1, EOrientation.NORTH);
		SolidPiece c = new SolidPiece(EPiece.P1, EOrientation.SOUTH);
		SolidPiece d = new SolidPiece(EPiece.P0, EOrientation.NORTH);
		
		assertTrue(a.equals(b));
		assertTrue(b.equals(a));
		
		assertFalse(a.equals(c));
		assertFalse(c.equals(a));
		
		assertFalse(a.equals(d));
		assertFalse(d.equals(a));
	}
}