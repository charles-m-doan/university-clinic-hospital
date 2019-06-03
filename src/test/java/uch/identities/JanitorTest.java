package uch.identities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uch.identities.Janitor;
import uch.identities.Receptionist;

public class JanitorTest {

	Janitor underTest = new Janitor("Bob");

	@Test
	public void isSweepingShouldBeFalse()
		{
		assertTrue(underTest.isSweeping() == false);
		}

}
