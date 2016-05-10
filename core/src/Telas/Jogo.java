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
 * @author DeltaTime
 */
public class Jogo implements Screen{
    
    private TheBreakingBones game;
    private OrthographicCamera camera;
    
    private Texture texture_player;
    private Sprite sprite_player;
    private Texture texture_inimigo;
    private Sprite sprite_inimigo;
    float auxY = -1;
    float auxX = -1;


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



        texture_inimigo = new Texture("Inimigo.png");

        TextureRegion region_inimigo = new TextureRegion(texture_inimigo, 0, 0, 27, 34);
        sprite_inimigo = new Sprite(region_inimigo);
        sprite_inimigo.setSize(27, 34);
        sprite_inimigo.setOrigin(sprite_inimigo.getWidth()/2, sprite_inimigo.getHeight()/2);
        sprite_inimigo.setPosition(-sprite_inimigo.getWidth()/2, -sprite_inimigo.getHeight()/2);
        sprite_inimigo.setX(Gdx.graphics.getWidth()/2);
        sprite_inimigo.setY(Gdx.graphics.getHeight()/2);


    }

    public Jogo() {
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
        sprite_inimigo.draw(game.batch);


        game.batch.end();
        movimentacaoInimigo();


        
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
            if (sprite_player.getX() > 0 )
                sprite_player.setX(sprite_player.getX()-200 * Gdx.graphics.getDeltaTime());

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            if (sprite_player.getX() < (Gdx.graphics.getWidth() - sprite_player.getWidth()) )
                sprite_player.setX(sprite_player.getX()+200 * Gdx.graphics.getDeltaTime());

        if(Gdx.input.isKeyPressed(Input.Keys.UP))
            if (sprite_player.getY() < (Gdx.graphics.getHeight() - sprite_player.getHeight()) )
                sprite_player.setY(sprite_player.getY()+200 * Gdx.graphics.getDeltaTime());

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
            if (sprite_player.getY() > 0 )
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

    public void movimentacaoInimigo(){
            float auxYm = sprite_inimigo.getY() - sprite_player.getY();
            float auxXm = sprite_inimigo.getX() - sprite_player.getX();
            if(auxXm < 0){
                auxXm = auxXm * -1;
            }
            if(auxYm < 0){
            auxYm = auxYm * -1;
            }
            if (auxYm < 200.f && auxXm < 200.f )
                seguirJogador();

            if((auxYm < 1.f && auxXm < 1.f ))
                sprite_player.setAlpha(100);


            if ((sprite_inimigo.getY() < 0) || (sprite_inimigo.getY() > Gdx.graphics.getHeight() - sprite_inimigo.getHeight())){
                auxY = auxY * -1;
            }

        if ((sprite_inimigo.getX() < 0) || (sprite_inimigo.getX() > Gdx.graphics.getWidth() - sprite_inimigo.getWidth())){
            auxX = auxX * -1;
        }

            sprite_inimigo.setY(sprite_inimigo.getY() + auxY * 50.f * Gdx.graphics.getDeltaTime());
            sprite_inimigo.setX(sprite_inimigo.getX()+ auxX * 50.f * Gdx.graphics.getDeltaTime());

    }
    public float sprite_playerGetY(){
        return sprite_player.getY();

    }

    public float sprite_playerGetX(){
        return sprite_player.getX();

    }


    public void seguirJogador(){




        if((sprite_player.getX() - sprite_inimigo.getX()) < 0 ){
            sprite_inimigo.setX(sprite_inimigo.getX() - 50.f * Gdx.graphics.getDeltaTime());

        }else{
            sprite_inimigo.setX(sprite_inimigo.getX() + 50.f * Gdx.graphics.getDeltaTime());

        }

        if((sprite_player.getX() - sprite_inimigo.getX()) > 0 ){
            sprite_inimigo.setX(sprite_inimigo.getX() + 50.f * Gdx.graphics.getDeltaTime());

        }else{
            sprite_inimigo.setX(sprite_inimigo.getX() - 50.f * Gdx.graphics.getDeltaTime());

        }




        if((sprite_player.getY() - sprite_inimigo.getY()) < 0 ){
            sprite_inimigo.setY(sprite_inimigo.getY() - 50.f * Gdx.graphics.getDeltaTime());

        }else{
            sprite_inimigo.setY(sprite_inimigo.getY() + 50.f * Gdx.graphics.getDeltaTime());

        }

        if((sprite_player.getY() - sprite_inimigo.getY()) > 0 ){
            sprite_inimigo.setY(sprite_inimigo.getY() + 50.f * Gdx.graphics.getDeltaTime());

        }else{
            sprite_inimigo.setY(sprite_inimigo.getY() - 50.f * Gdx.graphics.getDeltaTime());

        }



    }


    
}
