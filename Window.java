import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    
	int pxWidth; // number of pixels of the map (width)
	int pxHeight; // number of pixels of the map (height)
	
	
	// DECLARATION OF PANELS
	
	// principal panels
	public BoardBuilding boardBuilding; // used to create the panel city
	public BoardRoad boardRoad; // used to create the panel city
	public CityPanel city;
	public JPanel rightPan;
	public JPanel bigPan; // principal panel (for the whole window)

	// panels in rightPan
	public JPanel firstPan;
	public JPanel secondPan;
	
	
	// constructor
    public Window(int pxWidth, int pxHeight, BoardBuilding boardBuilding, BoardRoad boardRoad) {
        
    	this.pxWidth = pxWidth;
    	this.pxHeight = pxHeight;
    	this.boardBuilding = boardBuilding;
    	this.boardRoad = boardRoad;
    	
    	bigPan = new JPanel();
    	city = new CityPanel(pxWidth, pxHeight, boardBuilding, boardRoad);
    	rightPan = new JPanel();
    	firstPan = new JPanel();
    	secondPan = new JPanel();
    	
        // organisation of the principal panel
        bigPan.setLayout(new BorderLayout());
        bigPan.add(city, BorderLayout.CENTER);
        bigPan.add(rightPan, BorderLayout.EAST);
        
        // organisation of the right panel
        rightPan.setPreferredSize(new Dimension(400,860)); // ATTENTION : DIMENSIONS DU PANEL DE DOITE (can be canged)
        rightPan.setLayout(new BorderLayout());
        firstPan.setPreferredSize(new Dimension(400, 360));
        secondPan.setPreferredSize(new Dimension(400, 500));
        rightPan.add(firstPan, BorderLayout.CENTER);
        rightPan.add(secondPan, BorderLayout.SOUTH);
        
        // organisation of peopleFacePan
        //peopleFacePan.setLayout(new GridLayout(2,5));
        	// événement qui affiche les têtes des peronnes travaillant / habitant à l'endroit sélectionné
        
        this.setTitle("Castor City");
        this.setSize(pxWidth, pxHeight);
        // this.setResizable(false);
        this.setLocationRelativeTo(null); // set the window at the centre of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.setContentPane(bigPan);
        
       
    }
    
    
    
    
}