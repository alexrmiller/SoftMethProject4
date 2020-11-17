package application;
	
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	static AnchorPane root;
	static List<AnchorPane> grid = new ArrayList<AnchorPane>();
	public static int page = 0;
	
	Scene shop, orderlist;
	@Override
	public void start(Stage primaryStage){
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sammitch_shop.fxml"));
			Scene scene = new Scene(root,595,605);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			ListView l1 = (ListView)scene.lookup("#IngredientsIncluded");
			l1.getItems().addAll("Fried Chicken", "Spicy Sauce", "Pickles");
			ListView l2 = (ListView)scene.lookup("#IngredientSelection");
			l2.getItems().addAll("Avacado", "Muenster Cheese", "Chipotle Mayo", "Bacon", "Lettuce", "Tomato", "Onions", "Egg", "Cheddar Cheese", "Garlic Butter");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
