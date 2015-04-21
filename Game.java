package castorcity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Game {
    
    Timer timer;
    int minute= 0;
    int hour=0;
    int day=1;
    int month=1;
    int year=2015;
    int[] date= {minute, hour, day, month, year};
    
    class TimerClass implements ActionListener {

                    public void actionPerformed (ActionEvent e) {
                        horloge(date);

                    }
        
    }
    private void  horloge (){
        minute +=1;
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


    
    public Game {
                   
                   
        timer = new Timer (100, new TimerClass());
        timer.start();
        
    }
}
    
