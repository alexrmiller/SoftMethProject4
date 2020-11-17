package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SandwichController {
	
	@FXML
	private TextField Price;
	
	@FXML
	private MenuButton SandwichType;
	
	@FXML
	private TextArea TextArea;
	
	@FXML
    private ListView<String> IngredientsIncluded;
	
    @FXML
    private ListView<String> IngredientSelection;

    @FXML
    private ListView<String> ExtraIngredients;
    @FXML
    private Button ShowOrder2;
    @FXML
    private Pane Picture;
    @FXML
    private ImageView Image;
    
    public void initialize(URL url, ResourceBundle rb) {
      }
    

     ArrayList<OrderLine> ol = new ArrayList<OrderLine>();
	 Order o = new Order(ol);
    
    @FXML
    void ToBeef() {
    	SandwichType.textProperty().setValue("Beef");
    	Price.textProperty().setValue("10.99");
    	
    	Image image = new Image(getClass().getResourceAsStream("Beef.png"));
        Image.setImage(image);
    	Image.setId("@Beef.png");
    	
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Roast Beef");
    	IngredientsIncluded.getItems().add("Provolone Cheese");
    	IngredientsIncluded.getItems().add("Mustard");
    	if(!ExtraIngredients.getItems().isEmpty()) {
    		while(!ExtraIngredients.getItems().isEmpty()) {
    			IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    		}
    	}
    }
    
    @FXML
    void ToFish() {
    	SandwichType.textProperty().setValue("Fish");
    	Price.textProperty().setValue("12.99");
    	
    	Image image = new Image(getClass().getResourceAsStream("Fish.png"));
        Image.setImage(image);
    	Image.setId("@Fish.png");
    	
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Grilled Snapper");
    	IngredientsIncluded.getItems().add("Cilantro");
    	IngredientsIncluded.getItems().add("Lime");    	
    	if(!ExtraIngredients.getItems().isEmpty()) {
    		while(!ExtraIngredients.getItems().isEmpty()) {
    			IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    		}
    	}
    }
    
    //on change event for sandwich type
    @FXML
    void ToChicken() {
    	SandwichType.textProperty().setValue("Chicken");
    	Price.textProperty().setValue("8.99");
    	
    	Image image = new Image(getClass().getResourceAsStream("Chicken.png"));
        Image.setImage(image);
    	Image.setId("@Chicken.png");
    	
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Fried Chicken");
    	IngredientsIncluded.getItems().add("Spicy Sauce");
    	IngredientsIncluded.getItems().add("Pickles");
    	if(!ExtraIngredients.getItems().isEmpty()) {
    		while(!ExtraIngredients.getItems().isEmpty()) {
    			IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    		}
    	}
    }
    
    //on click event for add 
    @FXML
    void Add(MouseEvent event) {
    	if(IngredientSelection.getSelectionModel().getSelectedItem()!=null && ExtraIngredients.getItems().size()<6) {
        	ExtraIngredients.getItems().add(IngredientSelection.getSelectionModel().getSelectedItem());
        	IngredientSelection.getItems().remove(IngredientSelection.getSelectionModel().getSelectedItem());
        	double price = Double.parseDouble(Price.textProperty().getValue())+1.99;
        	Price.textProperty().setValue(String.format("%.2f", price));
        	}
        	else if(ExtraIngredients.getItems().size()==0) {
        		Alert sceneError = new Alert(Alert.AlertType.ERROR);
        		sceneError.setTitle("Error!");
        		sceneError.setHeaderText("Please Select and Extra Ingredient to ADD");
        		sceneError.show();
        		
        	}else {
        		Alert sceneError = new Alert(Alert.AlertType.ERROR);
        		sceneError.setTitle("Error!");
        		sceneError.setHeaderText("Can't add more than 6 items.");
        		sceneError.show();
        	}
    }

    
   //on click event for adding orderline to order
    @FXML
    void AddtoOrder(MouseEvent event) {
    	ArrayList<Extra> extras= new ArrayList<Extra>();
    	
    	while(!ExtraIngredients.getItems().isEmpty()) {
    		Extra e = new Extra(ExtraIngredients.getItems().get(0).toString());	
    		extras.add(e);
    		IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    	}
    	
    	switch (SandwichType.textProperty().get().toLowerCase()) {
    	
    	case "chicken":
    		Chicken c = new Chicken(extras);
    		OrderLine col = new OrderLine(o.getOl().size()+1,c,c.price());
    		o.add(col);
    		break;
    		
    	case "beef":
    		Beef b = new Beef(extras);
    		OrderLine bol = new OrderLine(o.getOl().size()+1,b,b.price());
    		o.add(bol);
    		break;
    		
    	case "fish":
    		Fish f = new Fish(extras);
    		OrderLine fol = new OrderLine(o.getOl().size()+1,f,f.price());
    		o.add(fol);
    		break;
    	}
    	ToChicken();
    }

    @FXML
    void Clear(MouseEvent event) {
    	ToChicken();
    }

    //on click event to remove extras from sandwich
    @FXML
    void Remove(MouseEvent event) {
    	if(ExtraIngredients.getSelectionModel().getSelectedItem()!=null) {
    		IngredientSelection.getItems().add(ExtraIngredients.getSelectionModel().getSelectedItem());
    		ExtraIngredients.getItems().remove(ExtraIngredients.getSelectionModel().getSelectedItem());
    		double price = Double.parseDouble(Price.textProperty().getValue())-1.99;
        	Price.textProperty().setValue(String.format("%.2f", price));
        	}
    	else {
    		Alert sceneError = new Alert(Alert.AlertType.ERROR);
    		sceneError.setTitle("Error!");
    		sceneError.setHeaderText("Please Select and Extra Ingredient to Remove");
    		sceneError.show();;
    	}
    }

    //on click event that passes through to the next view with the order #
    @FXML
    void ShowOrder(MouseEvent event) {
    	if(o.getOl().isEmpty()) {
    		Alert sceneError = new Alert(Alert.AlertType.ERROR);
    		sceneError.setTitle("Error!");
    		sceneError.setHeaderText("Nothing is added to order");
    		sceneError.show();;
    	}
    	else {
    	try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("Order_Summary.fxml"));
        	Parent root = loader.load();
        	OrderController ordersummaryController = loader.getController();        	
        	ordersummaryController.ControllerSwitch(o);
        	Stage stage= new Stage();
        	stage.setScene(new Scene(root));
        	stage.setTitle("Current Order");
        	stage.show();
        	}catch(IOException ex){
        		Alert sceneError = new Alert(Alert.AlertType.ERROR);
        		sceneError.show();
        		
        	}
    }
    }

}
