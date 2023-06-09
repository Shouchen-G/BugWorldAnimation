package application;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class World extends Pane {
	private int x;
	private int y;
	private ImageView img;
	private List<Thing> list;
	private Button button = new Button();

	public World(int x, int y) {
		super();
		this.list = new ArrayList<Thing>();
		this.setMaxWidth(x);
		this.setMaxHeight(y);
	}

	public List<Thing> getList() {
		return list;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Button getButton() {
		img = new ImageView(new Image("strawberry.png"));
		img.setFitHeight(50);
		img.setPreserveRatio(true);
		button.setGraphic(img);
		button.setStyle("-fx-background-color: lightblue");
		button.relocate(200, 300);
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public void add(Thing thing) {
		this.list.add(thing);
		this.getChildren().add(thing);
	}

	public void displayWorld() {
		this.getChildren().add(this.getButton());

		this.add(new Obstacle(200, 500));
		this.add(new Obstacle(500, 200));
		this.add(new Obstacle(400, 300));
		this.add(new Obstacle(800, 100));
		this.add(new Mushroom(800, 500));
		this.add(new Mushroom(500, 500));
		this.add(new Mushroom(100, 100));
		this.add(new Mushroom(700, 300));
		this.add(new Mushroom(500, 100));
		this.add(new Grass(100, 500));
		this.add(new Grass(200, 400));
		this.add(new Grass(300, 500));
		this.add(new Grass(200, 100));
		this.add(new Grass(700, 100));
		this.add(new Grass(600, 500));
		this.add(new Flower(400, 400));
		this.add(new Flower(400, 200));
		this.add(new Flower(800, 300));
		this.add(new Flower(500, 400));
		this.add(new Strawberry(300, 100));
		this.add(new Strawberry(100, 200));
		this.add(new Strawberry(800, 200));
		this.add(new Bee(this));
		this.add(new Dragonfly(this));
		this.add(new Mouth(this));
		this.add(new Ladybug(this));
		this.add(new Ant(this));

		this.button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				img = new ImageView(new Image("crown.png"));
				img.setFitHeight(60);
				;
				img.setPreserveRatio(true);
				button.setGraphic(img);

			}
		});

	}

}
