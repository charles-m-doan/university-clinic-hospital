package uch.identities;

import java.util.ArrayList;

import uch.models.Identity;

public class Patient extends Identity {

	public static final int DEFAULT_HEALTH_LEVEL = 20;
	public static final int DEFAULT_BLOOD_LEVEL = 10;

	private int healthLevel;
	private int bloodLevel;
	
	public Patient()
		{
		super("Unknown");
		this.healthLevel = DEFAULT_HEALTH_LEVEL;
		this.bloodLevel = DEFAULT_BLOOD_LEVEL;
		}

	public Patient(String name)
		{
		super(name);
		this.healthLevel = DEFAULT_HEALTH_LEVEL;
		this.bloodLevel = DEFAULT_BLOOD_LEVEL;
		}

	public Patient(String name, int healthLevel, int bloodLevel)
		{
		super(name);
		this.healthLevel = healthLevel;
		this.bloodLevel = bloodLevel;
		}


	public void decreaseBloodLevel(int amountToDecrease)
		{
		this.bloodLevel -= amountToDecrease;
		if (bloodLevel < 0)
			{
			bloodLevel = 0;
			}
		}

	public void increaseBloodLevel(int amountToIncrease)
		{
		this.bloodLevel += amountToIncrease;
		if (bloodLevel > DEFAULT_BLOOD_LEVEL)
			{
			bloodLevel = DEFAULT_BLOOD_LEVEL;
			}
		}

	public void decreaseHealthLevel(int amountToDecrease)
		{
		this.healthLevel -= amountToDecrease;
		if (healthLevel < 0)
			{
			healthLevel = 0;
			}
		}

	public void increaseHealthLevel(int amountToIncrease)
		{
		this.healthLevel += amountToIncrease;
		if (healthLevel > DEFAULT_HEALTH_LEVEL)
			{
			healthLevel = DEFAULT_HEALTH_LEVEL;
			}
		}

	public int getHealthLevel()
		{
		return healthLevel;
		}

	public int getBloodLevel()
		{
		return bloodLevel;
		}
	
	public ArrayList<String> getColumnLabels()
		{
		ArrayList<String> columnLabels = new ArrayList<String>();
		columnLabels.add("First Name");
		//columnLabels.add("Middle Name");
		columnLabels.add("Last Name");
		columnLabels.add("Health");
		columnLabels.add("Blood Level");
		//columnLabels.add("ID");
		return columnLabels;
		}

	public ArrayList<String> getData()
		{
		ArrayList<String> data = new ArrayList<String>();
		data.add(firstName);
		//data.add(middleName);
		data.add(lastName);
		data.add("" + healthLevel);
		data.add("" + bloodLevel);
		//data.add(id.toString());
		return data;
		}
}
