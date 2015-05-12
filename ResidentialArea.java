import java.util.LinkedList;


public class ResidentialArea extends Building {

	// constructor
	public ResidentialArea (int x, int y) {
		
		super(x, y); // appel du constructeur de la classe mere "Building"
		
		this.listCurPeople = new LinkedList<Inhabitant>(); // instanciation de 10 personnes dans la maison
		for (int i=0 ; i<10 ; i++) {
			this.listCurPeople.add(new Inhabitant(x,y));
		}
	}
	
}
