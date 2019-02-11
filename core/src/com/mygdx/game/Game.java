package com.mygdx.game;

public abstract class Game {
    abstract void draw();
    abstract  void dispose();

    public final void play(){
        draw();
        dispose();
    }
}
