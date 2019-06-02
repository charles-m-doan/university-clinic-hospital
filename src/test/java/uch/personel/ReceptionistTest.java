package uch.personel;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uch.personel.Receptionist;

public class ReceptionistTest {

	Receptionist underTest = new Receptionist("Jane");

	@Test
	public void onPhoneShouldBeFalse()
		{
		assertTrue(underTest.isOnPhone() == false);
		}

}
