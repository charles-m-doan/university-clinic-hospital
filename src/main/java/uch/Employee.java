package uch;

public abstract class Employee {

	private static int currentId = 0;

	protected final int id;
	protected String name;
	protected double salary;
	protected boolean paid;

	public Employee(int id) {
		super();
		this.id = id;
		this.name = "Unknown";
		this.paid = false;
	}
	
	public abstract void paySalary();

	public boolean hasBeenPaid() {
		return paid;
	}

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.paid = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public static int getNewId() {
		currentId++;
		return currentId;
	}
	
	public String toString() {
		return name + " | " + id + " | " + salary + " | " + paid;
	}

}
