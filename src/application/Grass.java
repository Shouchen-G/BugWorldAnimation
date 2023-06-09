package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Grass extends Plant {

	private Image img = new Image("grass.png");

	public Grass(int x, int y) {
		super(x, y, 20, "Grass", 1f);
		this.setFill(new ImagePattern(img));
	}

}
