package com.testing.position;

/**
 * Created by connor on 8/14/17.
 */

public class Position {
    int x;
    int y;
    public Position(){
        x = 0;
        y = 0;
    }

    int getX(){
        return this.x;
    }

    int setX(int x){
        this.x = x;
        return this.x;
    }

    int getY(){
        return this.y;
    }

    int setY(int y){
        this.y = y;
        return this.y;
    }

}
