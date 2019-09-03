package com.hccs.samples.sample.gps.node.admin.profile.form;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.ComponentCombiner;
import com.hccs.samples.sample.gps.core.FormBase;
import com.hccs.samples.sample.gps.core.annotations.Form;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.node.admin.profile.AdminProfileFormConfig;
import com.hccs.samples.sample.gps.node.admin.profile.details.AdminProfileDetailsController;
import com.hccs.samples.sample.gps.node.admin.profile.details.AdminProfileDetailsGlass;
import com.hccs.samples.sample.gps.node.admin.profile.list.AdminProfileListController;
import com.hccs.samples.sample.gps.node.admin.profile.list.AdminProfileListGlass;
import com.hccs.samples.sample.gps.node.admin.profile.window.AdminProfileWindowController;
import com.hccs.samples.sample.gps.node.admin.profile.window.AdminProfileWindowGlass;
import com.hccs.samples.sample.gps.node.admin.profile.gateway.NodeGateway;
import com.hccs.samples.sample.gps.node.admin.profile.list.Adapter;
import javafx.scene.Node;

@Form
public class _AdminProfileForm extends FormBase implements AdminProfileForm {

	@Autowired
	private NodeGateway gateway;

	protected AdminProfileWindowController window;
	protected AdminProfileDetailsController details;
	protected AdminProfileListController list;

	@Override
	public Class<?> configClass() {
		System.out.println("_AdminProfileForm, configClass method");
		return AdminProfileFormConfig.class;
	}

	@Override
	public void postContextSetup() {
		System.out.println("_AdminProfileForm, postContextSetup method");
		window = getBean(AdminProfileWindowController.class);
		details = getBean(AdminProfileDetailsController.class);
		list = getBean(AdminProfileListController.class);
	}

	@Override
	public void setupActions() {
//		System.out.println("_NodeForm, setupActions method");
//		filter.setOnApply(filters -> list.setData(fetch(filters)));
//		window.addOnShowAction(() -> System.out.println("This form is shown."));
		
		window.setupActions();
		System.out.println("_AdminProfileForm, setupActions method, start");
		
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
		
		System.out.println("_AdminProfileForm, setupActions method, end");
//		filter.setOnApply(filters -> list.setData(fetch(filters)));
//		window.addOnShowAction(() -> System.out.println("This form is shown."));
	}

	@Override
	public void initComponents() {
		System.out.println("_AdminProfileForm, initComponents method");
		window.init();
		details.init();
		list.init();

//		attachComponents();
	}

	@Override
	public void show() {
		System.out.println("_AdminProfileForm, show method");
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
			AdminProfileWindowGlass window = getGlass(AdminProfileWindowGlass.class);
			AdminProfileDetailsGlass details = getGlass(AdminProfileDetailsGlass.class);
			setAttacher(window.getFilterAttacher());
			setGrabber(details.getGlassGrabber());
		}

	}

	class ListAttacher extends ComponentCombiner<Node> {

		public ListAttacher(FormBase form) {
			setForm(form);
			System.out.println("ListAttacher, ListAttacher constructor");
			AdminProfileWindowGlass window = getGlass(AdminProfileWindowGlass.class);
			AdminProfileListGlass list = getGlass(AdminProfileListGlass.class);
			setAttacher(window.getListAttacher());
			setGrabber(list.getGlassGrabber());
		}

	}

}
