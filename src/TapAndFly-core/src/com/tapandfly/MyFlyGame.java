package com.tapandfly;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.tapandfly.gamehelpers.AssetsLoader;
import com.tapandfly.screens.Screens;
public class MyFlyGame extends Game {
	  @Override
	    public void create() {
	        Gdx.app.log("ZBGame", "created");
	        AssetsLoader.load();
	        setScreen(new Screens());
	    }
	    @Override
	    public void dispose() {
	        super.dispose();
	        AssetsLoader.dispose();
	    }
	}
