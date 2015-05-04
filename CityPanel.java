import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class CityPanel extends JPanel {

	public JPanel pan = new JPanel();
	public BoardBuilding boardBuilding;
	public BoardRoad boardRoad;
	int pxWidth; // number of pixels of the map (width)
	int pxHeight; // number of pixels of the map (height)
	
	
	public CityPanel(int pxWidth, int pxHeight, BoardBuilding boardBuilding, BoardRoad boardRoad) {
		
		this.boardBuilding = boardBuilding;
		this.boardRoad = boardRoad;
		this.pxWidth = pxWidth;
		this.pxHeight = pxHeight;
		
		this.addMouseListener(new Listener());
		
	}
	
	public class Listener implements MouseListener {
		
		// clic de la souris
		public void mouseClicked(MouseEvent event) { 
			int x = event.getX();
			int y = event.getY();
			
			if(boardRoad.isRoad(x,y)) { // si on a cliqué sur une route
				
			
			} else { // si on a cliqué sur une construction
			
			}
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
		
		// affichage des routes
		for(int i=0; i<boardRoad.getWidth(); i++) { // parcours les colonnes
			
			if (i%2 == 0) {	// parcours les colonnes paires (ne contenant que des routes) {
				
				for(int j=0; j<boardRoad.getHeight(); j++) { // parcours les lignes
					
					if( j%2 == 0 ) { // parcours les lignes paires (instersection)
						
						try {
								Image img = ImageIO.read(new File("IntersectionRoad.jpg"));
								g.drawImage(img, boardRoad.indX2pxX(i), boardRoad.indY2pxY(j), this);
							} catch (IOException e) {
								e.printStackTrace();
							}	
					} else { // parcours les lignes impaires (vertical roads)
						try {
							Image img = ImageIO.read(new File("VerticalRoad.jpg"));
							g.drawImage(img, boardRoad.indX2pxX(i), boardRoad.indY2pxY(j), this);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				
			} else { // parcours les colonnes impaires
				
				for(int j=0; j<boardRoad.getHeight(); j++) { // parcours les lignes 
					
					if( j%2 == 0 ) { // parcours les lignes paires (horizontal roads)
						
						try {
							Image img = ImageIO.read(new File("HorizontalRoad.jpg"));
							g.drawImage(img, boardRoad.indX2pxX(i), boardRoad.indY2pxY(j), this);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		
		
		// affichage des constructions
		for(int i=0; i<boardBuilding.getWidth(); i++) { // parcours les colonnes
				for(int j=0; j<boardBuilding.getHeight(); j++) { // parcours les lignes		
					
					if ( boardBuilding.BuildingType(i, j) == 0) {
						try {
							Image img = ImageIO.read(new File("EmptyArea.jpg"));
						g.drawImage(img, boardBuilding.indX2pxX(i), boardBuilding.indY2pxY(j), this);
						} catch (IOException e) {
							e.printStackTrace();
						}
							
					} else if ( boardBuilding.BuildingType( i , j) == 1 ) {
						try {
							Image img = ImageIO.read(new File("ResidentialArea.jpg"));
							g.drawImage(img, boardBuilding.indX2pxX(i), boardBuilding.indY2pxY(j), this);
						} catch (IOException e) {
							e.printStackTrace();
						}
							
					} else if ( boardBuilding.BuildingType( i , j) == 2 ) {
						try {
							Image img = ImageIO.read(new File("IndustrialArea.jpg"));
							g.drawImage(img, boardBuilding.indX2pxX(i), boardBuilding.indY2pxY(j), this);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		
	}
	
	
}
