package com.example.javafxgame.level;

import java.util.ArrayList;
import java.util.List;

import com.example.javafxgame.entity.Entity;
import com.example.javafxgame.graphics.Screen;
import com.example.javafxgame.input.GameInput;

import javafx.scene.paint.Color;

public class GameLevel implements Entity {

	public static final GameLevel DEFAULT_LEVEL = new GameLevel();
	
	private List<Entity> entities;
	private GameInput input;

	public GameLevel() {
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
		entity.setLevel(this);
	}
	
	public GameInput getInput(){
		return input;
	}
	
	@Override
	public void render(Screen screen) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		screen.renderFillRect(30, 30, 480, 300, Color.BEIGE);
	}

	public void setInput(GameInput input){
		this.input = input;
	}

	@Override
	public void setLevel(GameLevel gameLevel) {		
	}

	@Override
	public void update(double t) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(t);
		}
	}

}
