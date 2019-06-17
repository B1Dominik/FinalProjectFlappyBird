package com.tapandfly.objects;
import com.badlogic.gdx.math.Vector2;
public class Scroll {
    protected Vector2 position;
    protected Vector2 velocity;
    protected int width;
    protected int height;
    protected boolean scrolledLeft;
    public Scroll(float x, float y, int width, int height, float scrollSpeed) {
        position = new Vector2(x, y);
        velocity = new Vector2(scrollSpeed, 0);
        this.width = width;
        this.height = height;
        scrolledLeft = false;
    }
   public void update(float delta) {
        position.add(velocity.cpy().scl(delta));
        if (position.x + width < 0) {
            scrolledLeft = true;
        }
    }
    public void reset(float newX) {
        position.x = newX;
        scrolledLeft = false;
    }
    public void stop() {
        velocity.x = 0;
    }
    public boolean isScrolledLeft() {
        return scrolledLeft;
    }
    public float getTailX() {
        return position.x + width;
    }
    public float getX() {
        return position.x;
    }
    public float getY() {
        return position.y;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}