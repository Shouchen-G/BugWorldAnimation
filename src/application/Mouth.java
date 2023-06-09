package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Mouth extends Bug {

	private Image img = new Image("mouth.png");

	public Mouth(World world) {
		super((int) (100 * Math.random() + 400), (int) (100 * Math.random() + 100),30, "Mouth", world);
		this.setFill(new ImagePattern(img));
	}

}
