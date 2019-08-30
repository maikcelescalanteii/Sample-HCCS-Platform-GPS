package com.hccs.samples.sample.gps.node.admin.settings.form;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.ComponentCombiner;
import com.hccs.samples.sample.gps.core.FormBase;
import com.hccs.samples.sample.gps.core.annotations.Form;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.node.admin.settings.AdminSettingsFormConfig;
import com.hccs.samples.sample.gps.node.admin.settings.details.AdminSettingsDetailsController;
import com.hccs.samples.sample.gps.node.admin.settings.details.AdminSettingsDetailsGlass;
import com.hccs.samples.sample.gps.node.admin.settings.gateway.NodeGateway;
import com.hccs.samples.sample.gps.node.admin.settings.list.Adapter;
import com.hccs.samples.sample.gps.node.admin.settings.list.AdminSettingsListController;
import com.hccs.samples.sample.gps.node.admin.settings.list.AdminSettingsListGlass;
import com.hccs.samples.sample.gps.node.admin.settings.window.AdminSettingsWindowController;
import com.hccs.samples.sample.gps.node.admin.settings.window.AdminSettingsWindowGlass;

import javafx.scene.Node;
@Form
public class _AdminSettingsForm extends FormBase implements AdminSettingsForm {

	@Autowired
	private NodeGateway gateway;

	protected AdminSettingsWindowController window;
	protected AdminSettingsDetailsController details;
	protected AdminSettingsListController list;

	@Override
	public Class<?> configClass() {
		System.out.println("_AdminSettingsForm, configClass method");
		return AdminSettingsFormConfig.class;
	}

	@Override
	public void postContextSetup() {
		System.out.println("_AdminSettingsForm, postContextSetup method");
		window = getBean(AdminSettingsWindowController.class);
		details = getBean(AdminSettingsDetailsController.class);
		list = getBean(AdminSettingsListController.class);
	}

	@Override
	public void setupActions() {
//		System.out.println("_NodeForm, setupActions method");
//		filter.setOnApply(filters -> list.setData(fetch(filters)));
//		window.addOnShowAction(() -> System.out.println("This form is shown."));
		
		window.setupActions();
		System.out.println("_AdminSettingsForm, setupActions method, start");
		
		window.addOnSetAction(new Consumer<List<EmployeeBean>>() {
			@Override
			public void accept(List<EmployeeBean> studList) {
				System.out.println(studList);
				list.setData(studList);
			}
		});
		list.setOnSelectItem(new Consumer<Adapter>() {
			@Override
			public void accept(Adapter selectedStud) {
				details.setOnSelectItem(selectedStud);
				window.addOnSelectedItemAction();
			}
		});
		
		window.addOnNewAction(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				details.setOnNew();
			}
		});
		
		window.addOnCancelAction(new Runnable () {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				details.setOnCancel();
			}
			
		});
		
		window.addOnEditAction(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				details.setOnEdit();
				list.setOnInputMode();
			}
			
		});
		
		System.out.println("_AdminSettingsForm, setupActions method, end");
//		filter.setOnApply(filters -> list.setData(fetch(filters)));
//		window.addOnShowAction(() -> System.out.println("This form is shown."));
	}

	@Override
	public void initComponents() {
		System.out.println("_AdminSettingsForm, initComponents method");
		window.init();
		details.init();
		list.init();

//		attachComponents();
	}

	@Override
	public void show() {
		System.out.println("_AdminSettingsForm, show method");
		super.show();
		window.show();
	}

	private List<Object> fetch(List<String> filters) {
		return gateway.getAllObjectsByFilter(filters);
	}

	private void attachComponents() {
		System.out.println("_NodeForm, attachComponents method");
		new FilterAttacher(this).combineTwoComponents();
		new ListAttacher(this).combineTwoComponents();
	}

	class FilterAttacher extends ComponentCombiner<Node> {

		public FilterAttacher(FormBase form) {
			setForm(form);
			System.out.println("FilterAttacher, FilterAttacher constructor");
			AdminSettingsWindowGlass window = getGlass(AdminSettingsWindowGlass.class);
			AdminSettingsDetailsGlass details = getGlass(AdminSettingsDetailsGlass.class);
			setAttacher(window.getFilterAttacher());
			setGrabber(details.getGlassGrabber());
		}

	}

	class ListAttacher extends ComponentCombiner<Node> {

		public ListAttacher(FormBase form) {
			setForm(form);
			System.out.println("ListAttacher, ListAttacher constructor");
			AdminSettingsWindowGlass window = getGlass(AdminSettingsWindowGlass.class);
			AdminSettingsListGlass list = getGlass(AdminSettingsListGlass.class);
			setAttacher(window.getListAttacher());
			setGrabber(list.getGlassGrabber());
		}

	}

}
