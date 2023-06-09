package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Bee extends Bug {

	private Image img = new Image("galaga.png");

	public Bee(World world) {
		super((int) (100 * Math.random() + 400), (int) (200 * Math.random() + 200),30, "Bee", world);
		this.setFill(new ImagePattern(img));
	}

}
