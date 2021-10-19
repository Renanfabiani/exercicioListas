package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entities.Employee;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.println("How many employees wiil be registered? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Employy # " + (i + 1) + " : ");// colocando i + 1 porque i começa com 0
			System.out.println("Id: ");
			Integer id = sc.nextInt();
			System.out.println("Name: ");
			sc.nextLine();// para limpar o buffer de entrada
			String name = sc.nextLine();
			System.out.println("Salary: ");
			Double salary = sc.nextDouble();

			Employee emp = new Employee(id, name, salary);

			list.add(emp);
		}

		System.out.println();
		System.out.println("Enter the employee id that will have salary increase: ");
		int idsalary = sc.nextInt();
		
		
		Integer pos = position(list, idsalary);
		if (pos == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}

		System.out.println();
		System.out.println("List of employees:");
		for (Employee emp : list) {// para cada employee emp na minha lista
			System.out.println(emp);
		}

		sc.close();
	}

	public static Integer position(List<Employee> list, int id) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {// se o elemento na função i for igual ao id que forneci no argumento, então
				return i;
			}
		}
		return null;
	}

}
