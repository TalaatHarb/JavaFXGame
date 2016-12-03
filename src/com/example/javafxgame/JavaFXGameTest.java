package com.example.javafxgame;

import com.example.javafxgame.game.JavaFXGame;
import com.example.javafxgame.level.GameLevel;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JavaFXGameTest extends Application{

	@Override
	public void start(Stage primaryStage) throws RuntimeException {
		try {
			JavaFXGame game = new JavaFXGame(GameLevel.DEFAULT_LEVEL);
			primaryStage.setScene(game.getGameScene());
			primaryStage.setTitle(game.getTitle());
			// primaryStage.setAlwaysOnTop(true);
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();
			game.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}
