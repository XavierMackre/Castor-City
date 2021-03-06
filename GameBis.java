package castorcity;

import castorcity.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import castorcity.Inhabitant;

import java.util.ArrayList;
import java.util.Iterator;
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
        public LinkedList<Inhabitant> onTheRoadAgain; //contains all inhabitants currently moving*
        public ArrayList<LinkedList<Inhabitant>> allInhabDeparture;
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
                this.onTheRoadAgain= new LinkedList<Inhabitant>();
		
		// initialization of the boards of roads and constructions
		boardRoad = new BoardRoad(widthRoad, heightRoad); 
		boardBuilding = new BoardBuilding(width, height);
		
		/*
		// initialization of 50 inhabitants ready to moving in at the beginning of the game
		for (int i=0 ; i<50 ; i++) {
			population.add(new Inhabitant("Inhabitant"+i));
		}
		*/
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
	 * getter of width
	 * @return the width of the city
	 */
	public int getWidth() {
		return this.width;
	}
	
	
	/**
	 * getter of height
	 * @return the height of the city
	 */
	public int getHeight() {
		return this.height;
	}
	
	public BoardBuilding getBoardBuilding() {
		return this.boardBuilding;
	}
	
	
	/**
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
        //m�thode pour faire avancer l'heure de 5 minutes
        public boolean horloge (){//renvoie true le matin et false l'apr�s midi
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
            if(hour<12){
                return true;
            }
            else{
                return false;
            }
        }
        
        private void move(boolean aller, Road[][] BoarderRoad){
            /*the int is forced if we change the timer ticking*/
            
            int q=(int)((hour*60+minute)/5)-1;//je pense que le int prend l'arrondi et pas la partie enti�re
            Iterator iter= this.allInhabDeparture.get(q).iterator();
             while (iter.hasNext()){
                Inhabitant curin = (Inhabitant)iter.next();
                this.onTheRoadAgain.add(curin);
                curin.testChemin(aller);
            }
            Iterator it = this.onTheRoadAgain.iterator();
            while (it.hasNext()) {
                Inhabitant curin = (Inhabitant)it.next();
                if(curin.MovingPath(boardRoad.BoardRoad)==true){
                    onTheRoadAgain.remove(curin);
            }
        

        }
    }
        
        
        class TimerClass implements ActionListener {
            public void actionPerformed (ActionEvent e) {
                boolean aller=horloge();
                allInhabDeparture=allinhabDeparture();
                move(aller,boardRoad.BoardRoad);

            }
    }
    /**
            �����* This is the array of lists of inhabitants ordered by their time of departure*
            �����* */
        public ArrayList<LinkedList<Inhabitant>> allinhabDeparture() {
            ArrayList<LinkedList<Inhabitant>> allinhabDeparture =new ArrayList<LinkedList<Inhabitant>>(288);
            LinkedList<Inhabitant> temp;

            for(int i=0;i<287;i++) {
                    temp=new LinkedList<Inhabitant>();
                    allinhabDeparture.add(i, temp);
            }
            Iterator it = this.boardBuilding.housePopulation.iterator();
            while (it.hasNext()) {
                Inhabitant curin = (Inhabitant)it.next();
                int h=curin.getworkingHour();
                int m=curin.getworkingMinute();
                int t=60*h+m;
                int q=(int)t/5;
                allinhabDeparture.get(q).add(curin);
            }
            return allinhabDeparture;
        }
        
	
}
