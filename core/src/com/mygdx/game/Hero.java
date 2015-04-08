package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public class Hero extends GameClass {

	private Texture sprite;
	private Animation currentAnimation, standLeftAnimation,
			standRightAnimation, jumpLeftAnimation, jumpRightAnimetion,
			runLeftAnimation, runRightAnimation, kickLeftAnimation, kickRightAnimation;
	private TextureRegion[][] regions;

	@Override
	public void init(String spriteName, Vector2 position) {
		// TODO Auto-generated method stub

		createAnimations(spriteName);
		currentAnimation = standRightAnimation;
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
		spriteBatch.draw(currentAnimation.getKeyFrame(ellapsedGameTime), 0, 0);
	}
	
	private void createAnimations(String spriteName) {
		// Load sprite with animation
		sprite = new Texture(Gdx.files.internal(spriteName));

		regions = new TextureRegion(sprite).split(
				sprite.getWidth() / 6, sprite.getHeight() / 4);
		
		// Create animations for left and right hero standing
		standLeftAnimation = createAnimation(regions, 0, 5, Direction.Left);
		standRightAnimation = createAnimation(regions, 0, 5, Direction.Right);
		
		// Create animations for left and right hero jumping		
		jumpLeftAnimation = createAnimation(regions, 1, 5, Direction.Left);
		jumpRightAnimetion = createAnimation(regions, 1, 5, Direction.Right);
		
		// Create animation for left and right hero running
		runLeftAnimation = createAnimation(regions, 2, 6, Direction.Left);
		runRightAnimation = createAnimation(regions, 2, 6, Direction.Right);

		// Create animation for left and right hero kicking
		kickLeftAnimation = createAnimation(regions, 3, 5, Direction.Left);
		kickRightAnimation = createAnimation(regions, 3, 5, Direction.Right);
	}
	
}
