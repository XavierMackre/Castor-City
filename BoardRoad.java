package castorcity;

public class BoardRoad {
	
    public Road[][] BoardRoad;
    public int x; // largeur du tableau de routes
    public int y; // hauteur du tableau de routes

    
    public BoardRoad (int x, int y) {
    	
    	this.x = x;
    	this.y = y;
    	
        Road[][] boardRoad = new Road[x][y];
        
        
        for (int i=0; i<x; i++) { // on parcourt les colonnes
        	if (i%2==0) {
        		for(int j=0; j<y; j++) { // on parcourt les lignes
        			boardRoad[j][i] = new Road(j,i);
        		}
        	} else {
        		for (int j=0; j<y; j+=2) {
        			boardRoad[j][i] = new Road(j,i);
        		}
        	}
        }
    }
        
       
        
        /*
        for(int i=0; i<x; i++){
            if(i%2==0){
                for(int l=0;l<y;l++){
                    boardRoad[i][l]=new Road(i,l);
                    
                    }}
                else{
                    for(int l=0;l<y;l++){
                        boardRoad[i][l]=new Road(i,l);
                        
                        }
                    }
                }
            }
            */
        
    /**
     * gives the pixel along x where is placed the road
     * @param i position along x in the road array
     * @return pixel along x where is placed the road
     */
	public int indX2pxX (int i) {
		if ( i%2 == 0) {
			return i * (50 + 20) / 2;
		} else { 
			return 20 + (i - 1) * (50 + 20) / 2;
		}
	}
	
	
	/**
	 * gives the pixel along y where is placed the road
	 * @param i position along y in the road array
	 * @return pixel along y where is placed the road
	 */
	public int indY2pxY (int i) {
		if ( i%2 == 0) {
			return i * (50 + 20) / 2;
		} else {
			return 20 + (i - 1) * (50 + 20) / 2;
		}
	}
	
	/**
	 * indicates if the mouse is at the position of a road or a construction
	 * @param x the position of the x-coordinate of the mouse
	 * @param y the position of the y-coordinate of the mouse
	 * @return true if the mouse is at the position of a road, false if it is at the position of a contruction
	 */
	public boolean isRoad (int x, int y) {
		int ax = x % (50 + 20);
		int ay = y % (50 + 20);
		
		if ( ax < 20 ) {
			return true;
		} else if ( ay < 20 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public int pxX2indX (int i) {
		return (int) i / 70 ;
	}
	
	public int pxY2indY (int i) {
		return (int) i / 70 ;
	}

	
	public int getWidth() {
		return x;
	}

	public int getHeight() {
		return y;
	}
    
}