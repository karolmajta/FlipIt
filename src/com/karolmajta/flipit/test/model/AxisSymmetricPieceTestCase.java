package com.karolmajta.flipit.test.model;

import java.util.Set;

import com.karolmajta.flipit.model.AxisSymmetricPiece;
import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.EPiece;
import com.karolmajta.flipit.model.Piece;

import junit.framework.TestCase;

public class AxisSymmetricPieceTestCase extends TestCase {

	class SolidPiece extends AxisSymmetricPiece {
		protected SolidPiece(EPiece t, EOrientation o) {
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
		SolidPiece north = new SolidPiece(EPiece.P2_PIPE, EOrientation.NORTH);
		SolidPiece east = new SolidPiece(EPiece.P2_PIPE, EOrientation.EAST);
		SolidPiece south = new SolidPiece(EPiece.P2_PIPE, EOrientation.SOUTH);
		SolidPiece west = new SolidPiece(EPiece.P2_PIPE, EOrientation.WEST); 
		
		assertTrue(north.equals(south));
		assertTrue(south.equals(north));
		assertTrue(west.equals(east));
		assertTrue(east.equals(west));
		
		assertFalse(north.equals(west));
		assertFalse(north.equals(east));
		assertFalse(east.equals(north));
		assertFalse(east.equals(south));
		
		SolidPiece west2 = new SolidPiece(EPiece.P0, EOrientation.WEST);
		assertFalse(west.equals(west2));
		assertFalse(west2.equals(west));
	}
	
}
