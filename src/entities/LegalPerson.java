package entities;

public class LegalPerson extends Person {
	private int numberOfEmployees;
	
	public LegalPerson() {
		super();
	}

	public LegalPerson(String name, Double annualIncome, int numberOfEmployees) {
		super(name, annualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		if(numberOfEmployees <= 10) {
			return getAnnualIncome() * 0.16;
		} else {
			return getAnnualIncome() * 0.14;
		}
	}
	
	
}
