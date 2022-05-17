public abstract class Pet {
	private String name;
	private double health;
	private int painLevel;
	
	//constructor
	public Pet(String name, double health, int painLevel) {
		if (health>1.0) this.health=1.0; else this.health=0.0;
		this.name = name;
		if (painLevel>10) 
			this.painLevel=10;
				 else if(painLevel<1) 
					 this.painLevel=1;
				 else this.painLevel = painLevel;
	}

	//getters
    public String getName() {
        return this.name;
    }

    public double getHealth() {
        return this.health;
    }

    public int getPainLevel() {
        return this.painLevel;
    }

    public abstract int treat();
    
    public void speak() {
        String s = "Hello! My name is " + this.name;
        s = this.painLevel > 5 ? s.toUpperCase() : s;
        System.out.println(s);
    }
    
    public boolean equals(Object o) {
        return o instanceof Pet && name.equals(((Pet) o).name);
    }
    
    protected void heal() {
        this.health = 1.0;
        this.painLevel = 1;
    }
	
}
