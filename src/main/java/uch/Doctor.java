package uch;

public class Doctor extends Employee {
	
	private String specialty;

	public Doctor(String name, String specialty) {
		super(Employee.getNewId());
		this.specialty = specialty;
		this.name = name;
		this.salary = 90000.0;
	}
	
	public void paySalary() {
		System.out.println(specialty + " doctor got paid.");
		this.paid = true;
	}

	public String getSpecialty() {
		return specialty;
	}
	
	public String toString() {
		return name + " | " + id + " | " + salary + " | " + specialty + " | " + paid;
	}
	
}
