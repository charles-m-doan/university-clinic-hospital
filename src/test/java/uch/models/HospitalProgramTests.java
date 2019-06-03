package uch.models;

import uch.identities.Doctor;
import uch.identities.Janitor;
import uch.identities.Nurse;
import uch.identities.Patient;
import uch.identities.Receptionist;

public class HospitalProgramTests {

	HospitalProgram hp = new HospitalProgram();

	public HospitalProgramTests()
		{
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
		}

}
