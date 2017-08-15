package com.testing.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.GLFrameBuffer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.testing.game.Racer;
import com.testing.game.Player;


public class MyGdxGame extends ApplicationAdapter{
	SpriteBatch batch;
	Texture img;
	TiledMap tiledMap;
	OrthographicCamera camera;
	TiledMapRenderer tiledMapRenderer;
	Player player;
	SpriteBatch spriteBatch;
	@Override
	public void create () {
		float width = Gdx.graphics.getWidth();
		float height = Gdx.graphics.getHeight();
		camera = new OrthographicCamera();
		camera.setToOrtho(false,1024,1024);
		camera.update();
		tiledMap = new TmxMapLoader().load("RaceTrack.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		spriteBatch = new SpriteBatch();
		player = new Player(tiledMap,spriteBatch);
		//spriteBatch.draw(player.racer.texture, 500,500);
		Gdx.input.setInputProcessor(player);
	}


	public void createMap(){
		MapProperties map = new MapProperties();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		camera.update();
		tiledMapRenderer.setView(camera);
		tiledMapRenderer.render();
		spriteBatch.begin();
		spriteBatch.draw(player.racer.texture,1000,1000);
		player.racer.sprite.draw(spriteBatch);
		spriteBatch.end();

	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
