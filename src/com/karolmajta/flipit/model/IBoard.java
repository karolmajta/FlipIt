package com.karolmajta.flipit.model;

public interface IBoard {

	public int [] getSize();
	public IPiece [][] getPieces();
	public Board flip(int r , int c) throws IllegalArgumentException;
	public boolean isSolved();
}
