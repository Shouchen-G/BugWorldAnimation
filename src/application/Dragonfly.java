package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Dragonfly extends Bug {

	private Image img = new Image("dragonfly.png");

	public Dragonfly(World world) {
		super((int) (100 * Math.random() + 300), (int) (100 * Math.random() + 400),30, "Dragonfly", world);
		this.setFill(new ImagePattern(img));
	}

}
