package application;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class OrderController {
	  	@FXML
	    private ListView<OrderLine> OrderList;

	    @FXML
	    private TextField OrderTotal;
	    
	    @FXML
	    private Button SendToSandwitchShop;
	    
	    Order order;
	    OrderLine orderline;
	    
	    public void ControllerSwitch(Order currentorder) {
	    	order = currentorder;
	    	for(OrderLine ol : order.getOl()) {
	    		OrderList.getItems().add(ol);
	    	}
	    	OrderTotal.textProperty().setValue(String.format("%.2f", order.getPrice()));
	    	
	    
	    }
	   
	    
	    
	    @FXML
	    void Back(MouseEvent event){
	    	Stage stage = (Stage) SendToSandwitchShop.getScene().getWindow();
	    	stage.close();
	    }
	   
	    
	    @FXML
	    void ClearOrder(MouseEvent event) {
	    	OrderList.getItems().removeAll(OrderList.getItems());
	    	order=null;
	    }

	    //make sure its selecting the right one
	    @FXML
	    void RemoveOrderLine(MouseEvent event) {
	    	if(OrderList.getSelectionModel().getSelectedItem()!=null) {
	    		//must remove from Order array list
	    		order.remove(OrderList.getSelectionModel().getSelectedItem());
	    		OrderList.getItems().remove(OrderList.getSelectionModel().getSelectedItem());
	    		OrderTotal.textProperty().setValue(String.format("%.2f", order.getPrice()));
	    	}

	    	
	    }

	    @FXML
	    void SameOrderLine(MouseEvent event) {
	    	if(OrderList.getSelectionModel().getSelectedItem()!=null) {
	    		//must add to Order array list
	    		OrderLine ol = OrderList.getSelectionModel().getSelectedItem();
	    		OrderLine newOl = new OrderLine(order.getOl().size()+1,ol.getSand(),ol.getPrice());
	    		order.add(OrderList.getSelectionModel().getSelectedItem());
	    		OrderList.getItems().add(newOl);
	    		OrderTotal.textProperty().setValue(String.format("%.2f", order.getPrice()));
	        	}
	    }

	    @FXML
	    void SaveOrdertoFile(MouseEvent event) {
	    	FileChooser fc = new FileChooser();
			FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
			fc.getExtensionFilters().add(ext);
			File selected = fc.showSaveDialog(null);
			try {
				if(selected.exists()==false) {
					selected.createNewFile();
				}
				FileWriter wr = new FileWriter(selected);
				wr.write("Order number: " + String.valueOf(Order.lineNumber) + "\n");
				for(OrderLine ol : order.getOl()) {
					wr.write("Sandwich " + ol.toString() + "\n");
				}
				wr.write("Total Price: $" + OrderTotal.textProperty().getValue().toString());
				wr.close();
			}catch(Exception e) {
				Alert sceneError = new Alert(Alert.AlertType.ERROR);
	    		sceneError.setTitle("Error!");
	    		sceneError.setHeaderText("Empty List.");
	    		sceneError.show();
				return;
			}
	    }
	    
	    
}
