package com.karolmajta.flipit.util;

import java.util.Hashtable;

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

public class BoardBuilder {
	
	private static final Hashtable<String, Piece> pieceMap;
	private static final Hashtable<String, EOrientation> orientationMap;
	
	static {
		pieceMap = new Hashtable<String, Piece>();
		orientationMap = new Hashtable<String, EOrientation>();
		
		pieceMap.put("[]", new PieceP0());
		pieceMap.put("0", new PieceP1(EOrientation.NORTH));
		pieceMap.put("|", new PieceP2Pipe(EOrientation.NORTH));
		pieceMap.put("/", new PieceP2Diag(EOrientation.NORTH));
		pieceMap.put("^", new PieceP3(EOrientation.NORTH));
		pieceMap.put("+", new PieceP4Pipe());
		pieceMap.put("//", new PieceP4Diag(EOrientation.NORTH));
		
		orientationMap.put("^", EOrientation.NORTH);
		orientationMap.put(">", EOrientation.EAST);
		orientationMap.put("v", EOrientation.SOUTH);
		orientationMap.put("<", EOrientation.WEST);
	}
	
	public static Piece buildPiece(String repr) {
		String [] splits = repr.split("\\.");
		String pieceRepr = splits[0];
		String orientationRepr = splits[1];
		EOrientation o = orientationMap.get(orientationRepr);
		return pieceMap.get(pieceRepr).copy(o);
	}
	
	public static Board buildBoard(String repr) {
		String [] lines = repr.split("\n");
		String [][] chunks = new String [lines.length][];
		for(int i=0; i<lines.length; i++) {
			chunks[i] = lines[i].split(":");
		}
		
		Piece [][] pieces = new Piece [chunks.length][];
		for(int i=0; i<chunks.length; i++) {
			pieces[i] = new Piece [chunks[i].length];
			for(int j=0; j<chunks[i].length; j++) {
				pieces[i][j] = buildPiece(chunks[i][j]);
			}
		}
		return new Board(pieces);
	}
}
