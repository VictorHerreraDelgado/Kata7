/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Asus
 */
public class Watch {
    // Empiezan todas con el mismo valor: los 90 grados o Pi/2
    private double hours= Math.PI /2;
    private double seconds = Math.PI /2;
    private double minutes = Math.PI /2;
    // Cambios entre una hora y otra
    private static final double StepSeconds = Math.PI * 2 /60;
    private static final double StepMinutes = StepSeconds / 60;
    private static final double StepHours = StepMinutes /12;
    private final List<Observer> observers = new ArrayList<>(); 
    
    public Watch() {
        //Creamos un timer para el reloj 
        Timer timer = new Timer();
        timer.schedule(timerTask(),0,1000);
    }

    private TimerTask timerTask() {
        return new TimerTask(){
            @Override
            public void run() {
                step();
                updateObservers();
            }
            
        };
    }
    public double getHours(){
        return hours;
    }
    public double getMinutes(){
        return minutes;
    }
    public double getSeconds(){
        return seconds;
    }
    public void addObserver(Observer newObserver){
        observers.add(newObserver);
    }
    private void step(){
        hours = normalize(hours + StepHours);
        minutes = normalize(minutes + StepMinutes);
        seconds = normalize(seconds + StepSeconds);
                
    }
    private void updateObservers(){
        for (Observer observer : observers) observer.update();
        
    }
    private double normalize(double angle) {
        return (angle + Math.PI * 2) % (Math.PI*2);
    }
    public interface Observer{
        public void update();
    }
            
}
