package io.github.talaatharb.javafxgame.graphics;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public interface Renderer {
	public void clear();

	public double getHeight();

	public double getWidth();

	public void renderFillRect(double x, double y, double w, double h, Color color);

	public void renderImage(double x, double y, Image image);

	public void renderRect(double x, double y, double w, double h, Color color, double lineWidth);
}
