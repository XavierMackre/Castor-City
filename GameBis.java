import java.util.LinkedList;
import java.util.Random;

import javax.swing.Timer;

public class GameBis {
	
	// dimensions
	protected int width; // width of the building board (number of building in each )
	protected int height; // height of the building board (number of building boxes)
	public int widthRoad; // width of the road board
	public int heightRoad; // height of the road board
	public int pxWidth; // number of pixels of the map (width)
	public int pxHeight; // number of pixels of the map (height)
	
	public LinkedList<Inhabitant> population; // contains all the inhabitants
	public double averageSatisfaction; // satisfaction of all the population
	public BoardRoad boardRoad;
	public BoardBuilding boardBuilding;
	public Window window;
	Random randomGenerator = new Random();
	
	// constructor: initialization of the game
	public GameBis() { 	
		
		// initialization of the size of the game
		this.width = 12; // ATTENTION : dimensions of the map (can be changed)
		this.height = 12;
		this.widthRoad = width * 2 + 1;
		this.heightRoad = height * 2 + 1;
		this.pxWidth = (width * 50) + ((width + 1) * 20); // ATTENTION TAILLE DES IMAGES : 50*50px (constructions), 20px (roads) (can be changed)
		this.pxHeight = (width * 50) + ((width + 1) * 20);
		
		// initialization of the boards of roads and constructions
		boardRoad = new BoardRoad(widthRoad, heightRoad); 
		boardBuilding = new BoardBuilding(width, height);
		
		/*
		// initialization of 50 inhabitants ready to moving in at the beginning of the game
		for (int i=0 ; i<50 ; i++) {
			population.add(new Inhabitant("Inhabitant"+i));
		}
		*/
		
		// display of the game
		window = new Window(pxWidth, pxHeight, boardBuilding, boardRoad);
		
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
