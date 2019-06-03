package uch.identities;

import java.util.ArrayList;

import uch.Global;
import uch.models.Identity;

public class Patient extends Identity {

	public static final int DEFAULT_HEALTH_LEVEL = 20;
	public static final int DEFAULT_BLOOD_LEVEL = 10;

	public static final int MIN_HEALTH_LEVEL = 1;
	public static final int MIN_BLOOD_LEVEL = 1;
	public final int maxHealthLevel;
	public final int maxBloodLevel;

	private int healthLevel;
	private int bloodLevel;

	public Patient(String name)
		{
		super(name);
		this.healthLevel = DEFAULT_HEALTH_LEVEL;
		this.bloodLevel = DEFAULT_BLOOD_LEVEL;
		this.maxHealthLevel = Global.getValueBetweenRange(DEFAULT_HEALTH_LEVEL, (int) (DEFAULT_HEALTH_LEVEL * 2.5));
		this.maxBloodLevel = Global.getValueBetweenRange(DEFAULT_BLOOD_LEVEL, (int) (DEFAULT_BLOOD_LEVEL * 3));
		}

	public Patient(String name, int healthLevel, int bloodLevel)
		{
		super(name);
		this.healthLevel = healthLevel;
		this.bloodLevel = bloodLevel;
		this.maxHealthLevel = Global.getValueBetweenRange(DEFAULT_HEALTH_LEVEL, (int) (DEFAULT_HEALTH_LEVEL * 2.5));
		this.maxBloodLevel = Global.getValueBetweenRange(DEFAULT_BLOOD_LEVEL, (int) (DEFAULT_BLOOD_LEVEL * 3));
		}

	public void tick()
		{
		regenBlood();
		regenHealth();
		degenerate();
		}

	public void regenBlood()
		{
		int randomValue = Global.getValueBetweenRange(0, 100);
		if (randomValue > 20)
			{
			increaseBloodLevel(Global.getValueBetweenRange(0, 2));
			}
		}

	public void regenHealth()
		{
		int randomValue = Global.getValueBetweenRange(0, 100 + 10 * bloodLevel);
		if (randomValue > 30)
			{
			increaseHealthLevel(Global.getValueBetweenRange(0, 2));
			}
		}

	public void degenerate()
		{
		int randomValue = Global.getValueBetweenRange(0, maxBloodLevel);
		if (randomValue > bloodLevel)
			{
			decreaseHealthLevel(Global.getValueBetweenRange(0, 2));
			}
		randomValue = Global.getValueBetweenRange(0, 100);
		if (randomValue <= 5)
			{
			decreaseHealthLevel(Global.getValueBetweenRange(0, 2 * randomValue));
			}
		randomValue = Global.getValueBetweenRange(0, 100);
		if (randomValue <= 10)
			{
			decreaseBloodLevel(Global.getValueBetweenRange(0, 1));
			}
		}

	public void decreaseBloodLevel(int amountToDecrease)
		{
		this.bloodLevel -= amountToDecrease;
		if (bloodLevel <= MIN_BLOOD_LEVEL)
			{
			bloodLevel = MIN_BLOOD_LEVEL;
			}
		}

	public void increaseBloodLevel(int amountToIncrease)
		{
		this.bloodLevel += amountToIncrease;
		if (bloodLevel > maxBloodLevel)
			{
			bloodLevel = maxBloodLevel;
			}
		}

	public void decreaseHealthLevel(int amountToDecrease)
		{
		this.healthLevel -= amountToDecrease;
		if (healthLevel <= MIN_HEALTH_LEVEL)
			{
			healthLevel = MIN_HEALTH_LEVEL;
			}
		}

	public void increaseHealthLevel(int amountToIncrease)
		{
		this.healthLevel += amountToIncrease;
		if (healthLevel > maxHealthLevel)
			{
			healthLevel = maxHealthLevel;
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
		// columnLabels.add("Middle Name");
		columnLabels.add("Last Name");
		columnLabels.add("Health");
		columnLabels.add("Blood Level");
		// columnLabels.add("ID");
		return columnLabels;
		}

	public ArrayList<String> getData()
		{
		ArrayList<String> data = new ArrayList<String>();
		data.add(firstName);
		// data.add(middleName);
		data.add(lastName);
		data.add("" + healthLevel + "/" + maxHealthLevel);
		data.add("" + bloodLevel + "/" + maxBloodLevel);
		// data.add(id.toString());
		return data;
		}
}
