package uch;


public class Janitor extends Employee{
	private boolean sweeping;

	public Janitor(String name) {
		super(Employee.getNewId(), name);
		this.setSweeping(false);
		this.salary = 40000.0;
	}

	@Override
	public void paySalary() {
		if(paid) {
			System.out.println(name + "has already been paid");
		} else {
			System.out.println("Janitor + name + got paid");
			this.paid = true;
		}
		
	}
	public boolean isSweeping() {
		return sweeping;
	}
	
	public void setSweeping(boolean sweeping) {
		this.sweeping = sweeping;
	}
	public String toString() {
		return "Janitor | " + id + " | " + salary + " | " + paid;
		
	}

}