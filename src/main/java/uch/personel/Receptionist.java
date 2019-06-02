package uch.personel;

import uch.models.Employee;

public class Receptionist extends Employee {

	private boolean onPhone;

	public Receptionist(String name)
		{
		super(name);
		this.onPhone = false;
		this.salary = 45000;
		}

	@Override
	public void paySalary()
		{
		if (paid)
			{
			System.out.println(getName() + " has already been paid");
			}
		else
			{
			System.out.println("Receptionist " + getName() + " got paid.");
			this.paid = true;
			}
		}

	public boolean isOnPhone()
		{
		return onPhone;
		}

	public void setOnPhone(boolean onPhone)
		{
		this.onPhone = onPhone;
		}

	public String toString()
		{
		String paidStatus = "has not been paid";
		if (paid)
			{
			paidStatus = "has been paid";
			}
		return "Receptionist: " + getName() + " | " + getId().toString() + " | " + salary + " | " + paidStatus;
		}

	public String getJobTitle()
		{
		return "Receptionist";
		}

	public String getStatus()
		{
		if (onPhone)
			{
			return "Handling Call";
			}
		else
			{
			return "On Standby";
			}
		}
}
