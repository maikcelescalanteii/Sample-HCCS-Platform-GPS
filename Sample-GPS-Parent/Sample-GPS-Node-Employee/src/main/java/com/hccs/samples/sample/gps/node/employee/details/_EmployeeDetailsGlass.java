package com.hccs.samples.sample.gps.node.employee.details;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.annotations.Glass;
import com.hccs.samples.sample.gps.core.interfaces.GlassGrabber;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.EmployeePositionBean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
@Glass
public class _EmployeeDetailsGlass extends BorderPane implements EmployeeDetailsGlass {

//	@FXML
//	private Button btnApply;
//	@FXML
//	private Button btnClearFilter;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TableView<EmployeePositionBean> tblDetails;
	@FXML
	private TableColumn<EmployeePositionBean, String> tbcAddress;
	@FXML
	private TableColumn<EmployeePositionBean, String> tbcGender;
	@FXML
	private TableColumn<EmployeePositionBean, String> tbcPosition;
	
	private Runnable onModifyList;
//	private Runnable onClearFilter;
//	private Consumer<List<String>> onApply;

	@Override
	public void init() {
		System.out.println("Loading _FilterGlass, init method.");
		FXMLLoader loader = new FXMLLoader(_EmployeeDetailsGlass.class.getResource("/com/hccs/sample/resources/fxml/EmployeeDetails.fxml"));
		loader.setController(this);
		loader.setRoot(this);

		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void initialize() {
		idleMode();
//		btnApply.setOnAction(event -> {
//			List<String> filters = Arrays.asList(txtNameFilter.getText(), txtAddressFilter.getText());
//			onApply.accept(filters);
//		});
//
//		btnClearFilter.setOnAction(event -> onClearFilter.run());
	}

	@Override
	public GlassGrabber<Node> getGlassGrabber() {
		return () -> _EmployeeDetailsGlass.this;
	}

	@Override
	public void setOnClearFilter(Runnable runnable) {
		//this.onClearFilter = runnable;
	}

	@Override
	public void setOnApply(Consumer<List<String>> consumer) {
		//this.onApply = consumer;
	}

	@Override
	public void setOnSelectItem(EmployeeBean employeeBean) {
		System.out.println("_FilterGlass, setChange method");
		txtFirstName.setText(employeeBean.firstName.toString());
		txtLastName.setText(employeeBean.lastName.toString());
		
		tblDetails.setItems(FXCollections.observableArrayList(employeeBean.position));
		
		tbcAddress.setCellValueFactory(new Callback<CellDataFeatures<EmployeePositionBean, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<EmployeePositionBean, String> param) {
				System.out.println(param.getValue().address);
				return new SimpleStringProperty(param.getValue().address);
			}
		});
		
		tbcGender.setCellValueFactory(new Callback<CellDataFeatures<EmployeePositionBean, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<EmployeePositionBean, String> param) {
				System.out.println(String.valueOf(param.getValue().gender));
				return new SimpleStringProperty(String.valueOf(param.getValue().gender));
			}
		});
		tbcPosition.setCellValueFactory(new Callback<CellDataFeatures<EmployeePositionBean, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<EmployeePositionBean, String> param) {
				System.out.println(String.valueOf(param.getValue().getRemarks()));
				return new SimpleStringProperty(param.getValue().getRemarks());
			}
		});
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void setOnNew() {
		// TODO Auto-generated method stub
		
		this.onModifyList.run();
		
		System.out.println("_FilterGlass, setNew Method");
		clearFields();
		inputMode();
		
		
	}

	@Override
	public void setOnEdit() {
		// TODO Auto-generated method stub
		inputMode();
	}
	
	@Override
	public void setOnCancel() {
		// TODO Auto-generated method stub
		System.out.println("_FilterGlass, setCancel Method");
		clearFields();
		idleMode();
	}
	
	private void inputMode() {
		txtFirstName.setDisable(false);
		txtLastName.setDisable(false);
		tblDetails.setDisable(false);
	}
	
	public void idleMode() {
		txtFirstName.setDisable(true);
		txtLastName.setDisable(true);
		tblDetails.setDisable(true);
	}

	private void clearFields() {
		txtFirstName.clear();
		txtLastName.clear();
		tblDetails.getItems().clear();
	}

}
