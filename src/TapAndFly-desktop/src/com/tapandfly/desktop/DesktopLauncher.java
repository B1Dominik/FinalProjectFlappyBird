package com.tapandfly.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tapandfly.MyFlyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "TapAndFly";
        config.width = 272;
        config.height = 408;
        new LwjglApplication(new MyFlyGame(), config);
	}
}
