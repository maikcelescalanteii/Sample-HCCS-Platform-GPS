package com.hccs.samples.sample.gps.node.dashboard.details;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.annotations.Glass;
import com.hccs.samples.sample.gps.core.interfaces.GlassGrabber;
import com.hccs.samples.sample.gps.models.beans.GradesBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
@Glass
public class _DashboardDetailsGlass extends BorderPane implements DashboardDetailsGlass {

	@FXML
	private Button btnApply;
	@FXML
	private Button btnClearFilter;
	@FXML
	private TextField txtFirstName;
	@FXML
	private TextField txtLastName;
	@FXML
	private TableView<GradesBean> tblGrades;
	@FXML
	private TableColumn<GradesBean, String> tbcGrade;
	@FXML
	private TableColumn<GradesBean, String> tbcRemarks;
	@FXML
	private TableColumn<GradesBean, String> tbcSubject;
//	private Runnable onClearFilter;
//	private Consumer<List<String>> onApply;

	@Override
	public void init() {
		System.out.println("Loading _FilterGlass, init method.");
		FXMLLoader loader = new FXMLLoader(_DashboardDetailsGlass.class.getResource("/com/hccs/sample/resources/fxml/StudentReportTable.fxml"));
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
		return () -> _DashboardDetailsGlass.this;
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
	public void setOnSelectItem(StudentBean studentBean) {
		System.out.println("_FilterGlass, setOnSelectItem method");
		txtFirstName.setText(studentBean.firstName.toString());
		txtLastName.setText(studentBean.lastName.toString());
		
		tblGrades.setItems(FXCollections.observableArrayList(studentBean.grades));
		
		tbcSubject.setCellValueFactory(new Callback<CellDataFeatures<GradesBean, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<GradesBean, String> param) {
				System.out.println(param.getValue().subject);
				return new SimpleStringProperty(param.getValue().subject);
			}
		});
		
		tbcGrade.setCellValueFactory(new Callback<CellDataFeatures<GradesBean, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<GradesBean, String> param) {
				System.out.println(String.valueOf(param.getValue().grade));
				return new SimpleStringProperty(String.valueOf(param.getValue().grade));
			}
		});
		tbcRemarks.setCellValueFactory(new Callback<CellDataFeatures<GradesBean, String>, ObservableValue<String>>() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<GradesBean, String> param) {
				System.out.println(String.valueOf(param.getValue().getRemarks()));
				return new SimpleStringProperty(param.getValue().getRemarks());
			}
		});
		// TODO Auto-generated method stub	
	}
	
	@Override
	public void setOnNew() {
		// TODO Auto-generated method stub
		
		System.out.println("_FilterGlass, setNew Method");
		clearFields();
		inputMode();
		
		
	}
	
	@Override
	public void setOnEdit() {
		// TODO Auto-generated method stub
		System.out.println("_FilterGlass, setEdit Method");
		inputMode();
		
	}
	
	@Override
	public void setOnCancel() {
		// TODO Auto-generated method stub
		System.out.println("_FilterGlass, setCancel Method");
//		clearFields();
		idleMode();
	}
	
	private void inputMode() {
		txtFirstName.setDisable(false);
		txtLastName.setDisable(false);
		tblGrades.setDisable(false);
	}
	
	public void idleMode() {
		txtFirstName.setDisable(true);
		txtLastName.setDisable(true);
		tblGrades.setDisable(true);
	}

	private void clearFields() {
		txtFirstName.clear();
		txtLastName.clear();
		tblGrades.getItems().clear();
	}
}
