
public class BoardBuilding {

	public int width;
	public int height;
	protected Building[][] boardBuilding;
	public int[][] buildingType; // tableau renseignant sur la nature des constructions
	// 0 : empty
	// 1 : residential area
	// 2 : industrial area
	
	
	// constructor
	public BoardBuilding(int width, int height) {
		
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
	
	// getter of the tableau de building
	public Building[][] getBoard() {
		return this.boardBuilding;
	}
	
	public int BuildingType(int i, int j) {
		int t = buildingType[i][j];
		return t;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
