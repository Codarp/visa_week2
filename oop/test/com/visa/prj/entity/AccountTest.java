package com.visa.prj.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testEqualsObject() {

		Account a = new Account("1200");
		Account b = new Account("1200");
		boolean expected = true;
		assertEquals(expected, a.equals(b));

	}

}
