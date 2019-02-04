package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MyGame extends ApplicationAdapter {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	Chopper c;
	private List<Chopper> choppers = new ArrayList<Chopper>();


	private float X = 0;
	private float Y = 0;

	private float DX = 2;
	private float DY = 3;

	@Override
	public void create() {

		// choppers with different initial position values
		for (int i = 0; i <= 2; i++) {
			Chopper c = new Chopper(
					new Vector2(i * 40, i * 100),
					new Vector2(1, 2)
			);
			choppers.add(c);
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		for (Chopper c : choppers) {
			if (c.getPosition().x >= Gdx.graphics.getWidth() - 162 || c.getPosition().x < 0) {
				c.changeDirectionX();
			}
			if (c.getPosition().y >= Gdx.graphics.getHeight() - 65 || c.getPosition().y < 0) {
				c.changeDirectionY();
			}
			c.updatePosition();
		}

		for (Chopper c : choppers) {
			c.draw();
		}

	}

	@Override
	public void dispose() {
		//batch.dispose();
		for (Chopper c : choppers) {
			c.dispose();
		}
	}

}

