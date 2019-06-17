package com.tapandfly.gamehelpers;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
public class AssetsLoader {
    public static Texture texture;
    public static TextureRegion background, lava;
    public static Animation birdAnimation;
    public static TextureRegion bird, birdDown, birdUp;
    public static TextureRegion fireUp, fireDown, bar;
    public static Sound dead;
    public static Sound wings;
    public static Sound score;
    public static BitmapFont font, shadow;
    public static Preferences pref;
    public static void load() {
        texture = new Texture(Gdx.files.internal("data/texture.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
        background = new TextureRegion(texture, 0, 0, 136, 43);
        background.flip(false, true);
        lava = new TextureRegion(texture, 0, 43, 143, 11);
        lava.flip(false, true);
        birdDown = new TextureRegion(texture, 136, 0, 17, 12);
        birdDown.flip(false, true);
        bird = new TextureRegion(texture, 153, 0, 17, 12);
        bird.flip(false, true);
        birdUp = new TextureRegion(texture, 170, 0, 17, 12);
        birdUp.flip(false, true);
        TextureRegion[] birds = { birdDown, bird, birdUp };
        birdAnimation = new Animation(0.06f, birds);
        birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        fireUp = new TextureRegion(texture, 192, 0, 24, 14);
 //Flapping existing fire
        fireDown = new TextureRegion(fireUp);
        fireDown.flip(false, true);
        bar = new TextureRegion(texture, 136, 16, 22, 3);
        bar.flip(false, true);
        dead = Gdx.audio.newSound(Gdx.files.internal("data/dead.wav"));
        wings = Gdx.audio.newSound(Gdx.files.internal("data/wings.wav"));
        score = Gdx.audio.newSound(Gdx.files.internal("data/score.wav"));
        font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
        font.getData().setScale(.25f,-.25f);
        shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
        shadow.getData().setScale(.25f,-.25f);
// Either creating or retrieving existing preferences file
        pref = Gdx.app.getPreferences("ZombieBird");
// Setting default high score of 0 if file is empty
        if (!pref.contains("highScore")) {
            pref.putInteger("highScore", 0);
        }   
    }
 // Receive an integer and map it to the String highScore in pref
    public static void setHighScore(int val) {
        pref.putInteger("highScore", val);
        pref.flush();
    }
 // Retrieve current high score
    public static int getHighScore() {
        return pref.getInteger("highScore");
    }
    public static void dispose() {
 // Disposing loaded resources when closed.
        texture.dispose();
       dead.dispose();
        wings.dispose();
        score.dispose();
        font.dispose();
        shadow.dispose();
    }
}


