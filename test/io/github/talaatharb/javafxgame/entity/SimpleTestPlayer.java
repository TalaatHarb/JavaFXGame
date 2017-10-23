package io.github.talaatharb.javafxgame.entity;

import io.github.talaatharb.javafxgame.graphics.Renderer;
import io.github.talaatharb.javafxgame.input.GameInput;
import io.github.talaatharb.javafxgame.scene.GameScene;
import javafx.scene.paint.Color;

public class SimpleTestPlayer implements Entity {

	private final static double SIZE = 20.0;
	private final static double SPEED = 3.0;
	private GameScene gameScene;
	private double x = 30.0;
	private double xSpeed = SPEED;
	private double y = 30.0;
	private double ySpeed = SPEED;

	@Override
	public void render(final Renderer renderer) {
		renderer.renderFillRect(x, y, SIZE, SIZE, Color.CORNFLOWERBLUE);
	}

	@Override
	public void setGameScene(final GameScene gameScene) {
		this.gameScene = gameScene;
	}

	@Override
	public void update(final double t) {
		// Input
		if (gameScene.getInput().isKeyPressed(GameInput.KEY_DOWN)) {
			ySpeed = SPEED;
		} else if (gameScene.getInput().isKeyPressed(GameInput.KEY_UP)) {
			ySpeed = -SPEED;
		} else if (gameScene.getInput().isKeyPressed(GameInput.KEY_LEFT)) {
			xSpeed = -SPEED;
		} else if (gameScene.getInput().isKeyPressed(GameInput.KEY_RIGHT)) {
			xSpeed = SPEED;
		}

		// Update position
		x += xSpeed;
		y += ySpeed;

		if (x < 30.0) {
			x = 30.0;
			xSpeed = -xSpeed;
		}
		if (y < 30.0) {
			y = 30.0;
			ySpeed = -ySpeed;
		}
		if (y > 310.0) {
			y = 310.0;
			ySpeed = -ySpeed;
		}
		if (x > 490.0) {
			x = 490.0;
			xSpeed = -xSpeed;
		}
	}

}
