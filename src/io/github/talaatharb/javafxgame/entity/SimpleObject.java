package io.github.talaatharb.javafxgame.entity;

import java.util.Random;

import io.github.talaatharb.javafxgame.graphics.Screen;
import io.github.talaatharb.javafxgame.level.GameLevel;
import javafx.scene.paint.Color;

public class SimpleObject implements Entity {

	private final static double SIZE = 20.0;
	private final static double SPEED = 3.0;
	private GameLevel level;
	private double x = 30.0;
	private double xSpeed;
	private double y = 30.0;
	private double ySpeed;
	private Random random;
	private Color color;

	public SimpleObject() {
		random = new Random();
		xSpeed = random.nextDouble() * 2 * SPEED - SPEED;
		ySpeed = random.nextDouble() * 2 * SPEED - SPEED;
		color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), random.nextDouble());
	}

	@Override
	public void render(final Screen screen) {
		screen.renderFillRect(x, y, SIZE, SIZE, color);
	}

	@Override
	public void setLevel(final GameLevel gameLevel) {
		this.level = gameLevel;
		x = random.nextDouble() * (level.getWidth() - x) + x;
		y = random.nextDouble() * (level.getHeight() - y) + y;
	}

	@Override
	public void update(final double t) {
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
