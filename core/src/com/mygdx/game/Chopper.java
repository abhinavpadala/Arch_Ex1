package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


//Template pattern implementation
public class Chopper extends Game {
    SpriteBatch batch;
    Sprite sprite;
    Texture img;
    private static final Chopper INSTANCE = new Chopper();

    private Chopper(){
        batch = new SpriteBatch();
        img = new Texture("chopper.png");
        sprite = new Sprite(img);

    }

    public static Chopper getInstance(){
        return INSTANCE;
    }

    public void draw(){
        batch.begin();
        batch.draw(sprite, sprite.getX(), sprite.getY());
        batch.end();
    }

    public void dispose(){
        batch.dispose();
        img.dispose();
    }
}
