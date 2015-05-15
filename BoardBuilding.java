package castorcity;

import java.util.Iterator;
import java.util.LinkedList;


public class BoardBuilding {

	
	public int width;
	public int height;
	protected Building[][] boardBuilding;
	public int[][] buildingType; // tableau renseignant sur la nature des constructions
	// 0 : empty
	// 1 : residential area
	// 2 : industrial area
	public LinkedList<Inhabitant> housePopulation;
	
	
	// constructor
	public BoardBuilding(int width, int height) {
		
		housePopulation = new LinkedList<Inhabitant>();
		this.width = width;
		this.height = height;
		
		boardBuilding = new Building[width][height];
		
		// initialisation du tableau buildingType avec des cases vides
		buildingType = new int[width][height];
		for(int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				buildingType[i][j] = 0;
			}
		}
	}
	
	
	
	/**
	 * destroy the house
	 * modify the array of buildings and the array of types of buildings
	 * remove the inhabitants from the list "housePopulation"
	 * @param x the x-coordinate of the house
	 * @param y the y-coordinate of the house
	 */
	public void HouseDestruction(int x, int y) {
		boardBuilding[x][y] = null;
		buildingType[x][y] = 0;
		
		/*
		Iterator i = housePopulation.iterator();
		while (i.hasNext()) {
			if ( i.next().xHouse == x ) {
				// méthode qui supprime les habitants de la liste des habitants ERREUR
			}
		}
		
		
		// REMOVE THE INHABITANTS
		 
		 */
	}
	
	public void IndustrialDestruction(int x, int y) {
		
		/*
		Iterator i = boardBuilding[x][y].getListCurPeople().iterator();
		while (i.hasNext()) {
			i.next().isWorking = 0;
			i.next().xWork = -1;
			i.next().yWork = -1;
		}
		
		// REMOVE THE WORK FROM THE INHABITANTS
		*/
				
		
		boardBuilding[x][y] = null;
		buildingType[x][y] = 0;
		
		
	}
	
	/**
	 * create a new house
	 * modify the array of buildings and the array of types of buildings
	 * create 10 inhabitants living in the house
	 * copy these 10 inhabitants into the list "housePopulation" in "boardBuilding"
	 * @param x the x-coordinate of the house
	 * @param y the y-coordinate of the house
	 */
	public void HouseConstruction (int x, int y) {
		boardBuilding[x][y] = new ResidentialArea(x,y);
		buildingType[x][y] = 1; 
		
		for(int i=0; i<boardBuilding[x][y].listCurPeople.size(); i++) {
			housePopulation.add(boardBuilding[x][y].listCurPeople.get(i));
		}
		
	}
	
	
	/**
	 * modify the array of buildings when a new industrial area is build
	 * @param x the x-coordinate of the industrial area
	 * @param y the y-coordinate of the industrial area
	 */
	public void IndustrialConstruction (int x, int y) {
		boardBuilding[x][y] = new IndustrialArea(x,y);
		buildingType[x][y] = 2; 
	}
	
	/**
	 * getter of the construction of the (x,y) coordinate
	 * @param x the x-coordinate of the array
	 * @param y the y-coordinate of the array
	 * @return the sell of the array (x,y)
	 */
	public Building getBuilding (int x, int y) {
		return boardBuilding[x][y];
	}
	
	/**
	 * getter of the LinkedList "housePopulation"
	 */
	public LinkedList<Inhabitant> getPopulation() {
		return this.housePopulation;
	}
	
	
	public int indX2pxX (int i) {	// ATTENTION TAILLE DES IMAGES : 50*50px (constructions), 20px (roads) (can be changed)
		return (i * (50 + 20)) + 20; 
	}
	
	
	public int indY2pxY (int i) {	// ATTENTION TAILLE DES IMAGES : 50*50px (constructions), 20px (roads) (can be changed)
		return (i * (50 + 20)) + 20; 
	}
	
	public int pxX2indX (int i) {
		return (int) i / 70 ;
	}
	
	public int pxY2indY (int i) {
		return (int) i / 70 ;
	}
	
	/**
	 * getter of "boardBuilding"
	 */
	public Building[][] getBoard() {
		return this.boardBuilding;
	}
	
	/**
	 * return the type of the building of the case (i,j)
	 * @param i x-coordinate of a construction in the table of constructions
	 * @param j y-coordinate of a construction in the table of constructions
	 */
	public int BuildingType(int i, int j) {
		int t = buildingType[i][j];
		return t;
	}
	
	/**
	 * getter of the width of the table of constructions
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * getter of the height of the table of constructions
	 */
	public int getHeight() {
		return height;
	}
	
}