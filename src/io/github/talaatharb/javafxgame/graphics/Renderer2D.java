package io.github.talaatharb.javafxgame.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Renderer2D implements Renderer {

	private GraphicsContext graphcisContext;
	private double screenHeight;
	private double screenWidth;

	public Renderer2D(final GraphicsContext graphcisContext, final double screenWidth, final double screenHeight) {
		this.graphcisContext = graphcisContext;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}

	@Override
	public void clear() {
		graphcisContext.setFill(Color.BLACK);
		graphcisContext.fillRect(0.0, 0.0, screenWidth, screenHeight);
	}

	@Override
	public double getHeight() {
		return screenHeight;
	}

	@Override
	public double getWidth() {
		return screenWidth;
	}

	@Override
	public void renderFillRect(final double x, final double y, final double w, final double h, final Color color) {
		graphcisContext.setFill(color);
		graphcisContext.fillRect(x, y, w, h);
	}

	@Override
	public void renderImage(final double x, final double y, final Image image) {
		graphcisContext.drawImage(image, x, y);
	}

	@Override
	public void renderImage(final double x, final double y, final Image image, final double w, final double h) {
		graphcisContext.drawImage(image, x, y, w, h);
	}

	@Override
	public void renderRect(final double x, final double y, final double w, final double h, final Color color, final double lineWidth) {
		graphcisContext.setStroke(color);
		graphcisContext.setLineWidth(lineWidth);
		graphcisContext.strokeRect(x, y, w, h);
	}
}
