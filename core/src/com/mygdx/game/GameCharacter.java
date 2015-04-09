package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class GameCharacter {
	
	public Rectangle drawRectangle;
	public World world;
	public Body body;
	
	public void init(String sprite, Vector2 position, World world) {
	}

	public void update(int deltaTime) {
	}

	public void draw(SpriteBatch spriteBatch,float ellapsedGameTime) {

	}
	public void dispose() {
		
	}
	public Animation createAnimation(TextureRegion[][] regions, int animationRowNumber, int numberOfFrames) {		
		TextureRegion[] animationRegion = new TextureRegion[numberOfFrames];		
		for (int i = 0; i < numberOfFrames; i++) {
			animationRegion[i] = regions[animationRowNumber][i];			
		}
		Animation animation = new Animation(0.100f, animationRegion);		
		return animation;		
	}
	
	public Body createBody(BodyType bodyType, Vector2 bodyPosition, float width, float height) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(bodyPosition);
		Body body = world.createBody(bodyDef);
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width, height);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		fixtureDef.density = 1f;
		Fixture fixture = body.createFixture(fixtureDef);
		shape.dispose();
		return body;		
	}
	
	public enum Direction {
		Left, Right
	}
}
