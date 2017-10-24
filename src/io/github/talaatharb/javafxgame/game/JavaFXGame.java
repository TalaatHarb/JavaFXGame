package io.github.talaatharb.javafxgame.game;

import io.github.talaatharb.javafxgame.entity.Renderable;
import io.github.talaatharb.javafxgame.entity.Updatable;
import io.github.talaatharb.javafxgame.graphics.Renderer;
import io.github.talaatharb.javafxgame.graphics.Renderer2D;
import io.github.talaatharb.javafxgame.input.GameInput;
import io.github.talaatharb.javafxgame.scene.GameScene;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;

public class JavaFXGame implements Runnable, Updatable, Renderable {

	public final static int DEFAULT_HEIGHT = 360;
	public final static String DEFAULT_TITLE = "Game";
	public final static int DEFAULT_WIDTH = 640;
	protected static final double NANO_CONVERT = 1000000000.0;
	private final Canvas canvas;
	private volatile GameScene gameScene;
	private final int height;
	protected final GameInput input;
	private final Renderer renderer;
	private final Group root;
	private final Scene scene;
	private final String title;
	private final int width;

	public JavaFXGame(GameScene gameScene) {
		this(DEFAULT_TITLE, DEFAULT_WIDTH, DEFAULT_HEIGHT, gameScene);
	}

	public JavaFXGame(final String title, final int width, final int height, final GameScene gameScene) {
		this.title = title;
		this.width = width;
		this.height = height;
		this.gameScene = gameScene;
		input = new GameInput();
		this.gameScene.setConfiguration(this);
		root = new Group();
		canvas = new Canvas(width, height);
		root.getChildren().add(canvas);
		scene = new Scene(root);
		renderer = new Renderer2D(canvas.getGraphicsContext2D(), width, height);
		initInput();
	}

	public int getHeight() {
		return height;
	}

	public GameInput getInput() {
		return input;
	}

	public Scene getScene() {
		return scene;
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
				input.press(e.getCode());
			}
		});

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				input.release(e.getCode());
			}
		});
	}

	@Override
	public void render(Renderer renderer) {
		renderer.clear();
		gameScene.render(renderer);
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
				render(renderer);
			}
		}.start();
	}

	public synchronized void setGameScene(final GameScene gameScene) {
		gameScene.setConfiguration(this);
		this.gameScene = gameScene;
	}

	public void start() {
		new Thread(this).start();
	}

	@Override
	public void update(final double t) {
		updateInput();
		gameScene.update(t);
	}

	protected void updateInput() {
		
	}
}
