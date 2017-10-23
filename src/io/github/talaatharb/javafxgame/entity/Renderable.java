package io.github.talaatharb.javafxgame.entity;

import io.github.talaatharb.javafxgame.graphics.Renderer;

public interface Renderable {
	/**
	 * Renders the game object using the given renderer
	 * 
	 * @param renderer
	 *            The renderer to use for rendering
	 */
	public abstract void render(final Renderer renderer);

}
