import java.awt.Image;
import java.awt.Point;
import java.util.LinkedList;

public class Building {
    
	public Image img;
    public Point location; // coordinates (x,y); coordinate x: double getX(); coordinate y: double getY();
	public int maxPeople; // maximum number of people living-working here
	public int curPeople; // current number of people living-working here
	public LinkedList<Inhabitant> listCurPeople; // list of people living-working here
	public double averageSatisfaction; // from 0:unhappy to 4:happy
	
	
	/**
	 * compute the average satisfaction of people living-working in the building
	 * @param LinkedList<Inhabitant> listCurPeople
	 * @return the average satisfaction (double)
	 */
	public double ComputeSatisfaction (LinkedList<Inhabitant> listCurPeople) {
		int s = 0;
		for(int i =0; i < listCurPeople.size(); i++) {
			s = s + listCurPeople.get(i).getSatisfaction();
		}
		return s/(listCurPeople.size());
	}

		
}
