package uch.personel;

import java.util.Random;

import uch.models.Employee;
import uch.patients.Patient;

public class Doctor extends Employee {

	public static final String[] SPECIALTIES = { "Heart", "Brain", "Back", "Liver", "Lung", "Face", "Foot" };

	private String specialty;

	public Doctor(String name)
		{
		super(name);
		this.specialty = getRandomSpecialty();
		this.salary = 90000.0;
		}

	public Doctor(String name, String specialty)
		{
		super(name);
		this.specialty = specialty;
		this.salary = 90000.0;
		}

	public void paySalary()
		{
		if (paid)
			{
			System.out.println(getName() + " has already been paid");
			}
		else
			{
			System.out.println("Doctor " + getName() + " got paid.");
			this.paid = true;
			}
		}

	public String getSpecialty()
		{
		return specialty;
		}

	public String toString()
		{
		String paidStatus = "has not been paid";
		if (paid)
			{
			paidStatus = "has been paid";
			}
		return "Doctor: " + getName() + " | " + getId().toString() + " | " + salary + " | " + specialty + " | " + paidStatus;
		}

	public void drawBlood(Patient patient)
		{
		int amountToDraw = 5;
		patient.decreaseBloodLevel(amountToDraw);
		System.out.println("Doctor " + getName() + " drew blood from " + patient.getName());
		}

	public void careForPatient(Patient patient)
		{
		int amountToIncrease = 10;
		patient.increaseHealthLevel(amountToIncrease);
		System.out.println("Doctor " + getName() + " gave care to " + patient.getName());
		}

	public static String getRandomSpecialty()
		{
		Random random = new Random(System.nanoTime());
		int randomValue = random.nextInt(SPECIALTIES.length);
		return SPECIALTIES[randomValue];
		}
	
	public String getJobTitle()
		{
		return specialty + " Doctor";
		}

	public String getStatus()
		{
		return "On Call";
		}

}
