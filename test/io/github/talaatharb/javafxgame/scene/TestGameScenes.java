package io.github.talaatharb.javafxgame.scene;

import io.github.talaatharb.javafxgame.scene.GameScene;
import javafx.scene.paint.Color;

public interface TestGameScenes {
	public static final GameScene TEST_SCENE00 = new TestGameScene(Color.WHITE, 100);
	public static final GameScene TEST_SCENE01 = new TestGameScene(Color.ALICEBLUE, 10);
}
