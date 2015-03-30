import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
    
    public Window() {
        
        // déclaration des Panels
        JPanel leftPan = new JPanel();
        JPanel rightPan = new JPanel();
        JPanel bigPan = new JPanel();
        
        // organisation des Panels
        bigPan.setLayout(new BorderLayout());
        bigPan.add(leftPan, BorderLayout.WEST);
        bigPan.add(rightPan, BorderLayout.EAST);
        
        
        this.setTitle("Castor City");
        this.setLocationRelativeTo(null); // place la fenêtre au centre de l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        this.setContentPane(bigPan);
       
    }
}