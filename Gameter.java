package castorcity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Gameter {
    
    Timer timer;
    int minute= 0;
    int hour=0;
    int day=1;
    int month=1;
    int year=2015;
    int[] date= {minute, hour, day, month, year};
    
    
    //méthode pour faire avancer l'heure de 5 minutes
    public void horloge (){
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
    }
    //définie l'action à chaque tic du timer
    class TimerClass implements ActionListener {

                    public void actionPerformed (ActionEvent e) {
                        horloge();

                    }
    }
   //constructeur. Lance le timer
    public Gameter(){
                   
                   
        timer = new Timer (100, new TimerClass());
        timer.start();
        
    }
}