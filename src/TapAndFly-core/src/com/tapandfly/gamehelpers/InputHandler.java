package com.tapandfly.gamehelpers;

import com.badlogic.gdx.InputProcessor;
import com.tapandfly.gameworldhelpers.World;
import com.tapandfly.objects.Bird;

public class InputHandler implements InputProcessor {
	private Bird mBird;
	private World mWorld;
 // Asking for a reference to the World when InputHandler is created.
    public InputHandler(World mWorld) {
 // myBird now represents the gameWorld's bird.
       this.mWorld = mWorld;
       mBird = mWorld.getBird();
   }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (mWorld.isReady()) {
            mWorld.start();
        }
        mBird.onClick();
        if (mWorld.isGameOver() || mWorld.isHighScore()) {
            // Reset all variables, go to GameState.READ
            mWorld.restart();
        }
        return true; // Return true to say we handled the touch.
    }
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
