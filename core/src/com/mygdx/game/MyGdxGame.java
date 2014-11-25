package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;	
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Texture img;
	private Animation standingAnimation;
	private TextureRegion currentFrame;
	private float stateTime;
	private Animation currentAnimation;
	private Animation jumpingAnimation;
	private Animation kickAnimation;
	private Animation runningAnimation;
	private float positionX;
	private float positionY;
	private TextureRegion[][] regions;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture(Gdx.files.internal("hero_sprites.png"));
		regions = new TextureRegion(img).split(img.getWidth()/6, img.getHeight()/4);
		TextureRegion[] standingAnimationRegion = new TextureRegion[5];
		
		for(int i = 0; i<5; i++){
			standingAnimationRegion[i] = regions[0][i];
		}
		
		TextureRegion[] jumpingAnimationRegion = new TextureRegion[5];
		
		for(int i = 0; i<5; i++){
			jumpingAnimationRegion[i] = regions[1][i];
		}
		
		
		TextureRegion[] runningAnimationRegion = new TextureRegion[6];
		
		for(int i = 0; i<6; i++){
			runningAnimationRegion[i] = regions[2][i];
		}
		
		TextureRegion[] kickAnimationRegion = new TextureRegion[5];
		
		for(int i = 0; i<5; i++){
			kickAnimationRegion[i] = regions[3][i];
		}
		
		standingAnimation = new Animation(0.100f, standingAnimationRegion);
		jumpingAnimation = new Animation(0.100f, jumpingAnimationRegion);
		kickAnimation = new Animation(0.100f, kickAnimationRegion);
		runningAnimation = new Animation(0.100f, runningAnimationRegion);
		
		currentAnimation = standingAnimation;
		Gdx.input.setInputProcessor(this);
		stateTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		
		currentFrame = currentAnimation.getKeyFrame(stateTime, true); 
		batch.begin();
		
		if (Gdx.input.isKeyPressed(Keys.A)) {
			currentAnimation = runningAnimation;
			positionX -= 300f * Gdx.graphics.getDeltaTime();
		}
		else if (Gdx.input.isKeyPressed(Keys.D)) {
			currentAnimation = runningAnimation;
			positionX += 300f * Gdx.graphics.getDeltaTime();
		}
		batch.draw(currentFrame, positionX, 0);
		batch.end();
	}
	@Override
	public void dispose() {
		img.dispose();
		batch.dispose();		
	};
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
//		switch(keycode){
//		case Keys.A: currentAnimation = runningAnimation;
//					 positionX -= 200f * Gdx.graphics.getDeltaTime();
//					 break;
//		case Keys.D: currentAnimation = runningAnimation;
//		 			 positionX += 200f * Gdx.graphics.getDeltaTime();
//		 			 break;
//		case Keys.SPACE: currentAnimation = jumpingAnimation;
//					 break;
//		case Keys.CONTROL_LEFT:
//		case Keys.CONTROL_RIGHT: currentAnimation = kickAnimation;
//					 break;
//		 			 
//		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
//		currentAnimation = standingAnimation;		
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
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
