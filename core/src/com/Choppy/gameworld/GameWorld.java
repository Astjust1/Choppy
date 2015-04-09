package com.Choppy.gameworld;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Rectangle rect = new Rectangle(0,0,17,12);

    public void update(float delta){
        Gdx.app.log("GameWorld", "update");
        ++rect.x;
        if (rect.x > 137){
            rect.x = 0;    // If x value surpasses camera width reset it
        }
    }

    public Rectangle getRect(){
        return rect;
    }
}
