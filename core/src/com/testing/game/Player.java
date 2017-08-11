package com.testing.game;

/**
 * Created by connor on 7/30/17.
 */



import com.badlogic.gdx.graphics.Texture;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.MapObjects;
public class Player extends Racer implements InputProcessor{
    Racer racer;
    Object position;
    MapLayer mapProperties;
    MapObjects mapObject;
    Player(TiledMap tiledMap){
        this.racer = new Racer();
        this.racer.texture = this.racer.setTexture("car_blue_1.png");
        this.racer.sprite = this.racer.setSprite(this.racer.texture);
        mapProperties = tiledMap.getLayers().get("Player");
        mapObject = mapProperties.getObjects();
        this.position = mapObject.get("Start");
    }


    @Override
    public boolean keyDown(int keycode) {
        System.out.println(this.position);
        System.out.println("Key Typed : " + keycode);
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


}
