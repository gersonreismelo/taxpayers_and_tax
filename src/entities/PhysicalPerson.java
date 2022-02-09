package entities;

public class PhysicalPerson extends Person {
	private Double healthExpenditures;
	
	public PhysicalPerson() {
		super();
	}

	public PhysicalPerson(String name, Double annualIncome, Double healthExpenditures) {
		super(name, annualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		if(getAnnualIncome() < 20000.00) {
		   return getAnnualIncome() * 0.15 - healthExpenditures * 0.50;
		} else {
		   return getAnnualIncome() * 0.25 - healthExpenditures * 0.50;
		}
	}
}
