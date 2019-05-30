package uch;

public class Doctor extends Employee {
	
	private String specialty;

	public Doctor(String name, String specialty) {
		super(Employee.getNewId(), name);
		this.specialty = specialty;
		this.salary = 90000.0;
	}
	
	public void paySalary() {
		if (paid) {
			System.out.println(name + " has already been paid");
		} else {
			System.out.println("Doctor " + name + " got paid.");
			this.paid = true;
		}
	}

	public String getSpecialty() {
		return specialty;
	}
	
	public String toString() {
		return "Doctor: " + name + " | " + id + " | " + salary + " | " + specialty + " | " + paid;
	}
	
}
