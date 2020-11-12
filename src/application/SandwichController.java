package application;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class SandwichController {

	@FXML
	private MenuButton SandwichType;
	
	@FXML
	private TextArea Text;
	
	@FXML
    private ListView<?> IngredientsIncluded;
	
    @FXML
    private ListView<?> IngredientSelection;

    @FXML
    private ListView<?> ExtraIngredients;

    @FXML
    void ChangeSandwichType(MouseEvent event) {
    }
    
    @FXML
    void Add(MouseEvent event) {
    	Text.setText("test");
    }

    @FXML
    void AddtoOrder(MouseEvent event) {

    }

    @FXML
    void Clear(MouseEvent event) {

    }

    @FXML
    void Remove(MouseEvent event) {

    }

    @FXML
    void ShowOrder(MouseEvent event) {

    }

    @FXML
    void ErrorButton(MouseEvent event) {

    }

}
