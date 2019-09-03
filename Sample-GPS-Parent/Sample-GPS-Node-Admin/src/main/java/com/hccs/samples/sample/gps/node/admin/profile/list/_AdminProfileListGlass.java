package com.hccs.samples.sample.gps.node.admin.profile.list;

import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.annotations.Glass;
import com.hccs.samples.sample.gps.core.interfaces.GlassGrabber;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

@Glass
public class _AdminProfileListGlass extends BorderPane implements AdminProfileListGlass {

	@FXML
	ListView<Adapter> lstStudents;

	List<StudentBean> mLstStudents;
	
	private Consumer<Adapter> onChangeData;
	
	@Override
	public void init() {
		System.out.println("Loading _ListGlass, init method.");
		FXMLLoader loader = new FXMLLoader(_AdminProfileListGlass.class.getResource("/com/hccs/sample/resources/fxml/EmployeeList.fxml"));
		loader.setController(this);
		loader.setRoot(this);

		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lstStudents.getSelectionModel().selectedItemProperty()
			.addListener((ChangeListener<Adapter>) (obs, oldVal, newVal) -> {
			if (newVal == null) {
				//removeFromActionMap(Edit.class);
			} else {
				System.out.println(newVal.toString());
				System.out.println("Loading _ListGlass, lstStudents.getSelectionModel().selectedItemProperty().");
				onChangeData.accept(newVal);
				//loadStudent(newVal);
				//addToActionMap(Edit.class, editAction);
			}
		});
	}

	@Override
	public GlassGrabber<Node> getGlassGrabber() {
		return new GlassGrabber<Node>() {
			@Override
			public Node getComponent() {
				return _AdminProfileListGlass.this;
			}
		};
	}

	@Override
	public void setData(List<Adapter> adapters) {
		System.out.println("_ListGlass, setData method");
		
		lstStudents.setItems(FXCollections.observableArrayList(adapters));
		
//		for (Adapter adapter : adapters) {
//			mLstStudents.addAll(adapters != null ? adapters.toString() : null)
//		}

	}
	
//	public void filterName(Adapter adapter) {
//	List<String> filteredName = mLstStudents.stream()
//				.filter(x -> mLstStudents.equals(x))
//				.collect(Collectors.toList());
//	}
	
	@Override
	public void setOnSelectItem(Consumer<Adapter> adapter) {
		System.out.println("Loading _ListGlass, setChange method.");
		onChangeData = adapter;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOnModifyList() {
		// TODO Auto-generated method stub
		System.out.println("Loading _ListGlass, setOnModifyList method.");
		lstStudents.setDisable(false);
		
	}
}
