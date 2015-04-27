import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    
	// DECLARATION OF PANELS
	
	// principal panels
	public JPanel leftPan = new JPanel();
	public JPanel rightPan = new JPanel();
	public JPanel bigPan = new JPanel();

	// panels in rightPan
	public JPanel peopleFacePan = new JPanel();
	
	
	// constructor
    public Window() {
        
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
        this.setLocationRelativeTo(null); // set the window at the centre of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.setContentPane(bigPan);
       
    }
}