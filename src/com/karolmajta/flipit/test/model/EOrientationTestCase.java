package com.karolmajta.flipit.test.model;

import com.karolmajta.flipit.model.EOrientation;

import junit.framework.TestCase;

public class EOrientationTestCase extends TestCase {
	
	public void testGetOpposite() {
		EOrientation expected;
		EOrientation actual;
		
		expected = EOrientation.SOUTH;
		actual = EOrientation.getOpposite(EOrientation.NORTH);
		assertEquals(expected, actual);
		
		expected = EOrientation.WEST;
		actual = EOrientation.getOpposite(EOrientation.EAST);
		assertEquals(expected, actual);
		
		expected = EOrientation.NORTH;
		actual = EOrientation.getOpposite(EOrientation.SOUTH);
		assertEquals(expected, actual);
		
		expected = EOrientation.EAST;
		actual = EOrientation.getOpposite(EOrientation.WEST);
		assertEquals(expected, actual);
	}
}
