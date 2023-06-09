package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Flower extends Plant{
	
	private Image img = new Image("flower.png");

	public Flower(int x, int y) {
		super(x, y, 20, "Flower", 1f);
		this.setFill(new ImagePattern(img));
	}

}
