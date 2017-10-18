package io.github.talaatharb.javafxgame.input;

import java.util.ArrayList;
import java.util.List;

public class GameInput {

	private final static int DEFAULT_SIZE = 3;
	public final static String KEY_ALT = "ALT";
	public final static String KEY_CTRL = "CONTROL";
	public final static String KEY_DOWN = "DOWN";
	public final static String KEY_ENTER = "ENTER";
	public final static String KEY_ESC = "ESCAPE";
	public final static String KEY_LEFT = "LEFT";
	public final static String KEY_RIGHT = "RIGHT";
	public final static String KEY_SHIFT = "SHIFT";
	public final static String KEY_SPACE = "SPACE";
	public final static String KEY_UP = "UP";

	private final List<String> keys;

	public GameInput() {
		keys = new ArrayList<String>(DEFAULT_SIZE);
	}

	public final boolean isKeyPressed(String keyCode) {
		return keys.contains(keyCode);
	}

	public final void press(String keyCode) {
		if (!keys.contains(keyCode)) {
			keys.add(keyCode);
		}
	}

	public void release(String keyCode) {
		keys.remove(keyCode);
	}
}
