package uch.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import uch.identities.Doctor;
import uch.identities.Nurse;
import uch.identities.Patient;

public class HospitalProgram {
	private HashMap<UUID, Employee> employees;
	private HashMap<UUID, Patient> patients;

	public HospitalProgram()
		{
		employees = new HashMap<UUID, Employee>();
		patients = new HashMap<UUID, Patient>();
		}

	public void tickAllPatientsAndEmployees()
		{
		Collection<Patient> patientsToTick = patients.values();
		for (Patient patient : patientsToTick)
			{
			patient.tick();
			}
		Collection<Employee> employeesToTick = employees.values();
		for (Employee employee : employeesToTick)
			{
			employee.tick();
			}
		}

	public void addEmployee(Employee employee)
		{
		this.employees.put(employee.getId(), employee);
		}

	public void addPatient(Patient patient)
		{
		this.patients.put(patient.getId(), patient);
		}

	public void payEmployee(UUID employeeID) throws Exception
		{
		Employee employee = employees.get(employeeID);
		if (employee != null)
			{
			employee.paySalary();
			}
		}

	public void removeIdentity(Identity identity)
		{
		if (identity instanceof Employee)
			{
			employees.remove(identity.getId());
			}
		else if (identity instanceof Patient)
			{
			patients.remove(identity.getId());
			}
		}

	public Employee getEmployee(UUID id)
		{
		return employees.get(id);
		}

	public Patient getPatient(UUID id)
		{
		return patients.get(id);
		}

	public ArrayList<Employee> getAllMedicalEmployees()
		{
		ArrayList<Employee> matchingEmployees = new ArrayList<Employee>();
		for (Map.Entry<UUID, Employee> entry : employees.entrySet())
			{
			Employee employee = entry.getValue();
			if (employee instanceof Doctor || employee instanceof Nurse)
				{
				matchingEmployees.add(employee);
				}
			}
		return matchingEmployees;
		}

	public ArrayList<Employee> findAllEmployeesWithSubName(String subName)
		{
		subName = subName.toLowerCase();
		ArrayList<Employee> matchingEmployees = new ArrayList<Employee>();
		for (Map.Entry<UUID, Employee> entry : employees.entrySet())
			{
			Employee employee = entry.getValue();
			if (employee.getName().toLowerCase().contains(subName))
				{
				matchingEmployees.add(employee);
				}
			}
		return matchingEmployees;
		}

	public ArrayList<Patient> findAllPatientsWithSubName(String subName)
		{
		ArrayList<Patient> matchingPatients = new ArrayList<Patient>();
		for (Map.Entry<UUID, Patient> entry : patients.entrySet())
			{
			Patient patient = entry.getValue();
			if (patient.getName().contains(subName))
				{
				matchingPatients.add(patient);
				}
			}
		return matchingPatients;
		}

	public static ArrayList<String> convertIdentitiesToNames(ArrayList<Identity> identities)
		{
		ArrayList<String> names = new ArrayList<String>();
		for (Identity identity : identities)
			{
			names.add(identity.getName());
			}
		return names;
		}

	public ArrayList<String> getPatientNames()
		{
		return convertIdentitiesToNames(new ArrayList<Identity>(patients.values()));
		}

	public ArrayList<String> getEmployeeNames()
		{
		return convertIdentitiesToNames(new ArrayList<Identity>(employees.values()));
		}

	public ArrayList<Identity> getEmployeeIdentities()
		{
		ArrayList<Identity> employeeTableList = new ArrayList<Identity>(employees.values());
		return employeeTableList;
		}

	public ArrayList<Identity> getPatientIdentities()
		{
		ArrayList<Identity> patientTableList = new ArrayList<Identity>(patients.values());
		return patientTableList;
		}

	public ArrayList<Employee> getEmployees()
		{
		return new ArrayList<Employee>(employees.values());
		}

	public ArrayList<Patient> getPatients()
		{
		return new ArrayList<Patient>(patients.values());
		}

}
