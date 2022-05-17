
public class Cat extends Pet{
	private int miceCaught;
	
	//constructor
	public Cat(String name, double health, int painLevel, int miceCaught) {
		super(name,health,painLevel);
		if (miceCaught<0) this.miceCaught=0;
	}
	
	public Cat(String name, double health, int painLevel) {
		super(name,health,painLevel);
		this.miceCaught = 0;
	}
	
	//getter
    public int getMiceCaught() {
        return this.miceCaught;
    }
    
    //methods overload
    public int treat() {
        double health = this.getHealth();
        int painLevel = this.getPainLevel();
        this.heal();
        if (this.miceCaught < 4)
            return (int) (painLevel * 2 / health);
        return this.miceCaught <= 7 ? (int) (painLevel / health) : (int) (painLevel / (health * 2));
    }
    
	public void speak() {
		super.speak();
		int painLevel = this.getPainLevel();
		for (int i=0; i<painLevel; i++) {
			if (painLevel>5) System.out.print("MEOW ");
			else System.out.print("meow ");
		}
	}
	
	  public boolean equals(Object o) {
		    if (o instanceof Cat)
		        return super.equals(o) && this.miceCaught == ((Cat) o).getMiceCaught();
		    return false;
		    }
	
    
}
