package com.tapandfly.screens;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.tapandfly.gamehelpers.InputHandler;
import com.tapandfly.gameworldhelpers.Renderer;
import com.tapandfly.gameworldhelpers.World;
public class Screens implements Screen{
	private World world;
	private Renderer renderer;
	private float runTime;
	public Screens() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth / gameWidth);
        int midPointY = (int) (gameHeight / 2);
        world = new World(midPointY);
        renderer = new Renderer(world, (int) gameHeight, midPointY);
        Gdx.input.setInputProcessor(new InputHandler(world));
    }
	@Override
	public void render(float delta) {
	    runTime += delta;
	    world.update(delta);
	    renderer.render(runTime);
	}
    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");
    }
    @Override
    public void show() {
        Gdx.app.log("GameScreen", "show called");
    }
    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");     
    }
    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");        
    }
    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");       
    }
    @Override
    public void dispose() {
    }
}