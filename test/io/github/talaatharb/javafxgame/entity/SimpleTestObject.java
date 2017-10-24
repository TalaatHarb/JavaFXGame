package io.github.talaatharb.javafxgame.entity;

import java.util.Random;

import io.github.talaatharb.javafxgame.graphics.Renderer;
import io.github.talaatharb.javafxgame.scene.GameScene;
import javafx.scene.paint.Color;

public class SimpleTestObject implements Entity {

	private final static double COUNT_LIMIT = 30;
	private final static double SIZE = 20.0;
	private final static double SPEED = 3.0;
	private Color color;
	private int count;
	private Random random;
	private double x = 30.0;
	private double xOld = 30.0;
	private double xSpeed;
	private double y = 30.0;
	private double yOld = 30.0;
	private double ySpeed;

	public SimpleTestObject() {
		count = 0;
		random = new Random();
		xSpeed = random.nextDouble() * 2 * SPEED - SPEED;
		ySpeed = random.nextDouble() * 2 * SPEED - SPEED;
		color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble());
	}

	@Override
	public void render(final Renderer renderer) {
		renderer.renderFillRect(x, y, SIZE, SIZE, color);
		renderer.renderLine(xOld, yOld, x + SIZE / 2, y + SIZE / 2, color);
	}

	@Override
	public void setGameScene(final GameScene gameScene) {
		x = random.nextDouble() * (gameScene.getWidth() - x) + x;
		y = random.nextDouble() * (gameScene.getHeight() - y) + y;
	}

	@Override
	public void update(final double t) {
		if (count++ > COUNT_LIMIT) {
			count = 0;
			xOld = x + SIZE / 2;
			yOld = y + SIZE / 2;
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
