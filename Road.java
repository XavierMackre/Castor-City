package castorcity;

public class Road {
    
    int x;
    int y;
    int carNumber=0;
    // time a car arriving on  this cell will have to wait before going on
    int delay=0;
    
    
    public Road(int x,int y){
        x=this.x;
        y=this.y;
    }
    public int jam(boolean enter){
        if(enter==true){
            this.carNumber= this.carNumber+1;
        }
        else{
            this.carNumber= this.carNumber-1;
        }
        this.delay=(int)this.carNumber/5;
        return delay;
    }
}
