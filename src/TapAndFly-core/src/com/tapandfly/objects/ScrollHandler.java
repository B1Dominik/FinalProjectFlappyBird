package com.tapandfly.objects;

import com.tapandfly.gamehelpers.AssetsLoader;
import com.tapandfly.gameworldhelpers.World;

public class ScrollHandler {
	private Lava fLava, bLava;
    private Pipe pipe1, pipe2, pipe3;
	private World World;
    public static final int SCROLL_SPEED = -59;
    public static final int PIPE_GAP = 49;
    public ScrollHandler(float yPos, World World) {
    	this.World = World;
        fLava = new Lava(0, yPos, 143, 11, SCROLL_SPEED);
        bLava = new Lava(fLava.getTailX(), yPos, 143, 11,
                SCROLL_SPEED);
        pipe1 = new Pipe(210, 0, 22, 60, SCROLL_SPEED, yPos);
        pipe2 = new Pipe(pipe1.getTailX() + PIPE_GAP, 0, 22, 70, SCROLL_SPEED, yPos);
        pipe3 = new Pipe(pipe2.getTailX() + PIPE_GAP, 0, 22, 60, SCROLL_SPEED, yPos);
    }
    public void update(float delta) {
// Updating our objects
        fLava.update(delta);
        bLava.update(delta);
        pipe1.update(delta);
        pipe2.update(delta);
        pipe3.update(delta);
        if (pipe1.isScrolledLeft()) {
            pipe1.reset(pipe3.getTailX() + PIPE_GAP);
        } else if (pipe2.isScrolledLeft()) {
            pipe2.reset(pipe1.getTailX() + PIPE_GAP);

        } else if (pipe3.isScrolledLeft()) {
            pipe3.reset(pipe2.getTailX() + PIPE_GAP);
        }
        if (fLava.isScrolledLeft()) {
            fLava.reset(bLava.getTailX());

        } else if (bLava.isScrolledLeft()) {
            bLava.reset(fLava.getTailX());
        }
        
    }
    public void onRestart() {
        fLava.onRestart(0, SCROLL_SPEED);
        bLava.onRestart(fLava.getTailX(), SCROLL_SPEED);
        pipe1.onRestart(210, SCROLL_SPEED);
        pipe2.onRestart(pipe1.getTailX() + PIPE_GAP, SCROLL_SPEED);
        pipe3.onRestart(pipe2.getTailX() + PIPE_GAP, SCROLL_SPEED);
    }
    public void stop() {
        fLava.stop();
        bLava.stop();
        pipe1.stop();
        pipe2.stop();
        pipe3.stop();
    }
    public boolean collides(Bird bird) {

        if (!pipe1.isScored()
                && pipe1.getX() + (pipe1.getWidth() / 2) < bird.getX()
                        + bird.getWidth()) {
            addScore(1);
            pipe1.setScored(true);
            AssetsLoader.score.play();
        } else if (!pipe2.isScored()
                && pipe2.getX() + (pipe2.getWidth() / 2) < bird.getX()
                        + bird.getWidth()) {
            addScore(1);
            pipe2.setScored(true);
            AssetsLoader.score.play();

        } else if (!pipe3.isScored()
                && pipe3.getX() + (pipe3.getWidth() / 2) < bird.getX()
                        + bird.getWidth()) {
            addScore(1);
            pipe3.setScored(true);
            AssetsLoader.score.play();

        }

        return (pipe1.collides(bird) || pipe2.collides(bird) || pipe3
                .collides(bird));
    }
    private void addScore(int increment) {
        World.addScore(increment);
    }
    public Lava getFlava() {
        return fLava;
    }
    public Lava getBlava() {
        return bLava;
    }
    public Pipe getPipe1() {
        return pipe1;
    }
    public Pipe getPipe2() {
        return pipe2;
    }
    public Pipe getPipe3() {
        return pipe3;
    }
}
