
// import java.awt.Window;
// si on importe cette chose ça empeche le fonctionnement de ma classe Window
// si c'est utile je peux changer le nom de ma classe Window pour faire marcher ça
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.LinkedList;
import java.util.Random;

import javax.swing.Timer;

public class GameBis {
	
	// dimensions
	protected int width; // width of the building board (number of building in each )
	protected int height; // height of the building board (number of building boxes)
	public int widthRoad; // width of the road board
	public int heightRoad; // height of the road board
	public int pxWidth; // number of pixels of the map (width)
	public int pxHeight; // number of pixels of the map (height)
	
	public LinkedList<Inhabitant> population; // contains all the inhabitants
	public double averageSatisfaction; // satisfaction of all the population
	public BoardRoad boardRoad;
	public BoardBuilding boardBuilding;
	public Window window;
	Random randomGenerator = new Random();
        
        Timer timer;
        int minute= 0;
        int hour=0;
        int day=1;
        int month=1;
        int year=2015;
        int[] date= {minute, hour, day, month, year};
	
	// constructor: initialization of the game
	public GameBis() { 	
		
		// initialization of the size of the game
		this.width = 12; // ATTENTION : dimensions of the map (can be changed)
		this.height = 12;
		this.widthRoad = width * 2 + 1;
		this.heightRoad = height * 2 + 1;
		this.pxWidth = (width * 50) + ((width + 1) * 20); // ATTENTION TAILLE DES IMAGES : 50*50px (constructions), 20px (roads) (can be changed)
		this.pxHeight = (width * 50) + ((width + 1) * 20);
		
		// initialization of the boards of roads and constructions
		boardRoad = new BoardRoad(widthRoad, heightRoad); 
		boardBuilding = new BoardBuilding(width, height);
		
                //initialistation du timer
		timer = new Timer (100, new TimerClass());
		timer.start();
		
		// display of the game
		window = new Window(pxWidth, pxHeight, boardBuilding, boardRoad);
		
	}

	
	public static void main(String[] args) {
		
		GameBis game = new GameBis();
    }

	
	/**
	 * getter of width (width of the city)
	 */
	public int getWidth() {
		return this.width;
	}
	
	
	/**
	 * getter of height (height of the city)
	 */
	public int getHeight() {
		return this.height;
	}
	
	
	/**
	 * getter of the boardBuilding
	 */
	public BoardBuilding getBoardBuilding() {
		return this.boardBuilding;
	}
	
	
	/** UTILE ?
	 * compute the average satisfaction of the whole population
	 * @param LinkedList<Inhabitant> population
	 * @return the average satisfaction (double)
	 */
	public double ComputeSatisfaction (LinkedList<Inhabitant> population) {
		int s = 0;
		for(int i =0; i < population.size(); i++) {
			s = s + population.get(i).getSatisfaction();
		}
		return s/(population.size());
	}
	
	
	/** UTILE QUE SI ON GARDER UN ATTRIBUT "POPULATION" DANS LA CLASSE GAME
	 * copy the population initialized in boardBuilding into Game
	 */
	public void UpdatePop() { // ATTENTION : A METTRE A JOUR AVEC LE TIMER
		this.population = boardBuilding.getPopulation();
	}

	
        //méthode pour faire avancer l'heure de 5 minutes
        public void horloge (){
            minute +=5;
            if(minute==60){
                hour++;
                minute=0;
                if(hour==24){
                    hour=0;
                    day++;
                    if(day==30){
                        day=1;
                        month++;
                        if (month==12){
                            month=1;
                            year++;
                        }
                    }
                }
            }
        }
        class TimerClass implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                horloge();

            }
        }
	
        
	/**
	     * This is the array of lists of inhabitants ordered by their time of departure*
	     * */
	public LinkedList<LinkedList<Inhabitant>> allinhabDeparture() {
	LinkedList<LinkedList<Inhabitant>> allinhabDeparture =new LinkedList<LinkedList<Inhabitant>>();
	LinkedList<Inhabitant> temp;

	for(int i=0;i<187;i++) {
		temp=new LinkedList<Inhabitant>();
		allinhabDeparture.add(temp);
	}
	
	for(int i=0;i<population.size();i++){
		int h=population.get(i).getworkingHour();
		int m=population.get(i).getworkingMinute();
		int t=60*h+m;
		int q=t/5;
		allinhabDeparture.get(q).add(population.get(i));
	}
	return allinhabDeparture;
	}
	
	
	
}
