package io.github.talaatharb.javafxgame.level;

import java.util.ArrayList;
import java.util.List;

import io.github.talaatharb.javafxgame.entity.Entity;
import io.github.talaatharb.javafxgame.entity.SimpleObject;
import io.github.talaatharb.javafxgame.entity.SimpleTestPlayer;
import io.github.talaatharb.javafxgame.game.JavaFXGame;
import io.github.talaatharb.javafxgame.graphics.Screen;
import io.github.talaatharb.javafxgame.input.GameInput;
import javafx.application.Platform;
import javafx.scene.paint.Color;

public class GameLevel implements Entity {

	public static final GameLevel DEFAULT_LEVEL = new GameLevel();

	private final static int COUNT = 100;

	private final List<Entity> entities;
	private GameInput input;

	private double screenHeight;

	private double screenWidth;

	public GameLevel() {
		entities = new ArrayList<Entity>();
		addEntity(new SimpleTestPlayer());
		for (int i = 0; i < COUNT; i++) {
			addEntity(new SimpleObject());
		}
	}

	public void addEntity(final Entity entity) {
		entities.add(entity);
		entity.setLevel(this);
	}

	public double getHeight() {
		return screenHeight;
	}

	public GameInput getInput() {
		return input;
	}

	public double getWidth() {
		return screenWidth;
	}

	@Override
	public void render(final Screen screen) {

		// Render Background
		screen.renderFillRect(30, 30, 480, 300, Color.WHITE);
		// screen.renderRect(29, 29, 481, 301, Color.RED, 1);

		// Render Entities
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}

	public void setConfiguration(final JavaFXGame game) {
		this.input = game.getInput();
		this.screenWidth = game.getWidth();
		this.screenHeight = game.getHeight();
	}

	@Override
	public void setLevel(GameLevel gameLevel) {
	}

	@Override
	public void update(final double t) {
		if (input.isKeyPressed(GameInput.KEY_ESC)) {
			Platform.exit();
			System.exit(0);
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(t);
		}
	}

}
