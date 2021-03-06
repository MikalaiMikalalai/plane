package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class MyGdxGame extends ApplicationAdapter implements InputProcessor {

	SpriteBatch spriteBatch;
	private float ellapsedGameTime;
	private Hero myHero;
	private World world;
	private float scaleFactorX, scaleFactorY;

	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		scaleFactorX = Gdx.graphics.getWidth() / 16; 
		scaleFactorY = Gdx.graphics.getWidth() / 9;
		world = new World(new Vector2(0f, -9.8f), false);
		myHero = new Hero();
		myHero.init("hero_sprites.png", new Vector2(0, 0), world, scaleFactorX, scaleFactorY);
		Gdx.input.setInputProcessor(myHero);
		ellapsedGameTime = 0f;
	}

	public void update(float deltaTime) {
		world.step(deltaTime, 6, 2);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ellapsedGameTime += Gdx.graphics.getDeltaTime();
		spriteBatch.begin();
		myHero.draw(spriteBatch, ellapsedGameTime);
		spriteBatch.end();
		
		// update world temporary for testing
		update(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose() {
		myHero.dispose();
		spriteBatch.dispose();
		world.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false; 
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		// currentAnimation = standingAnimation;
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
