
public class Fly {
	private double mass;
	private double speed;
	
	// Constructors
	Fly(double m, double s){
		mass = m;
		speed = s;
	}
	
	Fly(){
		mass = 5.0;
		speed = 10.0;
	}
	
	Fly(double m){
		mass = m;
		speed = 10;
	}
	
	//Setter
	public void setMass(double m) {
		this.mass = m;
	}
	public void setSpeed(double s) {
		this.speed = s;
	}
	
	//Getter
	public double getMass() {
		return mass;
	}
	public double getSpeed() {
		return speed;
	}
	
	//to String
	public String toString() {
		if (mass == 0) 
			return("I’m dead, but I used to be a fly with a speed of " + speed + ".");
		else return("I’m a speedy fly with "+ speed + " speed and " + mass + "mass.");
	}
	//grow method
	public void grow (int m) {
			for (int i=1; i<=m; i++) {
				if (mass+i<=20) speed++;
						else speed = speed-0.5;
			}
		mass = mass + m;
	}
	//isDead
		public boolean isDead() {
			if (mass==0) return true; 
			else return false;
		}
}
