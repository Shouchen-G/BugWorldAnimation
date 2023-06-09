package application;

public class Plant extends Thing {

	private float df = 1f;
	private String name;

	public Plant(int x, int y, int radius, String name, Float df) {
		super(x, y, radius, name);
		this.df = df;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getDf() {
		return df;
	}

	public void setDf(float df) {
		this.df = df;
	}

	public void grow() {
		if (this.getRadius() < 30) {
			this.setRadius(this.getRadius() + 1 * this.getDf());
		}
	}

}
