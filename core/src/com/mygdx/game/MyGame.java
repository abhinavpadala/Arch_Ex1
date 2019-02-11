package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;


public class MyGame extends ApplicationAdapter implements InputProcessor {

	public static final int WIDTH = 400;
	public static final int HEIGHT = 600;
	Chopper chopper;
	public int screenx, screeny;

	@Override
	public void create () {
		chopper = Chopper.getInstance();
		chopper.sprite.setPosition(Gdx.graphics.getWidth() / 2 - chopper.sprite.getWidth() / 2,
				Gdx.graphics.getHeight() / 2 - chopper.sprite.getHeight() / 2);
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		chopper.draw();

	}

	@Override
	public void dispose () {
		chopper.dispose();
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
		screeny = Gdx.graphics.getHeight() - screenY;
		if(screenx >= (400-chopper.sprite.getWidth()) || screenx <= 0 || screeny >= (600-chopper.sprite.getHeight()) || screeny <= 0){
			return false;
		}
		chopper.sprite.setPosition(screenx, screeny);
		System.out.println(screenx + " " + screeny);
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