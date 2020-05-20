package ex01;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

class ImageButton extends ToggleButton {
	private final String STYLE_NORMAL = "-fx-background-color: transparent; -fx-padding: 5 5 5 5;";
	private final String STYLE_PRESSED = "-fx-background-color: transparent; -fx-padding: 6 4 4 6;";

	public ImageButton(String imageurl, int width, int height) {
		ImageView imgView = new ImageView(imageurl);
		imgView.setFitHeight(height);
		imgView.setFitWidth(width);
		setGraphic(imgView);
		setStyle(STYLE_NORMAL);
		setOnMousePressed(e->{
			setStyle(STYLE_PRESSED);
		});
		setOnMouseReleased(e-> {
			setStyle(STYLE_NORMAL);
		});
	}
}
class Setting {
	private HBox getJobBtn(){
		HBox hbox = new HBox(-8);
		
		ImageButton warimgBtn = new ImageButton("/img/warrior.png", 45, 45);
		ImageButton rogueImgBtn = new ImageButton("/img/Rogue.png", 45, 45);
		ImageButton magiImgBtn = new ImageButton("/img/magi.png", 45, 45);
		hbox.getChildren().addAll(warimgBtn, rogueImgBtn, magiImgBtn);
		return hbox;
	}
	private HBox getHairBtn(){
		HBox hbox = new HBox();
		ImageButton imgBtn = new ImageButton("/img/warrior.png", 45, 45);

		hbox.getChildren().add(imgBtn);  return hbox;
	}
	private HBox getMotionBtn(){
		HBox hbox = new HBox();
		ImageButton imgBtn = new ImageButton("/img/warrior.png", 45, 45);
		hbox.getChildren().add(imgBtn);  return hbox;
	}
	private VBox getLeftCenter(){
		VBox vbox = new VBox();
		Pane pane0 = new Pane(); Pane pane2 = new Pane();
		Pane pane4 = new Pane(); Pane pane6 = new Pane();
		pane0.setPrefHeight(27); pane2.setPrefHeight(33);
		pane4.setPrefHeight(27);
		vbox.getChildren().add(pane0); vbox.getChildren().add(getJobBtn());
		vbox.getChildren().add(pane2); vbox.getChildren().add(getHairBtn());
		vbox.getChildren().add(pane4); vbox.getChildren().add(getMotionBtn());
		vbox.getChildren().add(pane6); return vbox;
	}
	private BorderPane getLeftPain(){
		//왼쪽 창 만들기
		BorderPane leftBorder = new BorderPane();
		Pane topPane = new Pane();  topPane.setPrefHeight(50);
		Pane leftPane = new Pane(); leftPane.setPrefWidth(16);
		leftBorder.setTop(topPane); leftBorder.setLeft(leftPane);
		leftBorder.setCenter(getLeftCenter());
		return leftBorder;
	}
	public Scene getL2CharScene(){
		StackPane stackPane = new StackPane();
		BorderPane mainBorder = new BorderPane();
		mainBorder.setLeft(getLeftPain());
		stackPane.getChildren().addAll(new ImageView("/img/L2Char.png"),mainBorder);
		return new Scene(stackPane);
	}
}

public class Test01 extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		Setting setting = new Setting();
		primaryStage.setScene(setting.getL2CharScene());
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}


}
