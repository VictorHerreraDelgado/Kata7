/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presente;

import View.WatchDisplay;
import Model.Watch;
import java.awt.Point;

/**
 *
 * @author Asus
 */
public class WatchPresenter implements Watch.Observer{
    
    private final Watch watch;
    private final WatchDisplay watchDisplay;
    
    public WatchPresenter(Watch watch, WatchDisplay watchDisplay) {
        this.watch = watch;
        this.watch.addObserver(this);
        this.watchDisplay = watchDisplay;
    }
    @Override
    public void update() {
        refresh();
    }
    private void refresh(){
        watchDisplay.paint(pointsOf(watch));
    }

    private Point[] pointsOf(Watch watch) {
        Point[] points = new Point[3];
        points[0] = pointOf(watch.getHours(),50);
        points[1] = pointOf(watch.getMinutes(), 80);
        points[2] = pointOf(watch.getSeconds(), 100);
        return points;
    }

    private Point pointOf(double angle, int length) {
        return new Point(toInt(Math.cos(angle)*length),toInt(Math.sin(angle)*length));
    }
    private int toInt(double doubl){
        return (int) doubl;
    }
}
