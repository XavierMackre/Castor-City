/* create a 2D array that will mange the position of each object. The parametres is the number of cell the player wishes*/;

public class City {
    // define array here
    Building[][] tab;
    

    public void City ( int height, int length){
    

    /* a road (1 cell) + 3 cells for each building+ the road at the other side*/;
    int real_lenght=length*4+1;
    int real_height=height*4+1;
    tab = new Building [real_lenght][real_height];
    //*remplir les lignes de routes;
    for(int i=0; i<real_height; i+4){
        for(int j=0; j<real_lenght; j++){
            grid[j][i]= Road;
        }
    }
    for(int k=0; i<real_lenght; i+4){
        for(int l=0; j<real_height; j++){
            grid[j][i]= Road;
    
        }
    }
   
}

}