package com.testing.game;

/**
 * Created by connor on 7/30/17.
 */



import com.badlogic.gdx.graphics.Texture;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.MapObjects;
import com.testing.game.MyGdxGame;
import com.testing.position.Position;
public class Player extends Racer implements InputProcessor{
    Racer racer;
    Object mapPosition;
    MapLayer mapProperties;
    MapObjects mapObject;
    MyGdxGame myGdxGame;
    SpriteBatch spriteBatch;
    Position position;
    int timer = 0;
    Player(TiledMap tiledMap, SpriteBatch spriteBatch){
        this.racer = new Racer();
        this.position = new Position();
        this.racer.texture = this.racer.setTexture("car_blue_1.png");
        this.racer.sprite = this.racer.setSprite(this.racer.texture);
        mapProperties = tiledMap.getLayers().get("Player");
        mapObject = mapProperties.getObjects();
        this.mapPosition = mapObject.get("Start");
        this.spriteBatch = spriteBatch;
    }


    @Override
    public boolean keyDown(int keycode) {
        if(timer == 50){
            if(!racer.checkMaxSpeed()) {
                this.racer.speed += 1;
            }
            timer = 0;
        }
        else{
            timer += 1;
        }
        System.out.println(this.mapPosition);
        System.out.println("Key Typed : " + keycode);
        reRender();
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }
    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }
    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }
    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    //TODO bad place for function will need to work on this
    public void reRender(){
        spriteBatch.begin();
        spriteBatch.draw(racer.texture,50,50);
        this.racer.sprite.draw(spriteBatch);
        spriteBatch.end();
    }


}
