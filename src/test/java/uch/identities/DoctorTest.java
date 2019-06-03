package uch.identities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uch.identities.Doctor;

public class DoctorTest {

	Doctor underTest = new Doctor("Bill", "Heart");
	Patient testPatient = new Patient();

	@Test
	public void paidShouldBeTrue()
		{
		underTest.paySalary();
		assertTrue(underTest.hasBeenPaid());
		}

	@Test
	public void patientShouldHaveBloodLevelOf5()
		{
		underTest.drawBlood(testPatient);
		assertEquals(5, testPatient.getBloodLevel());
		}

}
