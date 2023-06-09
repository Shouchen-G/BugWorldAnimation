package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Strawberry extends Plant {

	private Image img = new Image("strawberry.png");

	public Strawberry(int x, int y) {
		super(x, y, 5, "Strawberry", 0.5f);
		this.setFill(new ImagePattern(img));
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public void setFill(Image img) {
		this.setFill(img);

	}

}
