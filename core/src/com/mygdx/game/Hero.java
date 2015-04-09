package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

public class Hero extends GameCharacter implements InputProcessor{

	private Texture sprite;
	private Animation currentAnimation, standAnimation, jumpAnimation,
			runAnimation, punchAnimation;
	private TextureRegion[][] regions;
	private TextureRegion currentFrame;
	private Direction direction;

	@Override
	public void init(String spriteName, Vector2 position, World world) {
		// TODO Auto-generated method stub
		drawRectangle = new Rectangle();
		super.world = world;
		super.body = createBody(BodyDef.BodyType.DynamicBody,
				new Vector2().setZero(), 1f, 1.7f);
		createAnimations(spriteName);
		direction = Direction.Right;
		currentAnimation = standAnimation;
		drawRectangle.x = position.x;
		drawRectangle.y = position.y;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		sprite.dispose();
	}

	@Override
	public void update(int deltaTime) {
		// TODO Auto-generated method stub
		
		drawRectangle.x = body.getPosition().x;
		drawRectangle.y = body.getPosition().y;
	}

	@Override
	public void draw(SpriteBatch spriteBatch, float ellapsedGameTime) {
		// TODO Auto-generated method stub
		currentFrame = currentAnimation.getKeyFrame(ellapsedGameTime, true);
		if (direction == Direction.Right) {
			spriteBatch.draw(currentFrame,
					drawRectangle.x + currentFrame.getRegionWidth(),
					drawRectangle.y, -currentFrame.getRegionWidth(),
					currentFrame.getRegionHeight());
		} else {
			spriteBatch.draw(currentFrame, drawRectangle.x, drawRectangle.y,
					currentFrame.getRegionWidth(),
					currentFrame.getRegionHeight());
		}

	}

	private void createAnimations(String spriteName) {
		// Load sprite with animation
		sprite = new Texture(Gdx.files.internal(spriteName));

		regions = new TextureRegion(sprite).split(sprite.getWidth() / 6,
				sprite.getHeight() / 4);

		// Create animations for hero standing
		standAnimation = createAnimation(regions, 0, 5);

		// Create animations for hero jumping
		jumpAnimation = createAnimation(regions, 1, 5);

		// Create animation for hero running
		runAnimation = createAnimation(regions, 2, 6);

		// Create animation for hero kicking
		punchAnimation = createAnimation(regions, 3, 5);
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		switch(keycode){
		 case Keys.A: body.applyForceToCenter(new Vector2(-5f, 0f), true);		 
		 break;
		 case Keys.D: body.applyForceToCenter(new Vector2(5f, 0f), true);
		 break;
		 case Keys.SPACE: body.applyForceToCenter(new Vector2(0f, 5f), true);
		 break;	
		 }
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		switch(keycode){
		 case Keys.A: body.applyForceToCenter(new Vector2(5f, 0f), true);		 
		 break;
		 case Keys.D: body.applyForceToCenter(new Vector2(-5f, 0f), true);
		 break;
		 case Keys.CONTROL_LEFT:
		 case Keys.CONTROL_RIGHT: 
		 break;		
		 }
		return true;
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
