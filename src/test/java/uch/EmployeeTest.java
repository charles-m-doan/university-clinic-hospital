package uch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EmployeeTest {
	
	Employee underTest = new Doctor("Bill", "Heart");

	@Test
	public void employeeShouldHaveIDEqualTo10() {
		assertEquals(10, underTest.getId());
	}

	@Test
	public void idShouldIncreaseBy1() {
		int id1 = Employee.getNewId();
		System.out.println(id1);
		int id2 = Employee.getNewId();
		System.out.println(id2);
		assertEquals(id2, (id1 + 1));
	}
	
	@Test
	public void paidShouldBeTrue() {
		underTest.paySalary();
		assertTrue(underTest.hasBeenPaid());
	}

}
