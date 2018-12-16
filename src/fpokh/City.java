/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpokh;

/**
 *
 * @author fariz
 */
public class City {
    int x;
    int y;
    String name;
    
    // Constructs a randomly placed city
    public City(){
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }
    
    // Constructs a city at chosen x, y location
    public City(String name, int x, int y){
        this.name = name;
        this.x = x;
        this.y = y;
    }
    
    // Gets city's x coordinate
    public int getX(){
        return this.x;
    }
    
    public String getName() {
        return name;
    }
    // Gets city's y coordinate
    public int getY(){
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    @Override
    public String toString(){
        //return getX()+", "+getY();
        return getName();
    }
}