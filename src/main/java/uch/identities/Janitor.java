package uch.identities;

import uch.Global;
import uch.models.Employee;

public class Janitor extends Employee {
	private boolean sweeping;

	public Janitor(String name)
		{
		super(name);
		this.setSweeping(false);
		this.salary = 40000.0;
		}
	
	@Override
	public void tick()
		{
		int randomValue = Global.getValueBetweenRange(0, 100);
		if (randomValue > 60)
			{
			sweeping = !sweeping;
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

	public boolean isSweeping()
		{
		return sweeping;
		}

	public void setSweeping(boolean sweeping)
		{
		this.sweeping = sweeping;
		}

	public String getJobTitle()
		{
		return "Janitor";
		}

	public String getStatus()
		{
		if (sweeping)
			{
			return "Sweeping";
			}
		else
			{
			return "Roving";
			}
		}

}
