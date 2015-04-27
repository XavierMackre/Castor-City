
public class BoardBuilding {

	protected Building[][] boardBuilding;
	public int[][] buildingType; // tableau renseignant sur la nature des constructions
	// 0 : empty
	// 1 : residential area
	// 2 : industrial area
	
	
	// constructor
	public BoardBuilding(int width, int height) {
		
		boardBuilding = new Building[width][height];
		
		// initialisation du tableau buildingType avec des cases vides
		for(int i=0; i<width; i++) {
			for (int j=0; j<height; j++) {
				buildingType[i][j] = 0;
			}
		}
	}
	
	
	public int indX2pxX (int i) {
		return 20 + (i * 50) + (i * 20);
	}
	
	
	public int indY2pxY (int i) {
		return 20 + i * (50 + 20);
	}
	
	// getter of the tableau de building
	public Building[][] getBoard() {
		return this.boardBuilding;
	}
	
}
