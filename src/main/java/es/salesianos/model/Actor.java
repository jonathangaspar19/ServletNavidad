package es.salesianos.model;

public class Actor {
	
	private int cod;
	private String name;
	private int yearOfTheBirthDate;
	
	public int getCod() {
		return cod;
	}


	public void setCod(int cod) {
		this.cod = cod;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getYearOfTheBirthDate() {
		return yearOfTheBirthDate;
	}


	public void setYearOfTheBirthDate(int yearOfTheBirthDate) {
		this.yearOfTheBirthDate = yearOfTheBirthDate;
	}
	
	@Override
	public String toString() {
		return "User [cod=" + cod + ", name=" + name + ", yearOfTheBirthDate=" + yearOfTheBirthDate + "]";
	}

	
}
