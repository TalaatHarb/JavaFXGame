package io.github.talaatharb.javafxgame;

import io.github.talaatharb.javafxgame.game.JavaFXGame;
import io.github.talaatharb.javafxgame.scene.TestGameScenes;
import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JavaFXGameTest extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws RuntimeException {
		try {
			JavaFXGame game = new JavaFXGame(TestGameScenes.TEST_SCENE01) {

				@Override
				protected void updateInput() {
					if (input.isKeyPressed(KeyCode.DIGIT0)) {
						setGameScene(TestGameScenes.TEST_SCENE00);
					}
					if (input.isKeyPressed(KeyCode.DIGIT1)) {
						setGameScene(TestGameScenes.TEST_SCENE01);
					}
				}
			};
			primaryStage.setScene(game.getScene());
			primaryStage.setTitle(game.getTitle());
			// primaryStage.setAlwaysOnTop(true);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			game.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
