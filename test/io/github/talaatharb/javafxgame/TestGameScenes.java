package io.github.talaatharb.javafxgame;

import io.github.talaatharb.javafxgame.scene.GameScene;
import io.github.talaatharb.javafxgame.scene.TestGameScene;
import javafx.scene.paint.Color;

public interface TestGameScenes {
	public static final GameScene TEST_SCENE00 = new TestGameScene(Color.WHITE);
	public static final GameScene TEST_SCENE01 = new TestGameScene(Color.ALICEBLUE);
}
