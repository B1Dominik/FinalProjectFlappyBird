package com.tapandfly.gameworldhelpers;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.tapandfly.gamehelpers.AssetsLoader;
import com.tapandfly.objects.Bird;
import com.tapandfly.objects.Lava;
import com.tapandfly.objects.Pipe;
import com.tapandfly.objects.ScrollHandler;
public class Renderer {
	 private World mWorld;
	    private OrthographicCamera cam;
	    private ShapeRenderer shapeRenderer;
	    private SpriteBatch batcher;
	    private int midPointY;
	    private int gameHeight;	
	    private Bird bird;
	    private ScrollHandler scroller;
	    private Lava flava, blava;
	    private Pipe pipe1, pipe2, pipe3;
	    private TextureRegion background, lava;
	    private Animation birdAnimation; 
	    private TextureRegion birdMid, birdDown, birdUp;
	    private TextureRegion fireUp, fireDown, bar;


	    public Renderer(World world, int gameHeight, int midPointY) {
	        mWorld = world;

	        // The word "this" refers to this instance.
	        // We are setting the instance variables' values to be that of the
	        // parameters passed in from GameScreen.
	        this.gameHeight = gameHeight;
	        this.midPointY = midPointY;

	        cam = new OrthographicCamera();
	        cam.setToOrtho(true, 136, gameHeight);

	        batcher = new SpriteBatch();
	        batcher.setProjectionMatrix(cam.combined);
	        shapeRenderer = new ShapeRenderer();
	        shapeRenderer.setProjectionMatrix(cam.combined);
	        initGameObjects();
	        initAssets();
	    }
	    private void initGameObjects() {
	        bird = mWorld.getBird();
	        scroller = mWorld.getScroller();
	        flava = scroller.getFlava();
	        blava = scroller.getBlava();
	        pipe1 = scroller.getPipe1();
	        pipe2 = scroller.getPipe2();
	        pipe3 = scroller.getPipe3();
	    }
	    private void initAssets() {
	        background = AssetsLoader.background;
	        lava = AssetsLoader.lava;
	        birdAnimation = AssetsLoader.birdAnimation;
	        birdMid = AssetsLoader.bird;
	        birdDown = AssetsLoader.birdDown;
	        birdUp = AssetsLoader.birdUp;
	        fireUp = AssetsLoader.fireUp;
	        fireDown = AssetsLoader.fireDown;
	        bar = AssetsLoader.bar;
	    }
	    
	    private void drawLava() {
	    	 // Draw the lava
	    		        batcher.draw(lava, flava.getX(), flava.getY(),
	    		                flava.getWidth(), flava.getHeight());
	    		        batcher.draw(lava, blava.getX(), blava.getY(),
	    		                blava.getWidth(), blava.getHeight());
	    		    }

	    	        private void drawFire() {
	    	        	// Temporary code! 
	    		        batcher.draw(fireUp, pipe1.getX() - 1,
	    		                pipe1.getY() + pipe1.getHeight() - 14, 24, 14);
	    		        batcher.draw(fireDown, pipe1.getX() - 1,
	    		                pipe1.getY() + pipe1.getHeight() + 45, 24, 14);

	    		        batcher.draw(fireUp, pipe2.getX() - 1,
	    		                pipe2.getY() + pipe2.getHeight() - 14, 24, 14);
	    		        batcher.draw(fireDown, pipe2.getX() - 1,
	    		                pipe2.getY() + pipe2.getHeight() + 45, 24, 14);

	    		        batcher.draw(fireUp, pipe3.getX() - 1,
	    		                pipe3.getY() + pipe3.getHeight() - 14, 24, 14);
	    		        batcher.draw(fireDown, pipe3.getX() - 1,
	    		                pipe3.getY() + pipe3.getHeight() + 45, 24, 14);
	    		    }

	    		    private void drawPipes() {
	    		        // Temporary code! 
	    		        batcher.draw(bar, pipe1.getX(), pipe1.getY(), pipe1.getWidth(),
	    		                pipe1.getHeight());
	    		        batcher.draw(bar, pipe1.getX(), pipe1.getY() + pipe1.getHeight() + 45,
	    		                pipe1.getWidth(), midPointY + 66 - (pipe1.getHeight() + 45));

	    		        batcher.draw(bar, pipe2.getX(), pipe2.getY(), pipe2.getWidth(),
	    		                pipe2.getHeight());
	    		        batcher.draw(bar, pipe2.getX(), pipe2.getY() + pipe2.getHeight() + 45,
	    		                pipe2.getWidth(), midPointY + 66 - (pipe2.getHeight() + 45));

	    		        batcher.draw(bar, pipe3.getX(), pipe3.getY(), pipe3.getWidth(),
	    		                pipe3.getHeight());
	    		        batcher.draw(bar, pipe3.getX(), pipe3.getY() + pipe3.getHeight() + 45,
	    		                pipe3.getWidth(), midPointY + 66 - (pipe3.getHeight() + 45));
	    		    }
	    		
	    public void render(float runTime) {
// Fill the entire screen with black, to prevent potential flickering.
	    	Gdx.gl.glClearColor(0, 0, 0, 1);
	        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
// starting ShapeRenderer
	        shapeRenderer.begin(ShapeType.Filled);
// Drawing Background color
	        shapeRenderer.setColor(232 / 255.0f, 56 / 255.0f, 16 / 255.0f, 1);
	        shapeRenderer.rect(0, 0, 136, midPointY + 66);
// Drawing Lava
	        shapeRenderer.setColor(136 / 255.0f, 0 / 255.0f, 21 / 255.0f, 1);
	        shapeRenderer.rect(0, midPointY + 66, 136, 11);
// Drawing Dirt
	        shapeRenderer.setColor(129 / 255.0f, 67 / 255.0f, 27 / 255.0f, 1);
	        shapeRenderer.rect(0, midPointY + 77, 136, 52);
// End ShapeRenderer
	        shapeRenderer.end();
	        batcher.begin();
// Disableing transparency	
	        batcher.disableBlending();
	        batcher.draw(background, 0, midPointY + 23, 136, 43);
			drawLava();			
			drawPipes();
			batcher.enableBlending();
			drawFire();
// enabling transparency for bird
	        batcher.enableBlending();
//drawing bird with rotation at its coordinates. Retrieve the Animation object from	       
	        if (bird.nFlaping()) {
	            batcher.draw(birdMid, bird.getX(), bird.getY(),
	                    bird.getWidth() / 2.0f, bird.getHeight() / 2.0f,
	                    bird.getWidth(), bird.getHeight(), 1, 1, bird.getRotation());
	        } else {
	            batcher.draw((TextureRegion)birdAnimation.getKeyFrame(runTime), bird.getX(),
	                    bird.getY(), bird.getWidth() / 2.0f,
	                    bird.getHeight() / 2.0f, bird.getWidth(), bird.getHeight(),
	                    1, 1, bird.getRotation());
	        }
	        if (mWorld.isReady()) {
	            AssetsLoader.shadow.draw(batcher, "Tap and Fly", (136 / 2)
	                    - (55), 76);
	            AssetsLoader.font.draw(batcher, "Tap and Fly", (136 / 2)
	                    - (57), 75);
	        } else {
	            if (mWorld.isGameOver()|| mWorld.isHighScore()) {
	                AssetsLoader.shadow.draw(batcher, "Game is Over", 4, 56);
	                AssetsLoader.font.draw(batcher, "Game is Over", 2, 55);
	                AssetsLoader.shadow.draw(batcher, "Tap to play", 8, 76);
	                AssetsLoader.font.draw(batcher, "Tap to play", 10, 75);   
	                AssetsLoader.shadow.draw(batcher, "High Score:", 23, 106);
                    AssetsLoader.font.draw(batcher, "High Score:", 22, 105);
                    String highScore = AssetsLoader.getHighScore() + "";
                    AssetsLoader.shadow.draw(batcher, highScore, (136 / 2)
                            - (3 * highScore.length()), 128);
                    AssetsLoader.font.draw(batcher, highScore, (136 / 2)
                            - (3 * highScore.length() - 1), 127);
	            }
	                
	            }
// Converting our score int into String we can display
	        String score = mWorld.getScore() + "";
// Drawing shadows first
	        AssetsLoader.shadow.draw(batcher,"U"+" "+ "ScoRed"+" " + mWorld.getScore(), (136 / 2)-45 , 8);
// Then drawing text
	        AssetsLoader.font.draw(batcher, "U"+" "+"ScoRed"+" " + mWorld.getScore(), (136 / 2)-48  , 6);
	        batcher.end();

	        
	        
	        
	    }     	
	    	
}