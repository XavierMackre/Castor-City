package castorcity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame {
    
	int pxWidth; // number of pixels of the map (width)
	int pxHeight; // number of pixels of the map (height)
	public BoardRoad boardRoad; // used to create the map
	public BoardBuilding boardBuilding; // used to create the map
	int lastX; // x-coordinate of the last click
	int lastY; // y-coordinate of the last click
	Graphics buffer;
	BufferedImage BackGround;
	
	
	// constructor
    public Window(int pxWidth, int pxHeight, BoardBuilding boardBuilding, BoardRoad boardRoad) {
        
    	this.pxWidth = pxWidth;
    	this.pxHeight = pxHeight;
    	this.boardRoad = boardRoad;
    	this.boardBuilding = boardBuilding;
    	
        this.setTitle("Castor City");
        this.setSize(pxWidth+500, pxHeight+50);
        // this.setResizable(false);
        this.setLocationRelativeTo(null); // set the window at the centre of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        BackGround = new BufferedImage (getSize().width, getSize().height, BufferedImage.TYPE_INT_RGB);
        buffer = BackGround.getGraphics();
        
        // DISPLAY OF ROADS
     	for(int i=0; i<boardRoad.getWidth(); i++) { // cover the columns
     			
     		if (i%2 == 0) {	// cover the even columns (containing only roads) {
     			
     			for(int j=0; j<boardRoad.getHeight(); j++) { // cover the lines
     					
     				if( j%2 == 0 ) { // cover the even lines (containing intersections)
     						
     					try {
     						Image img = ImageIO.read(new File("IntersectionRoad.jpg"));
     						buffer.drawImage(img, getInsets().left + boardRoad.indX2pxX(i), getInsets().top + boardRoad.indY2pxY(j), this);
     					} catch (IOException e) {
     							e.printStackTrace();
     						}	
    				} else { // cover the odd lines (containing vertical roads)
     					try {
     						Image img = ImageIO.read(new File("VerticalRoad.jpg"));
     						buffer.drawImage(img, getInsets().left + boardRoad.indX2pxX(i), getInsets().top + boardRoad.indY2pxY(j), this);
     					} catch (IOException e) {
     						e.printStackTrace();
     					}
     				}
     			}
     				
     		} else { // cover the odd columns
     				
     			for(int j=0; j<boardRoad.getHeight(); j++) { // cover the lines 
     					
     				if( j%2 == 0 ) { // cover the even lines (containing horizontal roads)
     						
     					try {
     						Image img = ImageIO.read(new File("HorizontalRoad.jpg"));
     						buffer.drawImage(img, getInsets().left + boardRoad.indX2pxX(i), getInsets().top + boardRoad.indY2pxY(j), this);
     					} catch (IOException e) {
     						e.printStackTrace();
     					}
     				}
     			}
     		}
     	}
     	
     	// DISPLAY OF THE BACKGROUND MENU
        try {
        	Image img = ImageIO.read(new File("Background.jpg"));
    		buffer.drawImage(img, getInsets().left + pxWidth, getInsets().top, null);
    	} catch (IOException e) {
    		e.printStackTrace();
    	}	

        this.addMouseListener(new Listener());
    }
    
    
    public class Listener implements MouseListener {
		
		// clic de la souris
		public void mouseClicked(MouseEvent event) { 
			
			int x = event.getX(); // coordonnées du dernier clic par rapport au panel (sans les bordures)
			int y = event.getY();
			
			int wMenu = getInsets().left + pxWidth;
	        int hMenu = getInsets().top;
			Font title = new Font ("Arial", Font.BOLD, 20);
	        Font text = new Font("Arial", Font.BOLD, 14);
	        buffer.setColor(Color.black);
			
	        // CLIC DANS LA ZONE DE JEU
	        if ( (x < pxWidth) && (y < pxHeight) ) {
				lastX = x - getInsets().left;
				lastY = y - getInsets().top;
				
				
				if ( boardRoad.isRoad(lastX,lastY) == false ) { // si le dernier clic était un batiment
						
					// MENU CASE VIDE
		    		if ( boardBuilding.BuildingType(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)) == 0 ) {
		    			
		    			// background menu
		    	        try {
		    	        	Image img = ImageIO.read(new File("Background.jpg"));
		    	    		buffer.drawImage(img, getInsets().left + pxWidth, getInsets().top, null);
		    	    	} catch (IOException e) {
		    	    		e.printStackTrace();
		    	    	}	
		    	        
		    	        // title
		    			buffer.setFont(title);
		    			buffer.drawString("Constructions :", wMenu + 10, hMenu + 20);
		    			
		    			// residential area button
		    			buffer.setFont(text);
		    			try {
		    				Image img = ImageIO.read(new File("ResidentialArea.jpg"));
		    				buffer.drawImage(img, wMenu + 10, hMenu + 40, null); // COORDONEES A REPERER POUR LE MOUSELISTENER
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
		    			buffer.drawString("Residential Area", wMenu + 70 , hMenu + 70);
		    			
		    			// industrial area button
		    			try {
		    				Image img = ImageIO.read(new File("IndustrialArea.jpg"));
		    				buffer.drawImage(img, wMenu + 10, hMenu + 100, null); // COORDONEES A REPERER POUR LE MOUSELISTENER
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
		    			buffer.drawString("Industrial Area", wMenu + 70, hMenu + 130);
		    		
		    		// MENU ZONE RESIDENTIELLE
		    		} else if (boardBuilding.BuildingType(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)) == 1) {
		    			
		    			// background menu
		    	        try {
		    	        	Image img = ImageIO.read(new File("Background.jpg"));
		    	    		buffer.drawImage(img, getInsets().left + pxWidth, getInsets().top, null);
		    	    	} catch (IOException e) {
		    	    		e.printStackTrace();
		    	    	}	

		    	        // title
		    			buffer.setFont(title);
		    			buffer.drawString("Residential Area", wMenu + 10, hMenu + 20);
		    			
		    			// number of inhabitants display
		    			buffer.setFont(text);
		    			int numInh = boardBuilding.getBuilding(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)).NumberInhabitants();
		    			String strInh = "Number of inhabitants : "+numInh;
		    			buffer.drawString(strInh, wMenu + 10, hMenu + 40);
		    			
		    			// satisfaction display
		    			buffer.drawString("Satisfaction :", wMenu + 10, hMenu + 60);
		    			// double avSatsf = boardBuilding.getBuilding(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)).ComputeSatisfaction();
		    			
		    			// destroy menu
		    			try {
		    				Image img = ImageIO.read(new File("Destroy.jpg"));
		    				buffer.drawImage(img, wMenu + 10, hMenu + 800, null); // COORDONEES A REPERER POUR LE MOUSELISTENER
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
		    			buffer.drawString("Destroy", wMenu + 70, hMenu + 830);
		    			
		    		// MENU ZONE INDUSTRIELLE
		    		} else if (boardBuilding.BuildingType(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)) == 2) {
		    			
		    			// background menu
		    	        try {
		    	        	Image img = ImageIO.read(new File("Background.jpg"));
		    	    		buffer.drawImage(img, getInsets().left + pxWidth, getInsets().top, null);
		    	    	} catch (IOException e) {
		    	    		e.printStackTrace();
		    	    	}	
		    	        
		    	        // title
		    	        buffer.setFont(title);
		    			buffer.drawString("Industrial Area", wMenu + 10, hMenu + 20);

		    			buffer.setFont(text);
		    			buffer.drawString("Number of workers :", wMenu + 10, hMenu + 40);
		    			// int numInh = boardBuilding.getBuilding(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)).NumberInhabitants();
		    			
		    			// destroy menu
		    			try {
		    				Image img = ImageIO.read(new File("Destroy.jpg"));
		    				buffer.drawImage(img, wMenu + 10, hMenu + 800, null); // COORDONEES A REPERER POUR LE MOUSELISTENER
		    			} catch (IOException e) {
		    				e.printStackTrace();
		    			}
		    			buffer.drawString("Destroy", wMenu + 70, hMenu + 830);
		    		}
				}
			
			// CLIC DANS LE MENU DE DROITE
			// SI LE DERNIER CLIC ETAIT UNE CONSTRUCTION
			} else if ( boardRoad.isRoad(lastX,lastY) == false ) {
				
				// SI LE DERNIER CLIC ETAIT UNE CASE VIDE
				if (boardBuilding.BuildingType(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)) == 0) {
					// CLIC SUR LE BOUTON "CONSTRUCTION MAISON"
					if ( (x >= (wMenu + 10)) && (x <= (wMenu + 60)) && (y >= (hMenu + 40)) && (y <= (hMenu + 90)) ) {
						boardBuilding.HouseConstruction(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY));
					// CLIC SUR LE BOUTON "CONSTRUCTION ZONE INDUSTRIELLE"
					} else if ( (x >= (wMenu + 10)) && (x <= (wMenu + 60)) && (y >= (hMenu + 100)) && (y <= (hMenu + 150)) ) {
						boardBuilding.IndustrialConstruction(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY));
					}
					
				// SI LE DERNIER CLIC ETAIT UNE MAISON
				} else if (boardBuilding.BuildingType(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)) == 1) {
					// CLIC SUR LE BOUTON "DETRUIRE"
					if ( (x >= (wMenu + 10)) && (x <= (wMenu + 60)) && (y >= (hMenu + 800)) && (y <= (hMenu + 850)) ) {
						boardBuilding.HouseDestruction(boardBuilding.pxX2indX(lastX),boardBuilding.pxY2indY(lastY));
					}
				
				// SI LE DERNIER CLIC ETAIT UNE ZONE INDUSTRIELLE
				} else if (boardBuilding.BuildingType(boardBuilding.pxX2indX(lastX), boardBuilding.pxY2indY(lastY)) == 2) {
					// CLIC SUR LE BOUTON "DETRUIRE"
					if ( (x >= (wMenu + 10)) && (x <= (wMenu + 60)) && (y >= (hMenu + 800)) && (y <= (hMenu + 850)) ) {
						boardBuilding.IndustrialDestruction(boardBuilding.pxX2indX(lastX),boardBuilding.pxY2indY(lastY));
					}
				}
			} 
			
	        
	     // DISPLAY OF CONSTRUCTIONS
	     	for(int i=0; i<boardBuilding.getWidth(); i++) { // cover the columns
	     		
	     		for(int j=0; j<boardBuilding.getHeight(); j++) { // cover the lines		
	     					
	     			if ( boardBuilding.BuildingType(i, j) == 0) {
	     				try {
	     					Image img = ImageIO.read(new File("EmptyArea.jpg"));
	     					buffer.drawImage(img, getInsets().left + boardBuilding.indX2pxX(i), getInsets().top + boardBuilding.indY2pxY(j), null);
	     				} catch (IOException e) {
	     					e.printStackTrace();
	     				}
	     							
	     			} else if ( boardBuilding.BuildingType( i , j) == 1 ) {
	     				try {
	     					Image img = ImageIO.read(new File("ResidentialArea.jpg"));
	     					buffer.drawImage(img, getInsets().left + boardBuilding.indX2pxX(i), getInsets().top + boardBuilding.indY2pxY(j), null);
	     				} catch (IOException e) {
	     					e.printStackTrace();
	     				}
	     							
	     			} else if ( boardBuilding.BuildingType( i , j) == 2 ) {
	     				try {
	     					Image img = ImageIO.read(new File("IndustrialArea.jpg"));
	     					buffer.drawImage(img, getInsets().left + boardBuilding.indX2pxX(i), getInsets().top + boardBuilding.indY2pxY(j), null);
	     				} catch (IOException e) {
	     					e.printStackTrace();
	     				}
	     			}
	     		}
	     	}
			
			repaint();
		}
		
		// survol de la souris
		public void mouseEntered(MouseEvent event) { }
		
		// la souris sort de la zone du bouton
		public void mouseExited(MouseEvent event) { }
		
		// on presse le bouton gauche
		public void mousePressed(MouseEvent event) { }
		
		// on relache le clic
		public void mouseReleased(MouseEvent event) { }
	}
    
    
    public void paint(Graphics g) {
    	
    	g.drawImage(BackGround, 0, 0, this);
	}

}
