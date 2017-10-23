package io.github.talaatharb.javafxgame.entity;

import io.github.talaatharb.javafxgame.scene.GameScene;

public interface Entity extends Updatable, Renderable {

	/**
	 * Every entity has to belong to a game scene
	 * 
	 * @param gameScene
	 *            The game scene of this entity
	 */
	public abstract void setGameScene(final GameScene gameScene);
}
