import java.awt.event.ActionEvent;

import javax.swing.Timer;

public class Game {
    public static void main(String[] args) {
        Timer timer;
        int hour=0;
        int minute=0;
        int day=1;
        int month=0;
        
        timer = new Timer(100, new TimerAction());
        
    }
    public void actionPerformed(ActionEvent e) {
        minute+=1;
        if(minute==60){
            hour++;
            minute=0;
            if(hour==24){
                hour=0;
                day++;
                if(day==30){
                    day=1;
                    month++;
                }
            }
        }
    }
      
          
}
