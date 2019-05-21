package uch;

public class Main {

	private Main() {
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the University Hospital Clinic");
	
		Employee emp1 = new Employee(Employee.getNewId());
		Employee emp2 = new Employee(Employee.getNewId());
		Employee emp3 = new Employee(Employee.getNewId());
		System.out.println(emp1.getId() + " : " + emp2.getId() + " : " + emp3.getId());	
		
		
	}

}
