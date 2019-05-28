package uch;

public class Nurse extends Employee {
	private int numOfPatients;

	public Nurse(String name, int numOfPatients) {
		super(Employee.getNewId(), name);
		this.numOfPatients = numOfPatients;
		this.salary = 50000.0;

	}

	@Override
	public void paySalary() {
		if(paid) {
			System.out.println(name + "has already been paid");
		} else {
			System.out.println("Nurse + name + got paid");
			this.paid = true;
		}
	}

	public int getNumOfPatients() {
		return numOfPatients;
	}

	public String toString() {
		return "Nurse | " + id + " | " + salary + " | " + paid;
	}
}
