package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends ApplicationAdapter {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	SpriteBatch batch;
	Texture img;
	Sprite sprite;

	private float X = 0;
	private float Y = 0;

	private float DX = 2;
	private float DY = 3;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("heli1.png");
		sprite = new Sprite(img);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(X <0 || X >= Gdx.graphics.getWidth() - 162){
			DX *= -1;
		}
		if(Y <0 || Y >= Gdx.graphics.getHeight() - 65){
			DY *= -1;
		}
		X += DX;
		Y += DY;
		Sprite sprite = new Sprite(img);
		sprite.flip(DX>=0, false);
		batch.begin();
		batch.draw(sprite, X, Y);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}