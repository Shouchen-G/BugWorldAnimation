package application;

import javafx.scene.shape.Circle;

public class Thing extends Circle {

	private String name;

	public Thing(int x, int y, int radius, String name) {

		super(x, y, radius);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String tosString() {
		return "X: " + this.getCenterX() + ", Y: " + this.getCenterY() + ", Radius: " + this.getRadius();
	}
}
