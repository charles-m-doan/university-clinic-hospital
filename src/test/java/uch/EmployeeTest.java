package uch;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EmployeeTest {

	public EmployeeTest() {
	}

	@Test
	public void employeeShouldHaveIDEqualTo10() {
		Employee testEmployee1 = new Employee(10);
		assertEquals(10, testEmployee1.getId());
	}

	@Test
	public void idShouldIncreaseBy1() {
		int id1 = Employee.getNewId();
		System.out.println(id1);
		int id2 = Employee.getNewId();
		System.out.println(id2);
		assertEquals(id2, (id1 + 1));
	}

}
