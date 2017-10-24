package io.github.talaatharb.javafxgame.graphics;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public interface Renderer {
	public void clear();

	public double getHeight();

	public double getWidth();

	public void renderFillRect(final double x, final double y, final double w, final double h, final Color color);

	public void renderImage(final double x, final double y, final Image image);

	public void renderImage(final double x, final double y, final Image image, final double w, final double h);

	public void renderLine(final double xOld, final double yOld, final double x, final double y, final Color color);

	public void renderRect(final double x, final double y, final double w, final double h, final Color color,
			final double lineWidth);
}
