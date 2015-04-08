package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class GameClass {
	public Rectangle drawRectangle;

	public void init(String sprite, Vector2 position) {
	}

	public void update(int deltaTime) {
	}

	public void draw(SpriteBatch spriteBatch,float ellapsedGameTime) {

	}
	public void dispose() {
		
	}
	public Animation createAnimation(TextureRegion[][] regions, int animationRowNumber, int numberOfFrames, Direction direction) {		
		TextureRegion[] animationRegion = new TextureRegion[numberOfFrames];		
		for (int i = 0; i < numberOfFrames; i++) {
			animationRegion[i] = regions[animationRowNumber][i];
			if (direction == Direction.Left) animationRegion[i].flip(true, false);
		}
		Animation animation = new Animation(0.100f, animationRegion);
		
		return animation;		
	}
	
	public enum Direction { Right, Left};
}
