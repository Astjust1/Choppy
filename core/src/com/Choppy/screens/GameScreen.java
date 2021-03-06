package com.Choppy.screens;

import com.Choppy.cbhelpers.InputHandler;
import com.Choppy.gameworld.GameRenderer;
import com.Choppy.gameworld.GameWorld;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen{

    private GameWorld world;
    private GameRenderer renderer;
    private float runTime;


    public GameScreen(){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight / (screenWidth/gameWidth);

        int midPointY = (int) (gameHeight/2);

        world = new GameWorld(midPointY); // initialize world
        renderer = new GameRenderer(world, (int) gameHeight, midPointY); // initialize renderer

        Gdx.input.setInputProcessor(new InputHandler(world.getBird()));

    }

    @Override
    public void show() {

        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
        runTime += delta;
       world.update(delta); // update GameWorld
        renderer.render(runTime); // GameRenderer renders
    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resize called");

    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");

    }

    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");

    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");

    }

    @Override
    public void dispose() {

    }
}
