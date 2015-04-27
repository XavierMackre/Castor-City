public class BoardRoad {
	
    Road[][] BoardRoad;
    int x; // largeur du tableau de routes
    int y; // hauteur du tableau de routes

    
    public BoardRoad (int x, int y) { // x = width (largeur du tableau de constructions) * 2 + 1
    	
        Road[][] myBoardRoad = new Road[x][y];
        
        for(int i=0; i<x; i++){
            if(i%2==0){
                for(int l=0;l<y;l++){
                    myBoardRoad[i][l]=Road(i,l);
                    
                    }}
                else{
                    for(int l=0;l<y;l+2){
                        myBoardRoad[i][l]=Road(i,l);
                        
                        }
                    }
                }
            }
        
    /**
     * gives the pixel along x where is placed the road
     * @param i position along x in the road array
     * @return pixel along x where is placed the road
     */
	public int indX2pxX (int i) {
		if ( i%2 == 0) {
			return i * (50 + 20);
		} else {
			return 20 + i * (50 + 20);
		}
	}
	
	
	/**
	 * gives the pixel along y where is placed the road
	 * @param i position along y in the road array
	 * @return pixel along y where is placed the road
	 */
	public int indY2pxY (int i) {
		if ( i%2 == 0) {
			return i * (50 + 20);
		} else {
			return 20 + i * (50 + 20);
		}
	}

    
}
