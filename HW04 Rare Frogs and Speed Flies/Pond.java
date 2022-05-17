
public class Pond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Frog Peepo = new Frog("Peepo");
	Frog Pepe = new Frog("Pepe, 10, 15");
	Frog Peepaw = new Frog("Peepaw, 4.6, 5");
	Frog Alan = new Frog("Alan");
	Fly Fly1 = new Fly(1,3);
	Fly Fly2 = new Fly(6);
	Fly Nik = new Fly();
	
	Pepe.setSpecies("1331 Frogs");
	System.out.printf(Peepo.toString());
	Peepo.eat(Fly2);
	System.out.println(Fly2.toString()); 
	Peepo.grow(8);
	Peepo.eat(Fly2);
	System.out.println(Fly2.toString());
	System.out.println(Peepo.toString());
	System.out.println(Alan.toString());
	Peepaw.grow(4);
	System.out.println(Peepaw.toString());
	System.out.println(Pepe.toString());
	}

}
