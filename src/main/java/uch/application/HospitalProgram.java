package uch.application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import uch.models.Employee;
import uch.models.Identity;
import uch.patients.Patient;

public class HospitalProgram {
	private HashMap<UUID, Employee> employees;
	private HashMap<UUID, Patient> patients;

	public HospitalProgram()
		{
		employees = new HashMap<UUID, Employee>();
		patients = new HashMap<UUID, Patient>();
		}

	public void addEmployee(Employee employee)
		{
		this.employees.put(employee.getId(), employee);
		}

	public void addPatient(Patient patient)
		{
		this.patients.put(patient.getId(), patient);
		}

	public ArrayList<Employee> findAllEmployeesWithSubName(String subName)
		{
		ArrayList<Employee> matchingEmployees = new ArrayList<Employee>();
		for (Map.Entry<UUID, Employee> entry : employees.entrySet())
			{
			Employee employee = entry.getValue();
			if (employee.getName().contains(subName))
				{
				matchingEmployees.add(employee);
				}
			}
		return matchingEmployees;
		}

	public ArrayList<Identity> getEmployeeTableList()
		{
		ArrayList<Identity> employeeTableList = new ArrayList<Identity>(employees.values());
		return employeeTableList;
		}

	public ArrayList<Identity> getPatientTableList()
		{
		ArrayList<Identity> patientTableList = new ArrayList<Identity>(patients.values());
		return patientTableList;
		}

	public ArrayList<Employee> getEmployeeList()
		{
		Collection<Employee> mapValues = employees.values();
		ArrayList<Employee> employeeList = new ArrayList<Employee>(mapValues);
		return (employeeList);
		}

	public String getEmployeeListAsString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<UUID, Employee> entry : employees.entrySet())
			{
			stringBuilder.append(entry.getValue().toString() + "\n");
			}
		return stringBuilder.toString();
		}

	public ArrayList<Patient> getPatientList()
		{
		Collection<Patient> mapValues = patients.values();
		ArrayList<Patient> patientList = new ArrayList<Patient>(mapValues);
		return (patientList);
		}

	public String getPatientListAsString()
		{
		StringBuilder stringBuilder = new StringBuilder();
		for (Map.Entry<UUID, Patient> entry : patients.entrySet())
			{
			stringBuilder.append(entry.getValue().toString() + "\n");
			}
		return stringBuilder.toString();
		}

	public String toString()
		{
		return "-----Employees------\n" + getEmployeeListAsString() + "\n-----Patients------\n" + getPatientListAsString();
		}
}
