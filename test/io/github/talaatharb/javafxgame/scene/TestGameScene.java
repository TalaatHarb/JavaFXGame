package io.github.talaatharb.javafxgame.scene;

import java.util.ArrayList;

import io.github.talaatharb.javafxgame.entity.Entity;
import io.github.talaatharb.javafxgame.entity.SimpleTestObject;
import io.github.talaatharb.javafxgame.entity.SimpleTestPlayer;
import io.github.talaatharb.javafxgame.graphics.Renderer;
import javafx.scene.paint.Color;

public class TestGameScene extends GameScene {

	private Color backgroundColor;

	public TestGameScene(final Color color, int count) {
		this.backgroundColor = color;
		entities = new ArrayList<Entity>();
		addEntity(new SimpleTestPlayer());
		for (int i = 0; i < count; i++) {
			addEntity(new SimpleTestObject());
		}
	}

	@Override
	protected void renderBackground(final Renderer renderer) {
		renderer.renderFillRect(30, 30, 480, 300, backgroundColor);
		renderer.renderRect(29, 29, 481, 301, Color.RED, 2);
	}
}
