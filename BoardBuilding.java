
public class BoardBuilding {

	protected Building[][] boardBuilding;
	
	
	// constructor
	public BoardBuilding(int width, int height) {
		
		boardBuilding = new Building[width][height];
	}
	
	// getter of the tableau de building
	public Building[][] getBoard() {
		return this.boardBuilding;
	}
	
}
