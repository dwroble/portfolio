package com.seive;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SieveTest {
	

	@Test
	public void testInit() {
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 5, 7, 11, 13,17, 19,23, 25,29));
		ArrayList<Integer> list = Sieve.init(30);
		assertEquals(a, list);
	}

}
