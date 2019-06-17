package com.tapandfly.objects;
import java.util.Random;

import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
public class Pipe extends Scroll {
	private Random rNumber;
	private Rectangle fireUp, fireDown, barUp, barDown;
	public static final int VERTICAL_GAP = 45;
	public static final int SKULL_WIDTH = 24;
	public static final int SKULL_HEIGHT = 11;
	private float groundY;
	private boolean isScored = false;
	public Pipe(float x, float y, int width, int height, float scrollSpeed, float groundY) {
		super(x, y, width, height, scrollSpeed);
		rNumber = new Random();
		 fireUp = new Rectangle();
		    fireDown = new Rectangle();
		    barUp = new Rectangle();
		    barDown = new Rectangle();
		    this.groundY = groundY;
    }
    @Override
    public void reset(float newX) {
// Calling reset method from superclass (Scroll)
        super.reset(newX);
// Changeing height to random number
        height = rNumber.nextInt(90) + 15;
        isScored = false;
    }
    public void update(float delta) {
// Calling update method from superclass (Scroll)
        super.update(delta);
        barUp.set(position.x, position.y, width, height);
        barDown.set(position.x, position.y + height + VERTICAL_GAP, width,
                groundY - (position.y + height + VERTICAL_GAP));
// Fire width = 24, bar = 22 pixels wide. 
// Fire have to be shifted by 1 pixel to the left to be centered
        fireUp.set(position.x - (SKULL_WIDTH - width) / 2, position.y + height
                - SKULL_HEIGHT, SKULL_WIDTH, SKULL_HEIGHT);
        fireDown.set(position.x - (SKULL_WIDTH - width) / 2, barDown.y,
                SKULL_WIDTH, SKULL_HEIGHT);
    }
    public boolean collides(Bird bird) {
        if (position.x < bird.getX() + bird.getWidth()) {
            return (Intersector.overlaps(bird.getBCircle(), barUp)
                    || Intersector.overlaps(bird.getBCircle(), barDown)
                    || Intersector.overlaps(bird.getBCircle(), fireUp) || Intersector
                        .overlaps(bird.getBCircle(), fireDown));
        }
        return false;
    }
    public void onRestart(float x, float scrollSpeed) {
        velocity.x = scrollSpeed;
        reset(x);
    }
    public boolean isScored() {
        return isScored;
    }
    public void setScored(boolean b) {
        isScored = b;
    }
    public Rectangle getFUp() {
        return fireUp;
    }
    public Rectangle getFDown() {
        return fireDown;
    }
    public Rectangle getBarUp() {
        return barUp;
    }
    public Rectangle getBarDown() {
        return barDown;
    }
}