/*Author: Maudiel Romero and Alex Miller
 * 
 */
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

	/*
	 * fxml elements for the second page
	 */
	@FXML
	private ListView<OrderLine> OrderList;

	@FXML
	private TextField OrderTotal;

	@FXML
	private Button SendToSandwitchShop;

	/*
	 * objects that will be used
	 */
	Order order;
	OrderLine orderline;

	/*
	 * function that recieves the order object from the previous page so that it can
	 * be listed in the list view
	 */
	public void ControllerSwitch(Order currentorder) {
		order = currentorder;
		for (OrderLine ol : order.getOl()) {
			OrderList.getItems().add(ol);
		}
		OrderTotal.textProperty().setValue(String.format("%.2f", order.getPrice()));
	}

	/*
	 * button that closes the current stage and sends the user back to the original
	 * sandwich shop page
	 */
	@FXML
	void Back(MouseEvent event) {
		Stage stage = (Stage) SendToSandwitchShop.getScene().getWindow();
		stage.close();
	}

	/*
	 * completely clears to order of all orderlines
	 */
	@FXML
	void ClearOrder(MouseEvent event) {
		OrderList.getItems().removeAll(OrderList.getItems());
		order.getOl().removeAll(order.getOl());
	}

	/*
	 * removes an orderline from the given order selected from the orderline list
	 * view
	 */
	@FXML
	void RemoveOrderLine(MouseEvent event) {
		if (OrderList.getSelectionModel().getSelectedItem() != null) {
			order.remove(OrderList.getSelectionModel().getSelectedItem());
			OrderList.getItems().remove(OrderList.getSelectionModel().getSelectedItem());
			OrderTotal.textProperty().setValue(String.format("%.2f", order.getPrice()));
		}
	}

	/*
	 * adds an identical orderline from the given order selected from the orderline
	 * list view
	 */
	@FXML
	void SameOrderLine(MouseEvent event) {
		if (OrderList.getSelectionModel().getSelectedItem() != null) {
			OrderLine ol = OrderList.getSelectionModel().getSelectedItem();
			OrderLine newOl = new OrderLine((order.getOl().get(order.getOl().size() - 1).getlineNum()) + 1,
					ol.getSand(), ol.getPrice());
			order.getOl().add(newOl);
			OrderList.getItems().add(newOl);
			OrderTotal.textProperty().setValue(String.format("%.2f", order.getPrice()));
		}
	}

	/*
	 * writes a text file given the order, the order number, all the orderlines, and
	 * also the total price. It allows the user to choose the location for the saved
	 * text file
	 */
	@FXML
	void SaveOrdertoFile(MouseEvent event) {
		FileChooser fc = new FileChooser();
		FileChooser.ExtensionFilter ext = new FileChooser.ExtensionFilter("TEXT files (*.txt)", "*.txt");
		fc.getExtensionFilters().add(ext);
		File selected = fc.showSaveDialog(null);
		try {
			if (selected.exists() == false) {
				selected.createNewFile();
			}
			FileWriter wr = new FileWriter(selected);
			wr.write("Order number: " + String.valueOf(Order.lineNumber) + "\n");
			for (OrderLine ol : order.getOl()) {
				wr.write("Sandwich " + ol.toString() + "\n");
			}
			wr.write("Total Price: $" + OrderTotal.textProperty().getValue().toString());
			wr.close();
			Order.lineNumber++;
		} catch (Exception e) {
			Alert sceneError = new Alert(Alert.AlertType.ERROR);
			sceneError.setTitle("Error!");
			sceneError.setHeaderText("Empty List.");
			sceneError.show();
			return;
		}
	}

}
