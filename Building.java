import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

public class Building {
    
	public Image img;
    public int x; // coordinate x of the building
    public int y; // coordinate y of the building
	public int maxPeople; // maximum number of people living-working here
	public int curPeople; // current number of people living-working here
	public LinkedList<Inhabitant> listCurPeople; // list of people living-working here
	public double averageSatisfaction; // from 0:unhappy to 4:happy
	
	// constructor
	public Building (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * compute the average satisfaction of people living-working in the building
	 * @return the average satisfaction (double)
	 */
	public double ComputeSatisfaction () {
		int s = 0;
		for(int i =0; i < this.listCurPeople.size(); i++) {
			s = s + this.listCurPeople.get(i).getSatisfaction();
		}
		return s/(this.listCurPeople.size());
	}
	
	/**
	 * gives the number of inhabitants/people working in the building
	 */
	public int NumberInhabitants() {
		return listCurPeople.size();
	}
	
	/**
	 * getter of the list of inhabitants/workers in this building
	 */
	public LinkedList<Inhabitant> getListCurPeople() {
		return listCurPeople;
	}
	

		
}
