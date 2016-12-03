package com.example.javafxgame.game;

import com.example.javafxgame.graphics.Screen;
import com.example.javafxgame.input.GameInput;
import com.example.javafxgame.level.GameLevel;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;

public class JavaFXGame implements Runnable {

	public final static int DEFAULT_HEIGHT = 360;
	public final static String DEFAULT_TITLE = "Game";
	public final static int DEFAULT_WIDTH = 640;
	protected static final double NANO_CON = 1000000000.0;
	private Canvas canvas;
	private final int height;
	private GameInput input;
	private volatile GameLevel level = GameLevel.DEFAULT_LEVEL;
	private Group root;

	private Scene scene;

	private Screen screen;
	private final String title;
	private final int width;

	public JavaFXGame(GameLevel level) {
		this(DEFAULT_TITLE, DEFAULT_WIDTH, DEFAULT_HEIGHT, level);
	}
	
	public Scene getGameScene(){
		return scene;
	}

	public JavaFXGame(String title, int width, int height, GameLevel level) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.level = level;
		input = new GameInput();
		level.setInput(input);
		createNodes();
		screen = new Screen(canvas.getGraphicsContext2D(), width, height);
	}

	private final void createNodes() {
		root = new Group();
		canvas = new Canvas(width, height);
		root.getChildren().add(canvas);
		scene = new Scene(root);
	}

	public int getHeight() {
		return height;
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	protected void render() {
		screen.clear();
		level.render(screen);
	}

	@Override
	public void run() {

		final long startTime = System.nanoTime();
		new AnimationTimer() {
			private double t;

			@Override
			public void handle(long currentNanoTime) {
				t = (currentNanoTime - startTime) / NANO_CON;
				update(t);
				render();
			}
		}.start();

	}

	public void start() {
		new Thread(this).start();
	}


	protected void update(double t) {
		updateInput();
		level.update(t);
	}

	private void updateInput() {
		// TODO: Handle user input
	}
}
