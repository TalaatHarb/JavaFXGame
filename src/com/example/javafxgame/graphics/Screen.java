package com.example.javafxgame.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Screen {

	private GraphicsContext graphcisContext;
	private double screenHeight;
	private double screenWidth;

	public Screen(GraphicsContext graphcisContext, double screenWidth, double screenHeight) {
		this.graphcisContext = graphcisContext;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}

	public void clear() {
		graphcisContext.setFill(Color.BLACK);
		graphcisContext.fillRect(0.0, 0.0, screenWidth, screenHeight);		
	}

	public void renderFillRect(int x, int y, int w, int h, Color color) {
		graphcisContext.setFill(color);
		graphcisContext.fillRect(x, y, w, h);
	}
	
	public void renderImage(double x, double y, Image image){
		graphcisContext.drawImage( image, x, y );
	}

	public void renderRect(double x, double y, double w, double h, Color color,
			double lineWidth) {
		graphcisContext.setStroke(color);
		graphcisContext.setLineWidth(lineWidth);
		graphcisContext.fillRect(x, y, w, h);
	}
}
