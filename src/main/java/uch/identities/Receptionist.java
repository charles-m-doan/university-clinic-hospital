package uch.identities;

import uch.Global;
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
	public void tick()
		{
		int randomValue = Global.getValueBetweenRange(0, 100);
		if (randomValue > 30)
			{
			onPhone = !onPhone;
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

	public boolean isOnPhone()
		{
		return onPhone;
		}

	public void setOnPhone(boolean onPhone)
		{
		this.onPhone = onPhone;
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
