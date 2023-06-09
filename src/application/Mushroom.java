package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Mushroom extends Plant {

	private Image img = new Image("mushroom.png");

	public Mushroom(int x, int y) {
		super(x, y, 20, "Mushroom", 3f);
		this.setFill(new ImagePattern(img));
	}

}
