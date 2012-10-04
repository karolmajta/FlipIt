package com.karolmajta.flipit.test.model;

import com.karolmajta.flipit.model.AsymmetricPiece;
import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.EPiece;
import com.karolmajta.flipit.model.Piece;

import junit.framework.TestCase;

public class PieceTestCase extends TestCase {

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
	}
	
	public void testHashCode() {
		EPiece p = EPiece.P2_DIAG;
		EOrientation o = EOrientation.SOUTH;
		
		SolidPiece piece = new SolidPiece(p, o);
		
		int expected = p.ordinal()*10 + o.ordinal();
		int actual = piece.hashCode();
		assertEquals(expected, actual);
	}
	
}
