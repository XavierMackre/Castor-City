package miniproject;

public class BoardRoad {
    Road[][] BoardRoad;
    int x;
    int y;

    
    public BoardRoad(int x,int y){
        Road[][] myBoardRoad = new Road[x][y];
        
        for(int i=0;i<x;i++){
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
        }
    
    
}
