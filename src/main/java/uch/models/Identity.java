package uch.models;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Identity implements Comparable<Identity> {

	protected final UUID id;
	protected String firstName;
	protected String middleName;
	protected String lastName;

	public Identity()
		{
		super();
		this.id = UUID.randomUUID();
		this.firstName = "Unknown";
		this.middleName = "";
		this.lastName = "";
		}

	public Identity(String name)
		{
		super();
		String[] names = parseNameString(name);
		this.id = UUID.randomUUID();
		this.firstName = names[0];
		this.middleName = names[1];
		this.lastName = names[2];
		}

	public int compareTo(Identity identity)
		{
		// Gives Identity classes a natural alphabetical ordering based on name, using UUID to break ties.
		int comparison = this.getName().compareTo(identity.getName());
		if (comparison == 0)
			{
			return this.id.compareTo(identity.getId());
			}
		else
			{
			return comparison;
			}
		}

	public UUID getId()
		{
		return id;
		}

	public String getFirstName()
		{
		return firstName;
		}

	public String getMiddleName()
		{
		return middleName;
		}

	public String getLastName()
		{
		return lastName;
		}

	public String getName()
		{
		return firstName + " " + lastName;
		}

	public String toString()
		{
		return getName() + " : " + id.toString();
		}

	private static String[] parseNameString(String name)
		{
		String[] names = { "Unknown", "", "" };
		String[] tokens = name.split(" ");
		if (tokens.length > 3)
			{
			names[0] = tokens[0];
			names[2] = tokens[tokens.length - 1];
			}
		else if (tokens.length == 3)
			{
			names[0] = tokens[0];
			names[1] = tokens[1];
			names[2] = tokens[2];
			}
		else if (tokens.length == 2)
			{
			names[0] = tokens[0];
			names[2] = tokens[1];
			}
		else if (tokens.length == 1)
			{
			names[0] = tokens[0];
			}
		return names;
		}

	public ArrayList<String> getColumnLabels()
		{
		ArrayList<String> columnLabels = new ArrayList<String>();
		columnLabels.add("First Name");
		// columnLabels.add("Middle Name");
		columnLabels.add("Last Name");
		columnLabels.add("ID");
		return columnLabels;
		}

	public ArrayList<String> getData()
		{
		ArrayList<String> data = new ArrayList<String>();
		data.add(firstName);
		// data.add(middleName);
		data.add(lastName);
		data.add(id.toString());
		return data;
		}
}
