package com.tapandfly.gameworldhelpers;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.tapandfly.gamehelpers.AssetsLoader;
import com.tapandfly.objects.Bird;
import com.tapandfly.objects.ScrollHandler;
public class World {
		private Bird bird;
		private ScrollHandler scroller;
		private Rectangle ground;
		private int score = 0;
		private GameState currentState;
		public int midPointY;
	    public World(int midPointY) {
	        bird = new Bird(33, midPointY - 5, 17, 12);
	        this.midPointY = midPointY;
	        scroller = new ScrollHandler(midPointY + 66, this);
	        currentState = GameState.READY;
	        ground = new Rectangle(0, midPointY + 66, 136, 11);
	    }
	    public void ruUpdate(float delta){ 
	        if (delta > .15f) {
	            delta = .15f;
	        }
	        bird.update(delta);
	        scroller.update(delta);

	        if (scroller.collides(bird) && bird.isAlive()) {
	            scroller.stop();
	            bird.die();
	            AssetsLoader.dead.play();
	        }
	        if (Intersector.overlaps(bird.getBCircle(), ground)) {
	            scroller.stop();
	            bird.die();
	            bird.dProcess();
	            currentState = GameState.GAMEOVER;
	            if (score > AssetsLoader.getHighScore()) {
	                AssetsLoader.setHighScore(score);
	                currentState = GameState.HIGHSCORE;
	            }
	        }
	    }
	    public boolean isHighScore() {
	        return currentState == GameState.HIGHSCORE;
	    }
	    public void update(float delta) {
	        switch (currentState) {
	        case READY:
	            reUpdate(delta);
	            break;
	        case RUNNING:
	        default:
	            ruUpdate(delta);
	            break;
	        }
	    }
	    public void restart() {
	        currentState = GameState.READY;
	        score = 0;
	        bird.onRestart(midPointY - 5);
	        scroller.onRestart();
	        currentState = GameState.READY;
	    }
	    private void reUpdate(float delta) {
	        // Do nothing for now
	    }
	    public enum GameState {
	        READY, RUNNING, GAMEOVER, HIGHSCORE
	    }
	    public int getScore() {
	        return score;
	    }
	    public void addScore(int increment) {
	        score += increment;
	    }
	    public Bird getBird() {
	        return bird;}
	    public ScrollHandler getScroller() {
	        return scroller;
	    }
	    public boolean isReady() {
	        return currentState == GameState.READY;
	    }
	    public boolean isGameOver() {
			return currentState == GameState.GAMEOVER;
		}

	    public void start() {
	        currentState = GameState.RUNNING;
	    }

	   }