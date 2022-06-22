import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entity here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Entity extends Actor {
    protected int actCounter;

    public void act() {
        // Add your action code here.
    }

    public double getDist(Actor actor) {
        int xDif = this.getX() - actor.getX(), yDif = this.getY() - actor.getY();
        return Math.sqrt(xDif * xDif + yDif * yDif);
    }
}
