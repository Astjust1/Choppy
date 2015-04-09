package com.Choppy.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;


    public GameRenderer(GameWorld world){
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136,204); // half of screen size to scale everything by 2
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        myWorld = world;
    }

    public void render(){
        Gdx.app.log("GameRenderer", "render");

        /*
        1. draw a black background. This prevents flickering
         */

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        /*
        2. draw the filled rectangle
         */

        // tells shaperendererr to begin drawing filled shapes
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Chooses rgb color of 87,109,120 at full opacity
        shapeRenderer.setColor(87/255.0f, 109/255.0f, 120/255.0f, 1f);

        //draws the rectangle from my world
        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
                myWorld.getRect().width, myWorld.getRect().height);

        // tells shaprender to stop rendering
        // is a must every time
        shapeRenderer.end();

        /*
        3. draw the rectangle's outline
         */

        // Tells shaperenderer to draw and outline
        shapeRenderer.begin(ShapeType.Line);

        shapeRenderer.setColor(255/255.0f, 109/255.0f, 120/255.0f,1);

        shapeRenderer.rect(myWorld.getRect().x, myWorld.getRect().y,
                myWorld.getRect().width, myWorld.getRect().height);

        shapeRenderer.end();
    }
}
