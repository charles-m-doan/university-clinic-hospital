package uch;

public class Employee {
	
	private static int currentId = 0;
	
	private final int id;
	private String name;
	private double salary;

	public Employee(int id) {
		super();
		this.id = id;
		this.name = "Unknown";
	}
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	public static int getNewId() {
		currentId++;
		return currentId;
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
