import java.util.Random;

public class Inhabitant {
    
    int workingHour;
    int workingMinute;
    int favouriteWork;  // 0:industrial, 1:office
    
    // constructor
    public Inhabitant() {
        
        // random favourite work: 0 or 1
        favouriteWork = (int) (2 * Math.random());
        
        // random working hours
        Random r = new Random();
        double workingTime = 7 + r.nextGaussian();
        workingHour = (int) workingTime;
        double minute = ( workingTime - workingHour ) * 60;
        workingMinute = (int) minute;
    }
    
    
}
