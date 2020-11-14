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
    
    int orderLine = 1;
    ArrayList<OrderLine> ol = new ArrayList<OrderLine>();
	Order o = new Order(ol);
    
    @FXML
    void ToBeef() {
    	SandwichType.textProperty().setValue("Beef");
    	Price.textProperty().setValue("10.99");
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Roast Beef");
    	IngredientsIncluded.getItems().add("Provolone Cheese");
    	IngredientsIncluded.getItems().add("Mustard");
    	if(!ExtraIngredients.getItems().isEmpty()) {
    		while(!ExtraIngredients.getItems().isEmpty()) {
    			IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    		}
    	}
    	//change photo
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
    		while(!ExtraIngredients.getItems().isEmpty()) {
    			IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    		}
    	}
    	//change photo
    }
    
    //on change event for sandwich type
    @FXML
    void ToChicken() {
    	SandwichType.textProperty().setValue("Chicken");
    	Price.textProperty().setValue("8.99");
    	IngredientsIncluded.getItems().clear();
    	IngredientsIncluded.getItems().add("Fried Chicken");
    	IngredientsIncluded.getItems().add("Spicy Sauce");
    	IngredientsIncluded.getItems().add("Pickles");
    	if(!ExtraIngredients.getItems().isEmpty()) {
    		while(!ExtraIngredients.getItems().isEmpty()) {
    			IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    		}
    	}
    	//change photo
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
    	ArrayList<Extra> extras= new ArrayList<Extra>();
    	
    	while(!ExtraIngredients.getItems().isEmpty()) {
    		Extra e = new Extra(ExtraIngredients.getItems().get(0).toString());	
    		extras.add(e);
    		IngredientSelection.getItems().add(ExtraIngredients.getItems().remove(0));
    	}
    	
    	switch (SandwichType.textProperty().get().toLowerCase()) {
    	
    	case "chicken":
    		Chicken c = new Chicken(extras);
    		OrderLine col = new OrderLine(orderLine,c,c.price());
    		o.add(col);
    		orderLine++;
    		break;
    		
    	case "beef":
    		Beef b = new Beef(extras);
    		OrderLine bol = new OrderLine(orderLine,b,b.price());
    		o.add(bol);
    		orderLine++;
    		break;
    		
    	case "fish":
    		Fish f = new Fish(extras);
    		OrderLine fol = new OrderLine(orderLine,f,f.price());
    		o.add(fol);
    		orderLine++;
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
