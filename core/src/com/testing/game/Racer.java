package com.testing.game;

/**
 * Created by connor on 7/30/17.
 */
import java.lang.System;
import java.lang.String;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
public class Racer {
    float speed;
    float maxSpeed;
    float width;
    float height;
    Texture texture;
    Sprite sprite;

    public Racer(){
        this.speed = 0;
        this.maxSpeed = 30;
        this.width = 300;
        this.height = 300;
        this.texture = null;
        this.sprite = null;

    }
    public Texture getTexture(){
        return texture;
    }

    public Texture setTexture(String imageName){
        texture = new Texture(Gdx.files.internal(imageName));
        return texture;
    }

    public Sprite getSprite(){
        return sprite;
    }

    public Sprite setSprite(Texture newTexture){
        sprite = new Sprite(newTexture,20,20,50,50);
        return sprite;
    }

    public float getSpeed(){
        return speed;
    }

    public float getMaxSpeed(){
        return maxSpeed;
    }

    public boolean checkMaxSpeed(){
        if(this.speed <= this.maxSpeed){
            return false;
        }
        else{
            return true;
        }
    }

}
