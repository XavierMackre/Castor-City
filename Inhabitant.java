package castorcity;
import castorcity.Road;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Inhabitant {
    
	public String name; // utile?
	public Image img; // utile?
    public int workingHour;
    public int workingMinute;
    public int favouriteWork;  // 1:industrial, 2:office
    protected int satisfaction; // from 0:unhappy to 4:happy
    public int isWorking; // 0: unemployed, 1: industrial, 2: office
    public int xHouse; // coordinates of the place where this inhabitant lives (in the array of buildings)
    public int yHouse; // coordinates of the place where this inhabitant lives (in the array of buildings)
    public int xWork; // coordinates of the place where this inhabitant works (in the array of buildings)
    	// if the inhabitant does NOT work, set -1
    public int yWork; // coordinates of the place where this inhabitant works (in the array of buildings)
    	// if the inhabitant does NOT work, set -1
    	// j'ai mis -1 car si on détruit un lieu de travail on ne peut pas mettre null car c'est de type int
   
    /* the direction they will follow while moving. Xdirect an ydirect indicates
     * how far they need to move along these axis. xshift allows to move of cell
     * in the right direction*/
    int xdirect;
    int ydirect;
    int xshift;
    int yshift;
    int xLivingPlace; // ce sont bien les coordonnées de la maison dans le tableau de routes ? J'ai initialisé ces coordonées dans le constructeur
    int yLivingPlace;
    int xWorkingPlace; // je me demande si l'attribut n'est pas automatiquement initialisé à 0, dans ce cas ça poserait peut etre un problème et il faudrait l'initialiser à une valeur au hasard, par exemple -1 ?
    int yWorkingPlace;
    /*position of the Inhabitant*/
    int xInhabitantPos;
    int yInhabitantPos;
    int delay=0;
    int travelTime=0;
    
    // constructor
    public Inhabitant(int xHouse, int yHouse) { // xHouse, yHouse : position de la maison dans le tableau de constructions
    	
    	this.xHouse = xHouse;
    	this.yHouse = yHouse;
    	this.xWork = -1;
    	this.yWork = -1;
    	this.isWorking = 0;
    	// this.name = "Inhabitant_"+number;
    	this.satisfaction = 2;
    	
    	
    	this.xLivingPlace = this.xHouse * 2 + 1;
    	this.yLivingPlace = this.xHouse * 2 + 1;
    	
    	/* ERREUR
    	// random image
    	// ATTENTION : ici le fichier s'appelle faceX.jpg, avec X entier de 0 à 9
    	int i = (int) (10* Math.random());
    	try {
    		img = ImageIO.read(new File("face"+i+".jpg")); // à tester
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	*/
    	
        // random favourite work: 0 or 1
        favouriteWork = (int) (2 * Math.random() + 1);
        
        // random working hours
        Random r = new Random();
        double workingTime = 7 + r.nextGaussian();
        workingHour = (int) workingTime;
        double minute = ( workingTime - workingHour ) * 60;
        workingMinute = (int) minute;
    }
    
    
    /**
     * getter of the satisfaction of the inhabitant
     */
    public int getSatisfaction() {
    	return this.satisfaction;
    }
    
    /**
     * getter of workingHour
     */
    public int getworkingHour(){
    	return this.workingHour;
    }

    /**
     * getter of workingMinute
     */
    public int getworkingMinute(){
    	return this.workingMinute;
    }
    
    /**
     * getter of the x-coordinate of the house (in the table of constructions)
     */
    public int getxHouse() {
    	return xHouse;
    }
    
    /**
     * getter of the y-coordinate of the house (in the table of constructions)
     */
    public int getyHouse() {
    	return yHouse;
    }
    /**
     * @param aller
     */
    public void testChemin (boolean aller) {
        xdirect = xWorkingPlace-xLivingPlace; 
        ydirect = yWorkingPlace-yLivingPlace; 
        if(xdirect>0){
            xdirect=xdirect-1;
            xshift=1;
        }
        else{
            xdirect=xdirect+1;
            xshift=-1;
        }
        if(ydirect>0){
            ydirect=xdirect-1;
            yshift=1;
        }
        else{
            ydirect=xdirect+1;
            yshift=-1;
        }
        if(aller==false){
            xdirect=-xdirect;
            ydirect=-ydirect;
            xshift=-xshift;
            yshift=-yshift;
        }
    }
    public boolean MovingPath (Road[][] BoardRoad){
        this.travelTime+=5;
        // if the inhabitant is in a traffic jam hes waits 
        if(this.delay!=0){
            this.delay +=-1;
            return false;
        }
        //allows to generate random number between 0 and 1
        Random randomGenerator = new Random();
        int xShifted=xInhabitantPos+xshift;
        int yShifted=yInhabitantPos+yshift;
        boolean moved=false;//will get true when the Inhabitant will have moved

        BoardRoad[yInhabitantPos][xInhabitantPos].jam(false);
        if(xShifted<0 || xShifted>BoardRoad[0].length-1){
            yInhabitantPos+= yshift;
            ydirect+=yshift;
            moved=true;
        }
        else{
            if(BoardRoad[xShifted]==null){
                yInhabitantPos+= yshift;
                ydirect+=yshift;
                moved=true;
            }
        }
        if(moved==false){
            if((yShifted+yshift<0) || (yShifted>BoardRoad.length-1)){
                xInhabitantPos+= xshift; 
                xdirect+=xshift;
                moved=true;
            }
            else{
                if(BoardRoad[yShifted]==null){
                    xInhabitantPos+= xshift;
                    xdirect+=xshift;
                    moved=true;
                }
            }
        }
        if(moved==false){
            int randomInt = randomGenerator.nextInt(1);
            if(randomInt==1){
                xInhabitantPos+= xshift;
                xdirect+=xshift;
            }
            else{
                yInhabitantPos+= yshift;
                ydirect+=yshift;
            }
        }
        if((xdirect==0)&&(ydirect==0)){
            return true;
        }
        this.delay=BoardRoad[yInhabitantPos][xInhabitantPos].jam(true);
        return false;
       
    }
}
