import java.util.LinkedList;

import javax.swing.Timer;
import java.util.random;

public class GameBis {
	
	protected int width; // width of the map (number of building boxes)
	protected int height; // height of the map (number of building boxes)
	public LinkedList<Inhabitant> population; // contains all the inhabitants
	public double averageSatisfaction; // satisfaction of all the population
	public BoardRoad boardRoad;
	public BoardBuilding boardBuilding;
	public Window window;
	Random randomGenerator = new Random();
	
	// constructor: initialization of the game
	public GameBis() { 	
		
		// initialization of the size of the game
		this.width = 12;
		this.height = 12;
		
		// initialization of the boards of roads and constructions
		boardRoad = new BoardRoad(); 	/* quels paramètres ?*/
		boardBuilding = new BoardBuilding(width, height);
		
		// initialization of 50 inhabitants ready to moving in at the beginning of the game
		for (int i=0 ; i<50 ; i++) {
			population.add(new Inhabitant("Inhabitant"+i));
		}
		
		// display of the game
		window = new Window();
		
	}

	
	public static void main(String[] args) {
		
		GameBis game = new GameBis();
    }

	
	/**
	 * getter of width
	 * @return the width of the city
	 */
	public int getWidth() {
		return this.width;
	}
	
	
	/**
	 * getter of height
	 * @return the height of the city
	 */
	public int getHeight() {
		return this.height;
	}
	
	public BoardBuilding getBoardBuilding() {
		return this.boardBuilding;
	}
	
	
	/**
	 * compute the average satisfaction of the whole population
	 * @param LinkedList<Inhabitant> population
	 * @return the average satisfaction (double)
	 */
	public double ComputeSatisfaction (LinkedList<Inhabitant> population) {
		int s = 0;
		for(int i =0; i < population.size(); i++) {
			s = s + population.get(i).getSatisfaction();
		}
		return s/(population.size());
	}
	
}
