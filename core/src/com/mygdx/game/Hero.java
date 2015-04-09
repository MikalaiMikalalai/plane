package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;

public class Hero extends GameCharacter implements InputProcessor{
	
	private Texture sprite;
	private Animation currentAnimation, standAnimation, jumpAnimation,
			runAnimation, punchAnimation;
	private TextureRegion[][] regions;
	private TextureRegion currentFrame;
	private Direction direction;


	public void init(String spriteName, Vector2 position, World world, float scaleFactorX, float scaleFactorY) {
		// TODO Auto-generated method stub
		super.init(position, world, scaleFactorX, scaleFactorY, BodyType.DynamicBody, 1, 1.8f);		
		createAnimations(spriteName);
		direction = Direction.Right;
		currentAnimation = standAnimation;		
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
					drawRectangle.y, - drawRectangle.getWidth(),
					drawRectangle.getHeight());
		} else {
			spriteBatch.draw(currentFrame, drawRectangle.x, drawRectangle.y,
					drawRectangle.getWidth(),
					drawRectangle.getHeight());
		}
		if (currentAnimation.isAnimationFinished(ellapsedGameTime) && currentAnimation.getPlayMode() == PlayMode.NORMAL) currentAnimation = standAnimation;
	}

	private void createAnimations(String spriteName) {
		// Load sprite with animation
		sprite = new Texture(Gdx.files.internal(spriteName));

		regions = new TextureRegion(sprite).split(sprite.getWidth() / 6,
				sprite.getHeight() / 4);

		// Create animations for hero standing
		standAnimation = createAnimation(regions, 0, 5);
		standAnimation.setPlayMode(PlayMode.LOOP);

		// Create animations for hero jumping
		jumpAnimation = createAnimation(regions, 1, 5);
		jumpAnimation.setPlayMode(PlayMode.NORMAL);
		
		// Create animation for hero running
		runAnimation = createAnimation(regions, 2, 6);
		runAnimation.setPlayMode(PlayMode.LOOP);
		
		// Create animation for hero kicking
		punchAnimation = createAnimation(regions, 3, 5);
		punchAnimation.setPlayMode(PlayMode.NORMAL);
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		switch(keycode){
		 case Keys.A: body.applyForceToCenter(new Vector2(-5f, 0f), true);	
		 currentAnimation = runAnimation;
		 direction = Direction.Left;
		 break;
		 case Keys.D: body.applyForceToCenter(new Vector2(5f, 0f), true);
		 currentAnimation = runAnimation;
		 direction = Direction.Right;
		 break;
		 case Keys.SPACE: body.applyForceToCenter(new Vector2(0f, 5f), true);
		 currentAnimation = jumpAnimation;
		 break;	
		 }
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		switch(keycode){
		 case Keys.A: 			 
		 case Keys.D: body.setLinearVelocity(new Vector2().setZero());
		 currentAnimation = standAnimation;
		 break;
		 case Keys.CONTROL_LEFT:
		 case Keys.CONTROL_RIGHT: 
			 currentAnimation = punchAnimation;
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
		body.applyForceToCenter(new Vector2(5f, 0f), true);
		
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
