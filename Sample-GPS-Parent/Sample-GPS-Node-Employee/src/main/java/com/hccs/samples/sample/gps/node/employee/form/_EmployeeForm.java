package com.hccs.samples.sample.gps.node.employee.form;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.ComponentCombiner;
import com.hccs.samples.sample.gps.core.FormBase;
import com.hccs.samples.sample.gps.core.annotations.Form;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.employee.EmployeeFormConfig;
import com.hccs.samples.sample.gps.node.employee.details.EmployeeDetailsController;
import com.hccs.samples.sample.gps.node.employee.details.EmployeeDetailsGlass;
import com.hccs.samples.sample.gps.node.employee.gateway.NodeGateway;
import com.hccs.samples.sample.gps.node.employee.list.Adapter;
import com.hccs.samples.sample.gps.node.employee.list.EmployeeListController;
import com.hccs.samples.sample.gps.node.employee.list.EmployeeListGlass;
import com.hccs.samples.sample.gps.node.employee.window.EmployeeWindowController;
import com.hccs.samples.sample.gps.node.employee.window.EmployeeWindowGlass;

import javafx.scene.Node;
@Form
public class _EmployeeForm extends FormBase implements EmployeeForm {

	@Autowired
	private NodeGateway gateway;

	protected EmployeeWindowController window;
	protected EmployeeDetailsController filter;
	protected EmployeeListController list;

	@Override
	public Class<?> configClass() {
		System.out.println("_NodeForm, configClass method");
		return EmployeeFormConfig.class;
	}

	@Override
	public void postContextSetup() {
		System.out.println("_NodeForm, postContextSetup method");
		window = getBean(EmployeeWindowController.class);
		filter = getBean(EmployeeDetailsController.class);
		list = getBean(EmployeeListController.class);
	}

	@Override
	public void setupActions() {
//		System.out.println("_NodeForm, setupActions method");
//		filter.setOnApply(filters -> list.setData(fetch(filters)));
//		window.addOnShowAction(() -> System.out.println("This form is shown."));
		
		window.setupActions();
		System.out.println("_NodeForm, setupActions method, start");
		
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
				filter.setOnSelectItem(selectedStud);
			}
		});
		
		window.addOnNewAction(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				filter.setOnNew();
			}
		});
		
		window.addOnCancelAction(new Runnable () {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				filter.setOnCancel();
			}
			
		});
		
		filter.setOnModifyList(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				list.setOnModifyList();
				
			}
			
		});
		
		System.out.println("_NodeForm, setupActions method, end");
//		filter.setOnApply(filters -> list.setData(fetch(filters)));
//		window.addOnShowAction(() -> System.out.println("This form is shown."));
	}

	@Override
	public void initComponents() {
		System.out.println("_NodeForm, initComponents method");
		window.init();
		filter.init();
		list.init();

		attachComponents();
	}

	@Override
	public void show() {
		System.out.println("_NodeForm, show method");
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
			EmployeeWindowGlass window = getGlass(EmployeeWindowGlass.class);
			EmployeeDetailsGlass filter = getGlass(EmployeeDetailsGlass.class);
			setAttacher(window.getFilterAttacher());
			setGrabber(filter.getGlassGrabber());
		}

	}

	class ListAttacher extends ComponentCombiner<Node> {

		public ListAttacher(FormBase form) {
			setForm(form);
			System.out.println("ListAttacher, ListAttacher constructor");
			EmployeeWindowGlass window = getGlass(EmployeeWindowGlass.class);
			EmployeeListGlass list = getGlass(EmployeeListGlass.class);
			setAttacher(window.getListAttacher());
			setGrabber(list.getGlassGrabber());
		}

	}

}
