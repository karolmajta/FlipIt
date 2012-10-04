package com.karolmajta.flipit.test.model;

import java.util.Set;

import com.karolmajta.flipit.model.Board;
import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.EPiece;
import com.karolmajta.flipit.model.Piece;
import com.karolmajta.flipit.model.PieceP1;

import junit.framework.TestCase;

public class BoardTestCase extends TestCase {

	class DummyPiece extends Piece {
		protected DummyPiece(EOrientation o) {
			super(EPiece.P0, o);
		}
		protected DummyPiece() {
			super(EPiece.P0, EOrientation.NORTH);
		}
		@Override
		public boolean equals(Object other) {
			Piece p = (Piece)other;
			if((this.getEOrientation() == p.getEOrientation())) {
				return true;
			} else {
				return false;
			}
		}
		@Override
		public Piece copy() {
			return new DummyPiece(getEOrientation());
		}
		@Override
		public Piece copy(EOrientation o) {
			return new DummyPiece(o);
		}
		@Override
		public Set<EOrientation> getRequiredNeighbors() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	public void testCannotInstantiateWithZeroLengthArrayForPieces() {
		try {
			new Board(new DummyPiece [0][0]);
			fail("Created Board With null array of pieces (0 rows)");
		} catch(IllegalArgumentException e) {}
	}
	
	public void testCannotInstantiateWithZeroLengthColumns() {
		try {
			new Board(new DummyPiece [4][0]);
			fail("Created Board With null array of pieces (0 columns)");
		} catch(IllegalArgumentException e) {}
	}
	
	public void testPiecesAreDeepCopied() {
		Piece [][] pieces = {
				{new DummyPiece(), new DummyPiece()},
				{new DummyPiece(), new DummyPiece()},
		};
		Board b = new Board(pieces);
		pieces[0][0] = pieces[0][0].copy(EOrientation.SOUTH);
		Piece [][] received = b.getPieces();
		assertFalse(received[0][0].equals(pieces[0][0]));
	}
	
	public void testGetSize() {
		DummyPiece [][] pcs = {
			{new DummyPiece(), new DummyPiece(), new DummyPiece()},
			{new DummyPiece(), new DummyPiece(), new DummyPiece()},
		};
		Board b = new Board(pcs);
		assertEquals(2, b.getSize()[0]);
		assertEquals(3, b.getSize()[1]);
	}
	
	public void testGetPiecesAreAllEqualButNotSameToSource() {
		DummyPiece [][] original = new DummyPiece [][] {
			{new DummyPiece(), new DummyPiece(), new DummyPiece()},
			{new DummyPiece(), new DummyPiece(), new DummyPiece()},
		};
		Board b = new Board(original);
		Piece [][] copy = b.getPieces();
		for(int i=0; i < original.length;  i++) {
			for(int j=0; j < original[1].length; j++) {
				assertTrue(original[i][j].equals(copy[i][j]));
				assertNotSame(original[i][j], copy[i][j]);
			}
		}
	}
	
	public void testFlip() {
		DummyPiece [][] original_pieces = new DummyPiece [][] {
			{new DummyPiece(), new DummyPiece()},
			{new DummyPiece(), new DummyPiece()},
		};
		Board original = new Board(original_pieces);
		Board flipped = original.flip(0, 0)
								.flip(0, 0)
								.flip(1, 1)
								.flip(1, 1)
								.flip(1, 1)
								.flip(1, 1)
								.flip(1, 1);
								
		Piece [][] flipped_pieces = flipped.getPieces();
		
		assertTrue(original_pieces[0][1].equals(flipped_pieces[0][1]));
		assertTrue(original_pieces[1][0].equals(flipped_pieces[1][0]));
		assertFalse(original_pieces[0][0].equals(flipped_pieces[0][0]));
		assertFalse(original_pieces[1][1].equals(flipped_pieces[1][1]));
		
		assertEquals(EOrientation.SOUTH, flipped_pieces[0][0].getEOrientation());
		assertEquals(EOrientation.EAST, flipped_pieces[1][1].getEOrientation());
	}		

	public void testFlipWillThrowIfIndexOutOfBounds() {
		DummyPiece [][] original_pieces = new DummyPiece [][] {
			{new DummyPiece(), new DummyPiece()},
			{new DummyPiece(), new DummyPiece()},
		};
		Board original = new Board(original_pieces);
		try {
			original.flip(2,1);
		} catch(IllegalArgumentException e) {}
	}
	
	public void testIsSolved() {
		Piece [][] original_pieces = new PieceP1 [][] {
			{new PieceP1(EOrientation.EAST), new PieceP1(EOrientation.WEST)},
			{new PieceP1(EOrientation.EAST), new PieceP1(EOrientation.WEST)},
		};
		Board b = new Board(original_pieces);
		assertTrue(b.isSolved());
		b = b.flip(0, 0);
		assertFalse(b.isSolved());
		b = b.flip(0,1);
		assertFalse(b.isSolved());
		b = b.flip(0, 0).flip(0, 0).flip(0, 0);
		assertFalse(b.isSolved());
		b = b.flip(0, 1).flip(0, 1).flip(0, 1);
		assertTrue(b.isSolved());
		
		original_pieces = new PieceP1 [][] {
			{new PieceP1(EOrientation.NORTH), new PieceP1(EOrientation.SOUTH)},
		};
		b = new Board(original_pieces);
		assertFalse(b.isSolved());
	}
}
