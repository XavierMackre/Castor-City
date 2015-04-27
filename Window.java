import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    
	int pxWidth; // nombre de pixels de la carte en largeur
	int pxHeight; // nombre de pixels de la carte en hauteur

	// DECLARATION OF PANELS
	
	// principal panels
	public JPanel leftPan = new JPanel();
	public JPanel rightPan = new JPanel();
	public JPanel bigPan = new JPanel();

	// panels in rightPan
	public JPanel peopleFacePan = new JPanel();
	
	
	// constructor
    public Window(int width, int height) {
        
    	this.pxWidth = (width * 50) + ((width + 1) * 20); // ATTENTION TAILLE DES IMAGES : 50*50px (constructions), 20px (routes)
		this.pxHeight = (width * 50) + ((width + 1) * 20);
    	
        // organisation of the principal panel
        bigPan.setLayout(new BorderLayout());
        bigPan.add(leftPan, BorderLayout.WEST);
        bigPan.add(rightPan, BorderLayout.EAST);
        
        // organisation of the right panel
        	// rightPan.setLayout(new BorderLayout());
        
        // organisation of peopleFacePan
        peopleFacePan.setLayout(new GridLayout(2,5));
        	// événement qui affiche les têtes des peronnes travaillant / habitant à l'endroit sélectionné
        
        this.setTitle("Castor City");
        this.setSize(pxWidth, pxHeight);
        this.setResizable(false);
        this.setLocationRelativeTo(null); // set the window at the centre of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.setContentPane(bigPan);
       
    }
    
    
    
    
}