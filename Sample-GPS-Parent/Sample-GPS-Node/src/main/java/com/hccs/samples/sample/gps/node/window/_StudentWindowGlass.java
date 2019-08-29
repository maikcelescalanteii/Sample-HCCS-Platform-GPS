package com.hccs.samples.sample.gps.node.window;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.hccs.platform.HCCSPlatform;
import com.hccs.platform.annotations.TopComponent;
import com.hccs.platform.enums.CloseOperation;
import com.hccs.platform.extendables.PlatformTopWindow;
import com.hccs.samples.sample.gps.actions.interfaces.Cancel;
import com.hccs.samples.sample.gps.actions.interfaces.Edit;
import com.hccs.samples.sample.gps.actions.interfaces.FetchAll;
import com.hccs.samples.sample.gps.actions.interfaces.New;
import com.hccs.samples.sample.gps.actions.interfaces.Save;
import com.hccs.samples.sample.gps.core.interfaces.GlassAttacher;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

import javafx.scene.Node;

//@autoformat:off
//@TopComponent(
//		title = "Node",
//		group = "gps",
//		location = "center",
//		image = "/path/to/image/sample.png",
//		fxml = "/path/to/fxml/sample.fxml",
//		css = "/path/to/css/sample.css",
//		closeOperation = CloseOperation.HIDE,
//		closeable = false )
//@autoformat:on
//
//In this case, TopWindow class will be extended, for platform use.

@TopComponent(title = "Student Report Card", fxml = "/com/hccs/sample/resources/fxml/StudentMainWindow.fxml", image = "/com/hccs/sample/resources/_16x16/studentreportcard.png", location = "container", group = "horizontal", closeOperation = CloseOperation.CLOSE)
public class _StudentWindowGlass extends PlatformTopWindow implements StudentWindowGlass {

	private final List<Runnable> onShowActions;
	
	private boolean isUpdate;
	
	private Runnable onFetchAction;
	
	private Runnable onCancelAction;
	
	private Runnable onNewAction;
	
	private Runnable onEditAction;
	
	public _StudentWindowGlass() {
		onShowActions = new ArrayList<>();
	}

	@Override
	public void init() {
		System.out.println("_Window Glass, init method");
		idleMode();
		// This method is implemented in the platformtopwindow extensions so you can
		// remve this if you extended the said class.
	}

	@Override
	public void show() {
//		 implementation of the platformwindow extension
		 super.show();
	}

	// @OnShow
	// This is a platform annotation
	public void onShow() {
		this.onShowActions.forEach(new Consumer<Runnable>() {
			@Override
			public void accept(Runnable t) {
				t.run();
			}
		});
	}

	@Override
	public GlassAttacher<Node> getFilterAttacher() {
		return new GlassAttacher<Node>() {
			@Override
			public void attachComponent(Node comp) {
				setCenter(comp);
			}
		};
	}

	@Override
	public GlassAttacher<Node> getListAttacher() {
		return new GlassAttacher<Node>() {
			@Override
			public void attachComponent(Node comp) {
				setLeft(comp);
			}
		};
	}

	@Override
	public void addOnShowAction(Runnable runnable) {
		this.onShowActions.add(runnable);
	}

	private Cancel cancelAction = () -> {
//		clearFields();
//		if (isUpdate) {
//			loadStudent(lstStudents.getSelectionModel().getSelectedItem());
//		}
		
		this.onCancelAction.run();
		
		idleMode();
	};

	private Edit editAction = () -> {
		isUpdate = true;
		this.onEditAction.run();
		inputMode();
	};

	private FetchAll fetchAllAction = () -> {
//		populateList(StudentsModel.getStudents());
		System.out.println("_Window Glass, FetchAll");
		this.onFetchAction.run();
		HCCSPlatform.getStatusService().setStatusMessage("Fetched successfully!");
	};

	private New newAction = () -> {
		isUpdate = false;
		
		this.onNewAction.run();
		inputMode();
		
//		clearFields();
//		inputMode();
	};

	private Save saveAction = () -> {
		StudentBean student = null;

	};

//	private void clearFields() {
//		txtFirstName.clear();
//		txtLastName.clear();
//		tblGrades.getItems().clear();
//	}
	
	public void idleMode() {
//		lstStudents.setDisable(false);
//		txtFirstName.setDisable(true);
//		txtLastName.setDisable(true);
//		tblGrades.setDisable(true);
		addToActionMap(New.class, newAction);
		addToActionMap(FetchAll.class, fetchAllAction);
		removeFromActionMap(Edit.class);
		removeFromActionMap(Cancel.class);
		removeFromActionMap(Save.class);
	}
	
	

	@Override
	public void addOnFetchAllAction(Runnable runnable) {
		// TODO Auto-generated method stub
		onFetchAction = runnable;
	}

	@Override
	public void addOnNewAction(Runnable runnable) {
		// TODO Auto-generated method stub
		onNewAction = runnable;
	}
	
	@Override
	public void addOnEditAction(Runnable runnable) {
		// TODO Auto-generated method stub
		onEditAction = runnable;
	}
	
	@Override
	public void addOnCancelAction(Runnable runnable) {
		// TODO Auto-generated method stub
		onCancelAction = runnable;
	}
	
	private void inputMode() {
		addToActionMap(Cancel.class, cancelAction);
		addToActionMap(Save.class, saveAction);
		removeFromActionMap(FetchAll.class);
		removeFromActionMap(New.class);
		removeFromActionMap(Edit.class);
	}

	@Override
	public void addOnSelectedItemAction() {
		// TODO Auto-generated method stub
		addToActionMap(Edit.class, editAction);
	}
	
}
