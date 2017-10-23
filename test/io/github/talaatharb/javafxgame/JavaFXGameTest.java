package io.github.talaatharb.javafxgame;

import io.github.talaatharb.javafxgame.game.JavaFXGame;
import io.github.talaatharb.javafxgame.input.GameInput;
import io.github.talaatharb.javafxgame.scene.TestGameScenes;
import javafx.application.Application;
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

				private int s = 1;

				@Override
				protected void updateInput() {
					if (input.isKeyPressed(GameInput.KEY_SPACE)) {
						switch (s) {
						case 1:
							setGameScene(TestGameScenes.TEST_SCENE00);
							s = 0;
							break;
						case 0:
							setGameScene(TestGameScenes.TEST_SCENE01);
							s = 1;
							break;
						default:
							break;
						}
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
