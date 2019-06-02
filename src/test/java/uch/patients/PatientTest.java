package uch.patients;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PatientTest {

	Patient underTest = new Patient();

	public PatientTest()
		{
		}

	@Test
	public void patientShouldHaveBloodLevelOf7()
		{
		int amountToDecrease = 3;
		underTest.decreaseBloodLevel(amountToDecrease);
		assertEquals(7, underTest.getBloodLevel());
		}

	@Test
	public void patientShouldHaveBloodLevelOf10()
		{
		int amountToIncrease = 10;
		underTest.increaseBloodLevel(amountToIncrease);
		assertEquals(Patient.DEFAULT_BLOOD_LEVEL, underTest.getBloodLevel());
		}

	@Test
	public void patientShouldHaveDefaultHealthLevel()
		{
		int amountToIncrease = 10;
		underTest.increaseHealthLevel(amountToIncrease);
		assertEquals(Patient.DEFAULT_HEALTH_LEVEL, underTest.getHealthLevel());
		}

	@Test
	public void patientShouldHaveHealthLevelOf10()
		{
		int amountToDecrease = 10;
		underTest.decreaseHealthLevel(amountToDecrease);
		assertEquals(10, underTest.getHealthLevel());
		}
}
