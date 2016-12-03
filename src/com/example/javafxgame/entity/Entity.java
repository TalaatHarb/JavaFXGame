package com.example.javafxgame.entity;

import com.example.javafxgame.graphics.Screen;
import com.example.javafxgame.level.GameLevel;

public interface Entity {

	public abstract void render(Screen screen);

	public abstract void setLevel(GameLevel gameLevel);

	public abstract void update(double t);
	
	
}
