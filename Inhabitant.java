import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Inhabitant {
    
	public String name;
	public Image img;
    public int workingHour;
    public int workingMinute;
    public int favouriteWork;  // 0:industrial, 1:office
    protected int satisfaction; // from 0:unhappy to 4:happy
    
    
    // constructor
    public Inhabitant(String name) {
        
    	this.name = name;
    	this.satisfaction = 2;
    	
    	// random image
    	// ATTENTION : ici le fichier s'appelle faceX.jpg, avec X entier de 0 à 9
    	int i = (int) (10* Math.random());
    	try {
    		img = ImageIO.read(new File("face"+i+".jpg")); // à tester
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
        // random favourite work: 0 or 1
        favouriteWork = (int) (2 * Math.random());
        
        // random working hours
        Random r = new Random();
        double workingTime = 7 + r.nextGaussian();
        workingHour = (int) workingTime;
        double minute = ( workingTime - workingHour ) * 60;
        workingMinute = (int) minute;
    }
    
    
    /**
     * getter of satisfaction
     * @return the satisfaction of the inhabitant (int)
     */
    public int getSatisfaction() {
    	return this.satisfaction;
    }
    
    
}