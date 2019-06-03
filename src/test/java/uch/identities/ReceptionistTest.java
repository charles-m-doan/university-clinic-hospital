package uch.identities;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uch.identities.Receptionist;

public class ReceptionistTest {

	Receptionist underTest = new Receptionist("Jane");

	@Test
	public void onPhoneShouldBeFalse()
		{
		assertTrue(underTest.isOnPhone() == false);
		}

}
