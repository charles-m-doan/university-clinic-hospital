package uch.identities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uch.identities.Nurse;

public class NurseTest {

	Nurse underTest = new Nurse("Bill", 1);
	Patient testPatient = new Patient();
	Patient testPatient2 = new Patient("Molly Weasley", 5, 10);

	public NurseTest()
		{
		}

	@Test
	public void patientShouldHaveBloodLevelOf7()
		{
		underTest.drawBlood(testPatient);
		assertEquals(7, testPatient.getBloodLevel());
		}

	@Test
	public void patientShouldHaveHealthLevelOf7()
		{
		underTest.drawBlood(testPatient);
		assertEquals(7, testPatient.getBloodLevel());
		}
	
}
