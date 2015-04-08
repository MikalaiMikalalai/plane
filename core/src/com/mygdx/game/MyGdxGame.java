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
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor{
	
	SpriteBatch spriteBatch;	
	private float ellapsedGameTime;
	private float positionX;
	private float positionY;
	private TextureRegion[][] regions;
	private Hero myHero;
	
	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		myHero = new Hero();
		myHero.init("hero_sprites.png", new Vector2(0, 0));
		
		Gdx.input.setInputProcessor(this);
		ellapsedGameTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ellapsedGameTime += Gdx.graphics.getDeltaTime();		
		spriteBatch.begin();
		myHero.draw(spriteBatch, ellapsedGameTime);
		spriteBatch.end();
	}
	@Override
	public void dispose() {
		myHero.dispose();
		spriteBatch.dispose();		
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
