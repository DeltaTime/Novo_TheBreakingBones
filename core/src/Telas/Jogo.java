/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import thebreakingbones.TheBreakingBones;

/**
 *
 * @author Matheus
 */
public class Jogo implements Screen{
    
    private TheBreakingBones game;
    private OrthographicCamera camera;
    
    private Texture texture_player;
    private Sprite sprite_player;
    
    public Jogo(TheBreakingBones game){
        this.game = game;
        
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        
        texture_player = new Texture("player1.png");
        
        TextureRegion region_player = new TextureRegion(texture_player, 0, 0, 27, 34);
        sprite_player = new Sprite(region_player);
        sprite_player.setSize(27, 34);
        sprite_player.setOrigin(sprite_player.getWidth()/2, sprite_player.getHeight()/2);
        sprite_player.setPosition(-sprite_player.getWidth()/2, -sprite_player.getHeight()/2);
        
        
    }

    @Override
    public void show() {
        
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        sprite_player.draw(game.batch);
        game.batch.end();
        
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) 
            sprite_player.setX(sprite_player.getX()-200 * Gdx.graphics.getDeltaTime());
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) 
            sprite_player.setX(sprite_player.getX()+200 * Gdx.graphics.getDeltaTime());
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) 
            sprite_player.setY(sprite_player.getY()+200 * Gdx.graphics.getDeltaTime());
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) 
            sprite_player.setY(sprite_player.getY()-200 * Gdx.graphics.getDeltaTime());
        
    }

    @Override
    public void resize(int width, int height) {
        
    }

    @Override
    public void pause() {
        
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
        
    }

    @Override
    public void dispose() {
        texture_player.dispose();
        game.batch.dispose();
    }
    
}
