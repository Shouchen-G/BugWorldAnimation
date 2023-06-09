package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Obstacle extends Thing {

	private Image img = new Image("stone.png");

	public Obstacle(int x, int y) {
		super(x, y, 25, "Obstacle");
		this.setFill(new ImagePattern(img));
	}

}
