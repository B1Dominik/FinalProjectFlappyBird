package com.tapandfly.objects;
public class Lava extends Scroll {
	public Lava(float x, float y, int width, int height, float scrollSpeed) {
		super(x, y, width, height, scrollSpeed);
		// TODO Auto-generated constructor stub
	}
	public void onRestart(float x, float scrollSpeed) {
        position.x = x;
        velocity.x = scrollSpeed;
    }
}
