package uch;

import uch.application.AppInterface;
import uch.identities.Doctor;
import uch.identities.Janitor;
import uch.identities.Nurse;
import uch.identities.Patient;
import uch.identities.Receptionist;
import uch.models.HospitalProgram;

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
		hp.addEmployee(new Receptionist("Sansa Stark"));
		hp.addEmployee(new Janitor("Tyrion Lanister"));
		hp.addEmployee(new Nurse("Ginnie Weasley"));
		hp.addEmployee(new Nurse("Nymphadora Tonks"));
		hp.addEmployee(new Nurse("Filius Flitwick"));
		hp.addEmployee(new Receptionist("Hermione Granger"));
		hp.addEmployee(new Janitor("Harry Dresden"));
		hp.addEmployee(new Doctor("Harry Potter"));

		// Default Patients
		hp.addPatient(new Patient("Karen Murphy"));
		hp.addPatient(new Patient("Mollie Carpenter"));
		hp.addPatient(new Patient("Michael Carpenter"));
		hp.addPatient(new Patient("Ron Weasley"));
		hp.addPatient(new Patient("Fred Weasley"));
		hp.addPatient(new Patient("George Weasley"));
		hp.addPatient(new Patient("Draco Malfoy"));
		hp.addPatient(new Patient("Severus Snape"));
		hp.addPatient(new Patient("Albus Dumbledore"));
		hp.addPatient(new Patient("Sirius Black"));
		hp.addPatient(new Patient("Remus Lupin"));

		AppInterface appInterface = new AppInterface(hp);
		appInterface.startAppInterface();
		}

}
