package uch.identities;

import java.util.Random;

import uch.Global;
import uch.interfaces.CareGiver;
import uch.models.Employee;

public class Doctor extends Employee implements CareGiver {

	public static final String[] SPECIALTIES = { "Heart", "Brain", "Back", "Liver", "Lung", "Face", "Foot" };

	private String specialty;
	private boolean inSurgery;

	public Doctor(String name)
		{
		super(name);
		this.specialty = getRandomSpecialty();
		this.salary = 90000.0;
		this.inSurgery = false;
		}

	public Doctor(String name, String specialty)
		{
		super(name);
		this.specialty = specialty;
		this.salary = 90000.0;
		this.inSurgery = false;
		}

	@Override
	public void tick()
		{
		int randomValue = Global.getValueBetweenRange(0, 100);
		if (randomValue > 60)
			{
			inSurgery = !inSurgery;
			}
		}

	@Override
	public void paySalary()
		{
		if (paid)
			{
			System.out.println(getJobTitle() + " \"" + getName() + "\" was already paid this session!");
			}
		else
			{
			System.out.println(getJobTitle() + " \"" + getName() + "\" has been paid.");
			this.paid = true;
			}
		}

	public boolean isInSurgery()
		{
		return inSurgery;
		}

	public String getSpecialty()
		{
		return specialty;
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
		if (inSurgery)
			{
			return "In Surgery";
			}
		else
			{
			return "On Call";
			}
		}

}
