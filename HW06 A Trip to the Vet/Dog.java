
public class Dog extends Pet{
	private double droolRate;

	//constructor
	public Dog(String name, double health, int painLevel, double droolRate) {
		super(name, health, painLevel);
		if (droolRate<=0) droolRate=0.5; else this.droolRate=droolRate;
	}
	
	public Dog(String name, double health, int painLevel) {
		super(name, health, painLevel);
		this.droolRate=5.0;
	}
	
	//getter
	public double getDroolRate() {
        return this.droolRate;
    }
	
	//methods overload
	public int treat() {
		this.heal();
		int painLevel = this.getPainLevel();
		double health = this.getHealth();
		double droolRate = this.getDroolRate();
		if(droolRate<3.5) return (int)((painLevel*2)/health);
		else if(droolRate>7.5) return (int)(painLevel/(health*2));
		else return (int)(painLevel/health);
	}
	
	public void speak() {
		super.speak();
		int painLevel = this.getPainLevel();
		for (int i=0; i<painLevel; i++) {
			if (painLevel>5) System.out.print("BARK ");
			else System.out.print("bark ");
		}
	}
	
	public boolean equals(Object o) {
		if (o instanceof Dog)
	        return super.equals(o) && this.droolRate == ((Dog) o).getDroolRate();
		return false;
	}
	
	
}
