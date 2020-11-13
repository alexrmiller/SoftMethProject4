package application;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

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
    private Pane Picture;

    
    
    
    @FXML
    void ToBeef() {
    	SandwichType.textProperty().setValue("Beef");
    	Price.textProperty().setValue("10.99");
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Roast Beef");
    	IngredientsIncluded.getItems().add("Provolone Cheese");
    	IngredientsIncluded.getItems().add("Mustard");
    	IngredientSelection.getItems().add("test1");
    	IngredientSelection.getItems().add("test2");
    	IngredientSelection.getItems().add("test3");
    	IngredientSelection.getItems().add("test4");
    	IngredientSelection.getItems().add("test5");
    	IngredientSelection.getItems().add("test6");
    	IngredientSelection.getItems().add("test7");
    	IngredientSelection.getItems().add("test8");
    	//change photo
    	//remove extra
    }
    
    @FXML
    void ToFish() {
    	SandwichType.textProperty().setValue("Fish");
    	Price.textProperty().setValue("12.99");
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Grilled Snapper");
    	IngredientsIncluded.getItems().add("Cilantro");
    	IngredientsIncluded.getItems().add("Lime");    	
    	if(!ExtraIngredients.getItems().isEmpty()) {
    		for(String e : ExtraIngredients.getItems()) {
    			IngredientSelection.getItems().add(e);
    			ExtraIngredients.getItems().remove(e);
    		}
    	}
    	//change photo
    	//remove extra
    }
    
    //on change event for sandwich type
    @FXML
    void ToChicken() {
    	ArrayList<Extra> extras = new ArrayList<Extra>();
    	Chicken c = new Chicken(extras);
    	SandwichType.textProperty().setValue("Chicken");
    	Price.textProperty().setValue("8.99");
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Fried Chicken");
    	IngredientsIncluded.getItems().add("SpicySauce");
    	IngredientsIncluded.getItems().add("Pickles");
    	//change photo
    	//remove extra
    }
    
    //on click event for add 
    @FXML
    void Add(MouseEvent event) {
    	if(IngredientSelection.getSelectionModel().getSelectedItem()!=null && ExtraIngredients.getItems().size()<6) {
    	ExtraIngredients.getItems().add(IngredientSelection.getSelectionModel().getSelectedItem());
    	IngredientSelection.getItems().remove(IngredientSelection.getSelectionModel().getSelectedItem());
    	//change price
    	}
    	else if(ExtraIngredients.getItems().size()<6) {
    	//load other popup for error
    	}
    	else {
    		TextArea.setText("invalid: cannot add extra ingredient");
    	} 
    }

    
   //on click event for adding orderline to order
    @FXML
    void AddtoOrder(MouseEvent event) {
    	Order o = null;
    	
    	if(ExtraIngredients.getItems().isEmpty()) {
    		ArrayList<Extra> extras = null;
    	}
    	//make all the extras into 
    	ArrayList<Extra> extras = null;
    	switch (SandwichType.textProperty().get().toLowerCase()) {
    	
    	case "chicken":
    		Chicken c = new Chicken(extras);
    		OrderLine col = new OrderLine(4,c,c.price());
    		o.add(col);
    		break;
    		
    	case "beef":
    		Beef b = new Beef(extras);
    		
    	case "fish":
    		Fish f = new Fish(extras);
    	}
    	//add orderline to order
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
        	}
    	else {
    		TextArea.setText("invalid: no extras to remove");
    	}
    }

    //on click event that passes through to the next view with the order #
    @FXML
    void ShowOrder(MouseEvent event) {
    	//get order id
    	//send that ID to other view for loading
    }

    //on click event to get rid of error message
    @FXML
    void ErrorButton(MouseEvent event) {
    	
    }

}
