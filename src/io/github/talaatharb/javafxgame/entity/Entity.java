package io.github.talaatharb.javafxgame.entity;

import io.github.talaatharb.javafxgame.graphics.Screen;
import io.github.talaatharb.javafxgame.level.GameLevel;

public interface Entity {

	public abstract void render(Screen screen);

	public abstract void setLevel(GameLevel gameLevel);

	public abstract void update(double t);

}
