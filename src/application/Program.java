package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.Person;
import entities.PhysicalPerson;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Person> person = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int numberOfTaxPayers = sc.nextInt();
		
		for(int i = 1; i <= numberOfTaxPayers; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char choise = sc.next().charAt(0);
			while(choise != 'i' && choise != 'c') {
				System.out.println("wrong choice, try again!");
				System.out.print("Individual or company (i/c)? ");
				choise = sc.next().charAt(0);
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIcome = sc.nextDouble();
			if(choise == 'i') {
				System.out.print("Health expenditures: ");
				double health = sc.nextDouble();
				person.add(new PhysicalPerson(name, anualIcome, health));
			} else {
				System.out.print("Number of employees: ");
				int numberEmp = sc.nextInt();
				person.add(new LegalPerson(name, anualIcome, numberEmp));
			}
		}
		System.out.println("\nTAXES PAID:");
		double soum = 0;
		for(Person p: person) {
			System.out.println(p.getName() 
					+ ": $"
					+ String.format("%.2f", p.tax()));
			soum += p.tax();
		}
		System.out.println("\nTOTAL TAXES : $" + String.format("%.2f", soum));
		sc.close();
	}

}
