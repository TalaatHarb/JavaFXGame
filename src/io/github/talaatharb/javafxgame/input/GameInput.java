package io.github.talaatharb.javafxgame.input;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyCode;

public class GameInput {

	private final static int DEFAULT_SIZE = 3;

	private final List<KeyCode> keys;

	public GameInput() {
		keys = new ArrayList<KeyCode>(DEFAULT_SIZE);
	}

	public final boolean isKeyPressed(KeyCode keyCode) {
		return keys.contains(keyCode);
	}

	public final void press(KeyCode keyCode) {
		if (!keys.contains(keyCode)) {
			keys.add(keyCode);
		}
	}

	public void release(KeyCode keyCode) {
		keys.remove(keyCode);
	}
}
