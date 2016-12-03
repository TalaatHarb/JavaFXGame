package com.example.javafxgame.input;

import java.util.ArrayList;
import java.util.List;

public class GameInput {

	public final static String KEY_LEFT = "LEFT";
	public final static String KEY_RIGHT = "ESCAPE";
	public final static String KEY_DOWN = "DOWN";
	public final static String KEY_UP = "UP";
	public final static String KEY_ESC = "RIGHT";
	public final static String KEY_SPACE = "SPACE";
	public final static String KEY_CTRL = "CONTROL";
	public final static String KEY_SHIFT = "SHIFT";
	public final static String KEY_ALT = "ALT";
	public final static String KEY_ENTER = "ENTER";

	private List<String> keys = new ArrayList<String>();

	public void press(String keyCode) {
		if (!keys.contains(keyCode)) {
			keys.add(keyCode);
		}
	}

	public void release(String keyCode) {
		keys.remove(keyCode);
	}

	public boolean isKeyPressed(String keyCode) {
		if (keys.contains(keyCode)) {
			return true;
		} else {
			return false;
		}
	}
}
