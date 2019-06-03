package uch.identities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uch.identities.Patient;

public class PatientTest {

	Patient underTest = new Patient("Bill");

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
	public void patientShouldHaveBloodLevelOf10HigherOrMax()
		{
		int amountToIncrease = 10;
		underTest.increaseBloodLevel(amountToIncrease);
		int expected = Math.min(20, underTest.maxBloodLevel);
		int actual = underTest.getBloodLevel();
		assertEquals(expected, actual);
		}

	@Test
	public void patientShouldHaveMaxHealthLevel()
		{
		int amountToIncrease = 1000;
		underTest.increaseHealthLevel(amountToIncrease);
		assertEquals(underTest.maxHealthLevel, underTest.getHealthLevel());
		}

	@Test
	public void patientShouldHaveHealthLevelOf10()
		{
		int amountToDecrease = 10;
		underTest.decreaseHealthLevel(amountToDecrease);
		assertEquals(10, underTest.getHealthLevel());
		}
}
