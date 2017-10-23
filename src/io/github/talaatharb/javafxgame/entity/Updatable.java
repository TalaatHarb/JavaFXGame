package io.github.talaatharb.javafxgame.entity;

public interface Updatable {
	/**
	 * Updates the game object status
	 * 
	 * @param t
	 *            Time delta
	 */
	public abstract void update(final double t);
}
