package uch.personel;

import uch.models.Employee;
import uch.patients.Patient;

public class Nurse extends Employee {

	private int numOfPatients;

	public Nurse(String name, int numOfPatients)
		{
		super(name);
		this.numOfPatients = numOfPatients;
		this.salary = 50000.0;
		}

	public Nurse(String name)
		{
		super(name);
		this.numOfPatients = 0;
		this.salary = 50000.0;
		}

	@Override
	public void paySalary()
		{
		if (paid)
			{
			System.out.println(getName() + "has already been paid");
			}
		else
			{
			System.out.println("Nurse + name + got paid");
			this.paid = true;
			}
		}

	public int getNumOfPatients()
		{
		return numOfPatients;
		}

	public void addPatient()
		{
		numOfPatients++;
		}

	public void removePatient()
		{
		numOfPatients--;
		if (numOfPatients < 0)
			{
			numOfPatients = 0;
			}
		}

	public String toString()
		{
		String paidStatus = "has not been paid";
		if (paid)
			{
			paidStatus = "has been paid";
			}
		return "Nurse: " + getName() + " | " + getId().toString() + " | " + salary + " | " + paidStatus + " | currently giving care to " + numOfPatients + " patients.";
		}

	public void drawBlood(Patient patient)
		{
		int amountToDraw = 3;
		patient.decreaseBloodLevel(amountToDraw);
		System.out.println("Nurse " + getName() + " drew blood from " + patient.getName());
		}

	public void careForPatient(Patient patient)
		{
		int amountToIncrease = 5;
		patient.increaseHealthLevel(amountToIncrease);
		System.out.println("Nurse " + getName() + " gave care to " + patient.getName());
		}

	public String getJobTitle()
		{
		return "Nurse";
		}

	public String getStatus()
		{
		if (numOfPatients > 0)
			{
			return "Monitoring " + numOfPatients + " patients";
			}
		else
			{
			return "On Standby";
			}
		}
}
