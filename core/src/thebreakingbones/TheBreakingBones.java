/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thebreakingbones;

import Telas.Menu;
import Telas.TelaAbertura;
import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


/**
 *
 * @author Matheus
 */
public class TheBreakingBones extends Game{
    
    public SpriteBatch batch;
    public BitmapFont fonte;

    @Override
    public void create() {
        batch = new SpriteBatch();
        fonte = new BitmapFont();
        
        this.setScreen(new TelaAbertura(this));
    }
    public void render(){
        super.render();
    }
    public void dispose(){
        batch.dispose();
        fonte.dispose();
    }
    
    }
