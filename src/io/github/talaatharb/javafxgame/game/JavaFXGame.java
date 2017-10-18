package io.github.talaatharb.javafxgame.game;

import io.github.talaatharb.javafxgame.graphics.Screen;
import io.github.talaatharb.javafxgame.input.GameInput;
import io.github.talaatharb.javafxgame.level.GameLevel;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;

public class JavaFXGame implements Runnable {

	public final static int DEFAULT_HEIGHT = 360;
	public final static String DEFAULT_TITLE = "Game";
	public final static int DEFAULT_WIDTH = 640;
	protected static final double NANO_CONVERT = 1000000000.0;
	private final Canvas canvas;
	private final int height;
	private final GameInput input;
	private volatile GameLevel level = GameLevel.DEFAULT_LEVEL;
	private final Group root;
	private final Scene scene;
	private final Screen screen;
	private final String title;
	private final int width;

	public JavaFXGame(GameLevel level) {
		this(DEFAULT_TITLE, DEFAULT_WIDTH, DEFAULT_HEIGHT, level);
	}

	public JavaFXGame(String title, int width, int height, GameLevel level) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.level = level;
		input = new GameInput();
		level.setConfiguration(this);
		root = new Group();
		canvas = new Canvas(width, height);
		root.getChildren().add(canvas);
		scene = new Scene(root);
		screen = new Screen(canvas.getGraphicsContext2D(), width, height);
		initInput();
	}

	public Scene getGameScene() {
		return scene;
	}

	public int getHeight() {
		return height;
	}

	public GameInput getInput() {
		return input;
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	private void initInput() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				input.press(e.getCode().toString());
			}
		});

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				input.release(e.getCode().toString());
			}
		});
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
				t = (currentNanoTime - startTime) / NANO_CONVERT;
				update(t);
				render();
			}
		}.start();
	}

	public void start() {
		new Thread(this).start();
	}

	protected void update(final double t) {
		level.update(t);
	}
}
