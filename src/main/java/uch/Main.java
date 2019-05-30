package uch;

public class Main {

	private Main() {
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the University Hospital Clinic");
	
		Doctor emp1 = new Doctor("Bill", "Heart");
		Doctor emp2 = new Doctor("Jill", "Lung");
		Doctor emp3 = new Doctor("Jack", "Liver");
		
		System.out.println(emp1);
		System.out.println(emp2);
		System.out.println(emp3);
		
		
		Receptionist recep1 = new Receptionist("Jane");
		Receptionist recep2 = new Receptionist("Elizabeth");
		
		System.out.println(recep1);
		System.out.println(recep2);
		
		
	}

}
