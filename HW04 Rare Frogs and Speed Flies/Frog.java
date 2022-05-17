public class Frog {
	//variables
	private String name;
	private int age;
	private double tongueSpeed;
	private boolean isFroglet;
	//A Frog is a froglet if it is >=1 month old but <7 months old. 
	private static String species = "Rare Pepe";
	
	//constructor 1 - name, age, tongueSpeed
	Frog(String name, int age, double tongueSpeed){
		this.name = name;
		this.age = age;
		this.tongueSpeed = tongueSpeed;
		if (age>=1 && age<7) 
			isFroglet = true;
		else isFroglet = false;
	}
	//constructor 2 - name, ageInYears, tongueSpeed
	Frog(String name, double ageInYears, double tongueSpeed){
		this.name = name;
		this.age = (int)ageInYears*12;
		this.tongueSpeed = tongueSpeed;
		if (age>=1 && age<7) 
			isFroglet = true;
		else isFroglet = false;
	}
	//constructor 3 - name only, age = 5, tongueSpeed = 5
	Frog(String name){
		this.name = name;
		age = 5;
		tongueSpeed = 5;
		isFroglet = true;
	}
	//grow - takes in a whole number parameter representing the number of months.
	public void grow(int months) {
		for (int i = 1; i<=months; i++) {
			if (age+i<=12) {
				tongueSpeed++;
			}
			else if ((age+i>30)&&(tongueSpeed>=6)) {
				tongueSpeed--;
			}
		}
		age = age + months;
		if (age>=1 && age<7) 
			isFroglet = true;
		else isFroglet = false;
	}
	
	//grow - takes in no params - age by 1 month
	public void grow() {
		age++;
		if (age<=12) {
			tongueSpeed++;
		}
		else if (age>=30) {
			tongueSpeed--;
		}
	//froglet check
		if (age>=1 && age<7) 
			isFroglet = true;
		else isFroglet = false;
	}

	//eat method
	public void eat(Fly fly) {
		if(!fly.isDead()) {
		if (tongueSpeed>fly.getSpeed()) {
			if (fly.getMass()>= 0.5*age)
				grow();
			fly.setMass(0);
			}
			else {
				fly.grow(1);
			}
		}	
	}
	
	//toString method
	public String toString() {
		if (isFroglet)
			return("My name is %s and I知 a rare froglet! I知 %d months old and my tongue has a speed of %.2f.", name, age, tongueSpeed);
		//return("My name is " + name + " and I知 a rare froglet! I知 " + age + " months old and my tongue has a speed of " + tongueSpeed + ".");
		else return("My name is " + name + " and I知 a rare frog. I知 "+ age + " months old and my tongue has a speed of " + tongueSpeed + ".");
	}
	
	
	
	
	//setter
	public void setSpecies(String s) {
		species = s;
	}
	//getter
	public String getSpecies() {
		return species;
	}
}
