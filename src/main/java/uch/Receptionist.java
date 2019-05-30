package uch;

public class Receptionist extends Employee {

	private boolean onPhone;

	public Receptionist(String name) {
		super(Employee.getNewId(), name);
		this.onPhone = false;
		this.salary = 45000;
	}

	@Override
	public void paySalary() {
		if (paid) {
			System.out.println(name + " has already been paid");
		} else {
			System.out.println("Receptionist " + name + " got paid.");
			this.paid = true;
		}
	}

	public boolean isOnPhone() {
		return onPhone;
	}

	public void setOnPhone(boolean onPhone) {
		this.onPhone = onPhone;
	}

	public String toString() {
		return "Receptionist: " + name + " | " + id + " | " + salary + " | " + paid;
	}

}
