/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import com.badlogic.gdx.Gdx;
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
public class Menu implements Screen {
    
    private TheBreakingBones game;
    private OrthographicCamera camera;
    
    private Texture texture_novojogo;
    private Texture texture_dificuldade;
    private Texture texture_ajuda;
    private Texture texture_sair;
    private Sprite sprite_novojogo;
    private Sprite sprite_dificuldade;
    private Sprite sprite_ajuda;
    private Sprite sprite_sair;
    
    public Menu(TheBreakingBones game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        
        
    }
    
    
    @Override
    public void show() {
        texture_sair = new Texture("sair.png");
        sprite_sair = new Sprite(texture_sair);
        sprite_sair.setOrigin(sprite_sair.getWidth()/2, sprite_sair.getHeight()/2);
        sprite_sair.setPosition(((Gdx.graphics.getWidth()/2) - (texture_sair.getWidth()/2)), 60);
        
        texture_ajuda = new Texture("ajuda.png");
        sprite_ajuda = new Sprite(texture_ajuda);
        sprite_ajuda.setOrigin(sprite_ajuda.getWidth()/2, sprite_ajuda.getHeight()/2);
        sprite_ajuda.setPosition(((Gdx.graphics.getWidth()/2) - (texture_ajuda.getWidth()/2)), 160);
        
        texture_dificuldade = new Texture("dificuldade.png");
        sprite_dificuldade = new Sprite(texture_dificuldade);
        sprite_dificuldade.setOrigin(sprite_dificuldade.getWidth()/2, sprite_dificuldade.getHeight()/2);
        sprite_dificuldade.setPosition(((Gdx.graphics.getWidth()/2) - (texture_dificuldade.getWidth()/2)), 260);
        
        texture_novojogo = new Texture("novojogo.png");
        sprite_novojogo = new Sprite(texture_novojogo);
        sprite_novojogo.setOrigin(sprite_novojogo.getWidth()/2, sprite_novojogo.getHeight()/2);
        sprite_novojogo.setPosition(((Gdx.graphics.getWidth()/2) - (texture_novojogo.getWidth()/2)), 360);
        
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        //game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        sprite_sair.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_ajuda.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_dificuldade.draw(game.batch);
        game.batch.end();
        
        game.batch.begin();
        sprite_novojogo.draw(game.batch);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            game.setScreen(new Jogo(game));
            dispose();
        }
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
        
    }
    
}
