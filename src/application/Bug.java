package application;

public class Bug extends Thing {
	private World world;

	public Bug(int x, int y, int radius, String name, World world) {
		super(x, y, radius, name);
		this.world = world;
	}

	public World getWorld() {
		return world;
	}

	public void move() {

		int direction = (int) (Math.random() * 4);

		if (direction == 0 && !(this.getCenterY() < this.getRadius()))// up
		{
			this.setCenterY(this.getCenterY() - 30);
		} else if (direction == 1 && !(this.getCenterY() > this.world.getHeight() - this.getRadius()))// down
		{
			this.setCenterY(this.getCenterY() + 30);
		} else if (direction == 2 && !(this.getCenterX() < this.getRadius()))// left
		{
			this.setCenterX(this.getCenterX() - 30);
		} else if (direction == 3 && !(this.getCenterX() > this.world.getWidth() - this.getRadius()))// right
		{
			this.setCenterX(this.getCenterX() + 30);
		}

	}

}
