package uch.models;

import java.util.ArrayList;

public abstract class Employee extends Identity {

	protected double salary;
	protected boolean paid;

	public Employee(String name)
		{
		super(name);
		}

	public abstract void paySalary();

	public boolean hasBeenPaid()
		{
		return paid;
		}

	public double getSalary()
		{
		return salary;
		}

	public void setSalary(double salary)
		{
		this.salary = salary;
		}

	public String getJobTitle()
		{
		return "Employee";
		}

	public String getStatus()
		{
		return "Working";
		}

	public ArrayList<String> getColumnLabels()
		{
		ArrayList<String> columnLabels = new ArrayList<String>();
		columnLabels.add("First Name");
		//columnLabels.add("Middle Name");
		columnLabels.add("Last Name");
		columnLabels.add("Job Title");
		columnLabels.add("Status");
		columnLabels.add("Salary");
		columnLabels.add("Has Been Paid");
		columnLabels.add("ID");
		return columnLabels;
		}

	public ArrayList<String> getData()
		{
		ArrayList<String> data = new ArrayList<String>();
		data.add(firstName);
		//data.add(middleName);
		data.add(lastName);
		data.add(getJobTitle());
		data.add(getStatus());
		data.add("" + salary);
		data.add("" + paid);
		data.add(id.toString());
		return data;
		}
}
