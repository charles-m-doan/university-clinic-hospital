package uch;

public class Main {

	private Main() {
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the University Hospital Clinic");
	
		Doctor emp1 = new Doctor("Bill", "Heart");
		Doctor emp2 = new Doctor("Jill", "Lung");
		Doctor emp3 = new Doctor("Jack", "Liver");
		
		
		//System.out.println(emp1.getId() + " : " + emp2.getId() + " : " + emp3.getId());	
		//System.out.println(emp1.getName() + " : " + emp2.getName() + " : " + emp3.getName());	
		//System.out.println(emp1.getSpecialty() + " : " + emp2.getSpecialty() + " : " + emp3.getSpecialty());
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
	}

}
