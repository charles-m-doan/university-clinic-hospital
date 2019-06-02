package uch.personel;

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
	public void paySalary()
		{
		if (paid)
			{
			System.out.println(getName() + "has already been paid");
			}
		else
			{
			System.out.println("Janitor + name + got paid");
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

	public String toString()
		{
		String paidStatus = "has not been paid";
		if (paid)
			{
			paidStatus = "has been paid";
			}
		return "Janitor: " + getName() + " | " + getId().toString() + " | " + salary + " | " + paidStatus;
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
