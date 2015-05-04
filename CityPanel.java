import java.awt.GridLayout;

import javax.swing.JPanel;


public class CityPanel extends JPanel {

	public JPanel pan = new JPanel();
	
	// déclaration des panels contenus dans chacune des cases......
	
	
	public CityPanel(int width, int height, BoardBuilding boardBuilding, BoardRoad boardRoad) {
		
		pan.setLayout(new GridLayout(2*width+1, 2*height+1));
		
		// display of the buildings
		for (int i=1; i < width; i++) {
			for (int j=1; j < height; j++) {
				if (boardBuilding.getBoard()[i][j] instanceof ResidentialArea) {    // ATTENTION : pas sûr que ça marche, trouvé sur internet, à tester !
					ResidentialAreaPanel residentialAreaPanel = new ResidentialAreaPanel(i,j);
					
				}
				else if (boardBuilding.getBoard()[i][j] instanceof IndustrialArea) {
					
				}
			}
		}
		
		for (int i=0; i < 2*height.game+1; i++) { // parcours les colonnes
			for (int j=0; j < 2*width.game+1; j++) { // parcours les lignes
					
				if(i%2==0){
					if(j%2==0) {
						
					}
				}
				
				
				// ça ne va pas : tous les affichages vont être disconectés des tableaux de bâtiments......
				// il faudrait relier les tableaux de batiments avec leur affichage graphique
			}
		}
		
		this.setContentPane(pan); // à trouver: méthode équivalente à celle ci pour un JPanel (et non un JFrame)
	}
	
}
