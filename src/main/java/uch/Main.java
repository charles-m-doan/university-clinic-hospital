package uch;

import uch.application.HospitalProgram;
import uch.patients.Patient;
import uch.personel.Doctor;
import uch.personel.Janitor;
import uch.personel.Nurse;
import uch.personel.Receptionist;
import uch.ui.TextTable;

public class Main {

	private Main()
		{
		}

	public static void main(String[] args)
		{
		HospitalProgram hp = new HospitalProgram();
		
		// Default Employees
		hp.addEmployee(new Doctor("Ned Stark", Doctor.SPECIALTIES[0]));
		hp.addEmployee(new Doctor("Rob Stark", Doctor.SPECIALTIES[1]));
		hp.addEmployee(new Doctor("Jon Snow", Doctor.SPECIALTIES[6]));
		hp.addEmployee(new Nurse("Arya Stark", 5));
		hp.addEmployee(new Janitor("Tyrion Lanister"));
		hp.addEmployee(new Receptionist("Sansa Stark"));
		hp.addEmployee(new Doctor("Harry Potter"));
		hp.addEmployee(new Receptionist("Hermione Granger"));
		hp.addEmployee(new Janitor("Fred Weasley"));
		hp.addEmployee(new Janitor("George Weasley"));
		hp.addEmployee(new Nurse("Ginnie Weasley"));
		hp.addEmployee(new Nurse("Minerva McGonagall", 3));
		hp.addEmployee(new Janitor("Ron Weasley"));
		hp.addEmployee(new Janitor("Harry Copperfield Dresden"));
		hp.addEmployee(new Receptionist("Jim Butcher"));
		
		// Default Patients
		hp.addPatient(new Patient("Karen Murphy"));
		hp.addPatient(new Patient("Mollie Carpenter"));
		hp.addPatient(new Patient("Michael Carpenter"));
		hp.addPatient(new Patient("Julius Caesar"));

		try
			{
			TextTable tt = new TextTable(hp.getEmployeeTableList());
			System.out.println("Employees");
			System.out.println(tt);
			}
		catch (Exception ex)
			{
			System.out.println(ex.getMessage());
			}
		
		System.out.println("");
		
		try
			{
			TextTable tt = new TextTable(hp.getPatientTableList());
			System.out.println("Patients");
			System.out.println(tt);
			}
		catch (Exception ex)
			{
			System.out.println(ex.getMessage());
			}

		}

}
