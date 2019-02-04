package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

//https://www.gamefromscratch.com/post/2015/02/27/LibGDX-Video-Tutorial-Sprite-Animation.aspx

public class Chopper{

    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;
    SpriteBatch batch;
    Sprite sprite;
    Texture img;
    TextureRegion[] animationFrames;
    Animation animation;
    float elapsedTime;

    public  Vector2 position;
    public Vector2 velocity;

    Chopper (Vector2 startpos, Vector2 startVel) {
        position = startpos;
        velocity = startVel;
        batch = new SpriteBatch();
        img = new Texture("helis.png");

        TextureRegion[][] tmpFrames = TextureRegion.split(img, 162, 65); // 2*2 grid for animation

        animationFrames = new TextureRegion[4]; //total number of images in sprite sheet
        int index = 0;

        for(int i = 0; i < 2; i++){
            for(int j=0; j < 2; j++){
                animationFrames[index++] = tmpFrames[i][j]; //loop through rows and columns in sprite sheet
                //sprite = new Sprite(animationFrames[index]);
            }
        }
        animation = new Animation(0.10f, animationFrames); // 10 frames per second
    }

    public void updatePosition(){
        position = new Vector2(position.x + velocity.x, position.y + velocity.y);
    }

    public Vector2 getPosition(){
        return position;
    }

    public Vector2 getVelocity(){
        return velocity;
    }

    public void changeDirectionX(){
        velocity.x *= -1;
    }

    public void changeDirectionY(){
        velocity.y *= -1;
    }


    public void draw () {
        elapsedTime += Gdx.graphics.getDeltaTime();
        //sprite.flip(velocity.x >= 0, false);
        batch.begin();
        batch.draw((TextureRegion) animation.getKeyFrame(elapsedTime, true), position.x, position.y);
        batch.end();
        //System.out.println(position);
    }

    public void dispose () {
        batch.dispose();
        img.dispose();
    }
}