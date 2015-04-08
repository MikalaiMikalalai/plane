package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.GameCharacter.Direction;

public class Hero extends GameCharacter {

	private Texture sprite;
	private Animation currentAnimation,
			standAnimation, jumpAnimation,
			runAnimation, kickAnimation;
	private TextureRegion[][] regions;
	private TextureRegion currentFrame;
	private Direction direction;

	@Override
	public void init(String spriteName, Vector2 position) {
		// TODO Auto-generated method stub
		drawRectangle = new Rectangle();
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

	}

	@Override
	public void draw(SpriteBatch spriteBatch, float ellapsedGameTime) {
		// TODO Auto-generated method stub
		currentFrame = currentAnimation.getKeyFrame(ellapsedGameTime, true);
		if (direction == Direction.Right) {
			spriteBatch.draw(currentFrame,
					drawRectangle.x + currentFrame.getRegionWidth(), drawRectangle.y, -currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
		} else {
			spriteBatch.draw(currentFrame,
					drawRectangle.x, drawRectangle.y, currentFrame.getRegionWidth(), currentFrame.getRegionHeight());
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
		kickAnimation = createAnimation(regions, 3, 5);
	}

}
