package com.Choppy.screens;

import com.Choppy.gameworld.GameRenderer;
import com.Choppy.gameworld.GameWorld;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GameScreen implements Screen{

    private GameWorld world;
    private GameRenderer renderer;


    public GameScreen(){
        world = new GameWorld(); // initialize world
        renderer = new GameRenderer(world); // initialize renderer
        Gdx.app.log("GameScreen", "Attached");
    }

    @Override
    public void show() {

        Gdx.app.log("GameScreen", "show called");
    }

    @Override
    public void render(float delta) {
       world.update(delta); // update GameWorld
        renderer.render(); // GameRenderer renders
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
