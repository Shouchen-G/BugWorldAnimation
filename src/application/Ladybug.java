package application;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;

public class Ladybug extends Bug {

	private Image img = new Image("ladybug.png");

	public Ladybug(World world) {

		super((int) (100 * Math.random() + 500), (int) (100 * Math.random() + 300), 15, "Ladybug", world);
		this.setFill(new ImagePattern(img));
	}

	@Override
	public void move() {
		int direction = (int) (Math.random() * 4);

		if (direction == 0 && !(this.getCenterY() < (this.getWorld().getHeight() * 2 / 3)))// up
		{
			this.setCenterY(this.getCenterY() - 2);
		} else if (direction == 1 && !(this.getCenterY() > this.getWorld().getHeight() - this.getRadius()))// down
		{
			this.setCenterY(this.getCenterY() + 2);
		} else if (direction == 2 && !(this.getCenterX() < this.getRadius()))// left
		{
			this.setCenterX(this.getCenterX() - 2);
		} else if (direction == 3 && !(this.getCenterX() > this.getWorld().getWidth() - this.getRadius()))// right
		{
			this.setCenterX(this.getCenterX() + 2);
		}
	}
}
