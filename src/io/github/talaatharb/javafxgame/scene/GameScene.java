package io.github.talaatharb.javafxgame.scene;

import java.util.List;

import io.github.talaatharb.javafxgame.entity.Entity;
import io.github.talaatharb.javafxgame.entity.Renderable;
import io.github.talaatharb.javafxgame.entity.Updatable;
import io.github.talaatharb.javafxgame.game.JavaFXGame;
import io.github.talaatharb.javafxgame.graphics.Renderer;
import io.github.talaatharb.javafxgame.input.GameInput;
import javafx.application.Platform;
import javafx.scene.input.KeyCode;

public abstract class GameScene implements Updatable, Renderable {

	private final static double DEFAULT_H = 360.0;
	private final static double DEFAULT_W = 640.0;

	protected List<Entity> entities;
	private JavaFXGame game;

	private GameInput input;
	private double screenHeight;
	private double screenWidth;

	public GameScene() {
		this(DEFAULT_W, DEFAULT_H);
	}

	public GameScene(final double screenWidth, final double screenHeight) {
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
	}

	public void addEntity(final Entity entity) {
		entities.add(entity);
		entity.setGameScene(this);
	}

	public JavaFXGame getGame() {
		return game;
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
	public void render(final Renderer renderer) {

		// Render Background
		renderBackground(renderer);

		// Render Entities
		for (int i = entities.size() - 1; i >= 0; i--) {
			entities.get(i).render(renderer);
		}
	}

	protected abstract void renderBackground(final Renderer renderer);

	public void setConfiguration(final JavaFXGame game) {
		this.game = game;
		this.input = game.getInput();
		this.screenWidth = game.getWidth();
		this.screenHeight = game.getHeight();
	}

	@Override
	public void update(final double t) {
		// Poll inputs
		if (input.isKeyPressed(KeyCode.ESCAPE)) {
			Platform.exit();
			System.exit(0);
		}

		// Update entities
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(t);
		}
	}
}
