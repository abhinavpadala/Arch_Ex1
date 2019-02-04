package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.BitmapFont;


public class MyGame extends ApplicationAdapter implements InputProcessor {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	BitmapFont font;
	private int screenx, screeny;

	@Override
	public void create() {
		batch = new SpriteBatch();
		img = new Texture("heli1.png");
		sprite = new Sprite(img);
		font = new BitmapFont();
		sprite.setPosition(Gdx.graphics.getWidth() / 2 - sprite.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - sprite.getHeight() / 2);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(sprite, sprite.getX(), sprite.getY());
		font.draw(batch, "("+ screenx +" , "+ screeny +  ")", 10, 590);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		img.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		screenx = screenX;
		screeny = Gdx.graphics.getHeight()-screenY;
		if(screenx >= (400-sprite.getWidth()) || screenx <= 0 || screeny >= (600-sprite.getHeight()) || screeny <= 0){
			return false;
		}
		sprite.setPosition(screenX, Gdx.graphics.getHeight()-screenY);
		return true;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}