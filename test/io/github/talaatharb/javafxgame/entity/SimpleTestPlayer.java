package io.github.talaatharb.javafxgame.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import io.github.talaatharb.javafxgame.graphics.Renderer;
import io.github.talaatharb.javafxgame.scene.GameScene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class SimpleTestPlayer implements Entity {

	private final static double SIZE = 20.0;
	private final static double SPEED = 3.0;
	private GameScene gameScene;
	private Image image;
	private double x;
	private double xSpeed;
	private double y;
	private double ySpeed;

	public SimpleTestPlayer() {
		x = 30.0;
		y = 30.0;
		xSpeed = SPEED;
		ySpeed = SPEED;
		try {
			image = new Image(new FileInputStream(new File("res\\testPlayer.png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void render(final Renderer renderer) {
		renderer.renderImage(x, y, image, SIZE, SIZE);
	}

	@Override
	public void setGameScene(final GameScene gameScene) {
		this.gameScene = gameScene;
	}

	@Override
	public void update(final double t) {
		// Input
		if (gameScene.getInput().isKeyPressed(KeyCode.DOWN)) {
			ySpeed = SPEED;
		} else if (gameScene.getInput().isKeyPressed(KeyCode.UP)) {
			ySpeed = -SPEED;
		} else if (gameScene.getInput().isKeyPressed(KeyCode.LEFT)) {
			xSpeed = -SPEED;
		} else if (gameScene.getInput().isKeyPressed(KeyCode.RIGHT)) {
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
