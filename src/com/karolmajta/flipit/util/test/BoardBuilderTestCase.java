package com.karolmajta.flipit.util.test;

import com.karolmajta.flipit.model.Board;
import com.karolmajta.flipit.model.EOrientation;
import com.karolmajta.flipit.model.Piece;
import com.karolmajta.flipit.model.PieceP0;
import com.karolmajta.flipit.model.PieceP1;
import com.karolmajta.flipit.model.PieceP2Diag;
import com.karolmajta.flipit.model.PieceP2Pipe;
import com.karolmajta.flipit.model.PieceP3;
import com.karolmajta.flipit.model.PieceP4Diag;
import com.karolmajta.flipit.model.PieceP4Pipe;
import com.karolmajta.flipit.util.BoardBuilder;

import junit.framework.TestCase;

public class BoardBuilderTestCase extends TestCase {

	public void testBuildPiece() {
		String repr0 = "[].>";
		String repr1 = "0.<";
		String repr2P = "|.<";
		String repr2D = "/.^";
		String repr3 = "^.v";
		String repr4P = "+.>";
		String repr4D = "//.v";
		
		Piece p0 = BoardBuilder.buildPiece(repr0);
		Piece p1 = BoardBuilder.buildPiece(repr1);
		Piece p2P = BoardBuilder.buildPiece(repr2P);
		Piece p2D = BoardBuilder.buildPiece(repr2D);
		Piece p3 = BoardBuilder.buildPiece(repr3);
		Piece p4P = BoardBuilder.buildPiece(repr4P);
		Piece p4D = BoardBuilder.buildPiece(repr4D);
		
		assertEquals(new PieceP0(), p0);
		assertEquals(new PieceP1(EOrientation.WEST), p1);
		assertEquals(new PieceP2Pipe(EOrientation.WEST), p2P);
		assertEquals(new PieceP2Diag(EOrientation.NORTH), p2D);
		assertEquals(new PieceP3(EOrientation.SOUTH), p3);
		assertEquals(new PieceP4Pipe(), p4P);
		assertEquals(new PieceP4Diag(EOrientation.SOUTH), p4D);
	}
	
	public void testBuildBoard() {
		String repr = "[].>:0.<:|.<" + "\n" +
					  "/.^:^.v:+.>";
		Board b = BoardBuilder.buildBoard(repr);
		assertEquals(2, b.getSize()[0]);
		assertEquals(3, b.getSize()[1]);
		assertTrue(b.getPieces()[0][0].equals(new PieceP0()));
		assertTrue(b.getPieces()[0][1].equals(new PieceP1(EOrientation.WEST)));
		assertTrue(b.getPieces()[0][2].equals(new PieceP2Pipe(EOrientation.EAST)));
		assertTrue(b.getPieces()[1][0].equals(new PieceP2Diag(EOrientation.NORTH)));
		assertTrue(b.getPieces()[1][1].equals(new PieceP3(EOrientation.SOUTH)));
		assertTrue(b.getPieces()[1][2].equals(new PieceP4Pipe()));
	}
}
