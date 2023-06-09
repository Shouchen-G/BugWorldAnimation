package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Main extends Application {
	int width = 1000, height = 600;

	@Override
	public void start(Stage primaryStage) {
		BorderPane borderPane = new BorderPane();
		World w = new World(width, height);
		w.setStyle("-fx-background-color: lightblue");

		Button start = new Button("Start");
		Button pause = new Button("Pause");
		Button add = new Button("+");
		Button remove = new Button("-");
		VBox right = new VBox(10);
		right.getChildren().addAll(start, pause, add, remove);
		right.setAlignment(Pos.CENTER);
		right.setStyle("-fx-background-color: lightblue");

		HBox top = new HBox(50);
		Slider speed = new Slider(0, 10, 1);
		Text text = new Text("Click to find bonus");
		text.setFill(Color.DEEPPINK);
		speed.setPrefWidth(200);
		speed.setValue(5);
		speed.setShowTickLabels(true);
		top.setAlignment(Pos.CENTER);
		top.getChildren().addAll(speed, text);
		top.setStyle("-fx-background-color: lightblue");

		borderPane.setTop(top);
		borderPane.setRight(right);
		borderPane.setCenter(w);

		Scene scene = new Scene(borderPane, width, height);
		primaryStage.setTitle("Bug World Animation");
		primaryStage.setScene(scene);
		primaryStage.show();

		w.displayWorld();

		EventHandler getName = new EventHandler() {
			@Override
			public void handle(Event e) {
				Thing t = (Thing) e.getSource();
				text.setText(t.getName());
			}
		};

		Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				for (Thing t : w.getList()) {

					if (t instanceof Plant) {
						((Plant) t).grow();
					}
					if (t instanceof Bug) {
						Bug b = (Bug) t;
						b.move();
						for (Thing t1 : w.getList()) {
							if (t1 instanceof Plant && (new Point2D(b.getCenterX(), b.getCenterY())
									.distance(t1.getCenterX(), t1.getCenterY()) <= b.getRadius() + t1.getRadius())) {
								Plant p = (Plant) t1;
								p.setRadius(p.getRadius() - 1);
							}

							if (t1 instanceof Bug) {
								Bug b1 = (Bug) t1;
								// if two bugs touching, the bigger one will eat smaller one
								if (b.getRadius() > b1.getRadius()
										&& (new Point2D(b.getCenterX(), b.getCenterY()).distance(b1.getCenterX(),
												b1.getCenterY()) <= b.getRadius() + b1.getRadius())
										&& b.getRadius() < 60) {
									b.setRadius(b.getRadius() + 1);
									w.getChildren().remove(b1);

								}
							}

							if (t1 instanceof Obstacle && (new Point2D(b.getCenterX(), b.getCenterY())
									.distance(t1.getCenterX(), t1.getCenterY()) <= b.getRadius() + t1.getRadius())) {
								if (b.getCenterX() > t1.getCenterX()) {
									b.setCenterX(b.getCenterX() + 20);
								} else if (b.getCenterX() < t1.getCenterX()) {
									b.setCenterX(b.getCenterX() - 20);
								} else if (b.getCenterY() < t1.getCenterY()) {
									b.setCenterX(b.getCenterY() - 20);
								} else {
									b.setCenterX(b.getCenterY() + 20);
								}
							}
						}
					}
					t.setOnMouseClicked(getName);
				}
			}
		}));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();

		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				animation.play();
			}
		});

		pause.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				animation.pause();
			}
		});

		speed.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				animation.setRate(speed.getValue());

			}

		});
		w.getButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ImageView img = new ImageView(new Image("crown.png"));
				img.setFitHeight(60);
				;
				img.setPreserveRatio(true);
				w.getButton().setGraphic(img);
				text.setText("You find the CROWN");
			}
		});

		add.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				int number = (int) (0 + Math.random() * 5);
				switch (number) {
				case 0:
					w.add(new Ant(w));
					break;
				case 1:
					w.add(new Bee(w));
					break;
				case 2:
					w.add(new Dragonfly(w));
					break;
				case 3:
					w.add(new Ladybug(w));
					break;
				case 4:
					w.add(new Mouth(w));
					break;
				}
			}
		});

		remove.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (w.getChildren().size() > 0) {
					w.getChildren().remove(w.getChildren().size() - 1);
				}

			}
		});

	}

	public static void main(String[] args) {
		launch(args);
	}
}
