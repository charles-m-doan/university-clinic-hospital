package uch.application;

import java.util.ArrayList;
import java.util.Scanner;

import uch.identities.Doctor;
import uch.identities.Janitor;
import uch.identities.Nurse;
import uch.identities.Patient;
import uch.identities.Receptionist;
import uch.models.Employee;
import uch.models.HospitalProgram;
import uch.models.Identity;

public class AppInterface {

	private static final String NEWLINE = System.getProperty("line.separator");
	private static final String[] MAIN_MENU_OPTIONS = { "Pass Time", "Hire Employee", "Fire Employee", "Pay Employee", "Task Employee", "Admit Patient", "Discharge Patient", "Quit" };
	private static final String[] EMPLOYEE_TYPE_MENU_OPTIONS = { "Doctor", "Nurse", "Janitor", "Receptionist" };

// INSTANCE VARIABLES
	private Scanner input;
	private HospitalProgram hp;
	private boolean continueRunning;

	public AppInterface(HospitalProgram hp)
		{
		super();
		this.hp = hp;
		input = new Scanner(System.in);
		continueRunning = false;
		}

	public void startAppInterface()
		{
		continueRunning = true;
		MenuDialogue mainMD = new MenuDialogue(MAIN_MENU_OPTIONS);
		while (continueRunning == true)
			{
			try
				{
				TextTable employeeTable = new TextTable(hp.getEmployeeIdentities());
				System.out.println(NEWLINE + "Hospital Clinic Employees");
				System.out.println(employeeTable);

				TextTable patientTable = new TextTable(hp.getPatientIdentities());
				System.out.println("Patients");
				System.out.println(patientTable);
				}
			catch (Exception ex)
				{
				System.out.println(ex.getMessage());
				}
			mainMD.reset();
			mainMD.showDialogue();
			if (mainMD.commandIsValid())
				{
				try
					{
					branchMainCommandChoices(mainMD.getCommand());
					}
				catch (NumberFormatException nfex)
					{
					System.out.println("Invalid Command: \"" + mainMD.getUserInput() + "\"");
					}
				catch (Exception ex)
					{
					if (ex.getMessage() != null)
						{
						System.out.println(ex.getMessage());
						}
					}
				}
			}
		input.close();
		System.out.println("Bye!");
		System.exit(0);
		}

	private void branchMainCommandChoices(int command) throws Exception
		{
		System.out.println("You chose: \"" + MAIN_MENU_OPTIONS[command] + "\"");
		switch (command)
			{
			case 0:
				tickProgram();
				break;
			case 1:
				hireEmployee();
				break;
			case 2:
				fireEmployee();
				break;
			case 3:
				payEmployee();
				break;
			case 4:
				taskEmployee();
				break;
			case 5:
				admitPatient();
				break;
			case 6:
				dischargePatient();
				break;
			case 7:
				continueRunning = false;
				break;
			default:
				throw new Exception("Invalid command. Please enter only numbers corresponding to options in the menu.");
			}
		}

	private void tickProgram() throws Exception
		{
		System.out.println("Pass time not yet implemented.");
		}

	private void hireEmployee() throws Exception
		{
		MenuDialogue employeeTypeMD = new MenuDialogue("What is the new employee's job title?", EMPLOYEE_TYPE_MENU_OPTIONS);
		employeeTypeMD.showDialogue();
		if (employeeTypeMD.commandIsValid())
			{
			try
				{
				String employeeName = "";
				int command = employeeTypeMD.getCommand();
				switch (command)
					{
					case 0:
						employeeName = promptUserInput("What is this " + EMPLOYEE_TYPE_MENU_OPTIONS[command] + "'s name? :");
						Employee employee = new Doctor(employeeName);
						hp.addEmployee(employee);
						System.out.println("You hired a " + employee.getJobTitle() + " named \"" + employeeName + "\".");
						break;
					case 1:
						employeeName = promptUserInput("What is this " + EMPLOYEE_TYPE_MENU_OPTIONS[command] + "'s name? :");
						hp.addEmployee(new Nurse(employeeName));
						System.out.println("You hired a " + EMPLOYEE_TYPE_MENU_OPTIONS[command] + " named \"" + employeeName + "\".");
						break;
					case 2:
						employeeName = promptUserInput("What is this " + EMPLOYEE_TYPE_MENU_OPTIONS[command] + "'s name? :");
						hp.addEmployee(new Janitor(employeeName));
						System.out.println("You hired a " + EMPLOYEE_TYPE_MENU_OPTIONS[command] + " named \"" + employeeName + "\".");
						break;
					case 3:
						employeeName = promptUserInput("What is this " + EMPLOYEE_TYPE_MENU_OPTIONS[command] + "'s name? :");
						hp.addEmployee(new Receptionist(employeeName));
						System.out.println("You hired a " + EMPLOYEE_TYPE_MENU_OPTIONS[command] + " named \"" + employeeName + "\".");
						break;
					default:
					}
				}
			catch (NumberFormatException nfex)
				{
				System.out.println("Invalid Command");
				}
			catch (Exception ex)
				{
				System.out.println(ex.getMessage());
				}
			}
		}

	private void fireEmployee() throws Exception
		{
		String name = promptUserInput("Enter the name of an employee to fire: ");
		ArrayList<Employee> matches = hp.findAllEmployeesWithSubName(name);
		if (matches.isEmpty())
			{
			throw new Exception("No employees matching \"" + name + "\" were found.");
			}
		else if (matches.size() == 1)
			{
			Employee employee = matches.get(0);
			hp.removeIdentity(employee);
			System.out.println("\"" + employee.getName() + "\" has been fired.");
			}
		else
			{
			System.out.println("Multiple matches for \"" + name + "\" were found.");
			ArrayList<String> names = HospitalProgram.convertIdentitiesToNames(new ArrayList<Identity>(matches));
			MenuDialogue employeeMD = new MenuDialogue("Multiple matches for \"" + name + "\" were found. Please select one.", names);
			employeeMD.showDialogue();
			int command = employeeMD.getCommand();
			Employee employee = matches.get(command);
			hp.removeIdentity(employee);
			System.out.println("\"" + employee.getName() + "\" has been fired.");
			}
		}

	private void payEmployee() throws Exception
		{
		String name = promptUserInput("Enter the name of an employee to pay: ");
		ArrayList<Employee> matches = hp.findAllEmployeesWithSubName(name);
		if (matches.isEmpty())
			{
			throw new Exception("No employees matching \"" + name + "\" were found.");
			}
		else if (matches.size() == 1)
			{
			Employee employee = matches.get(0);
			hp.payEmployee(employee.getId());
			}
		else
			{
			System.out.println("Multiple matches for \"" + name + "\" were found.");
			ArrayList<String> names = HospitalProgram.convertIdentitiesToNames(new ArrayList<Identity>(matches));
			MenuDialogue employeeMD = new MenuDialogue("Multiple matches for \"" + name + "\" were found. Please select one.", names);
			employeeMD.showDialogue();
			int command = employeeMD.getCommand();
			Employee employee = matches.get(command);
			hp.payEmployee(employee.getId());
			}
		}

	private void taskEmployee() throws Exception
		{
		System.out.println("Task employee not yet implemented.");
		}

	private void admitPatient() throws Exception
		{
		String patientName = promptUserInput("What is the patient's full name? :");
		Patient patient = new Patient(patientName);
		hp.addPatient(patient);
		System.out.println("\"" + patient.getName() + "\" was admitted to the hospital.");
		}

	private void dischargePatient() throws Exception
		{
		String name = promptUserInput("Enter the name of a patient to discharge: ");
		ArrayList<Patient> matches = hp.findAllPatientsWithSubName(name);
		if (matches.isEmpty())
			{
			throw new Exception("No patients matching \"" + name + "\" were found.");
			}
		else if (matches.size() == 1)
			{
			Patient patient = matches.get(0);
			hp.removeIdentity(patient);
			System.out.println("\"" + patient.getName() + "\" has been discharged.");
			}
		else
			{
			System.out.println("Multiple matches for \"" + name + "\" were found.");
			ArrayList<String> names = HospitalProgram.convertIdentitiesToNames(new ArrayList<Identity>(matches));
			MenuDialogue patientMD = new MenuDialogue("Multiple matches for \"" + name + "\" were found. Please select one.", names);
			patientMD.showDialogue();
			int command = patientMD.getCommand();
			Patient patient = matches.get(command);
			hp.removeIdentity(patient);
			System.out.println("\"" + patient.getName() + "\" has been discharged.");
			}
		}

	private String promptUserInput(String prompt)
		{
		System.out.print(prompt);
		String userInput = input.nextLine();
		return userInput;
		}

}
