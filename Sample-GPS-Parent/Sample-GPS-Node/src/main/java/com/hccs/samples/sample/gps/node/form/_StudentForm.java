package com.hccs.samples.sample.gps.node.form;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.ComponentCombiner;
import com.hccs.samples.sample.gps.core.FormBase;
import com.hccs.samples.sample.gps.core.annotations.Form;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.StudentFormConfig;
import com.hccs.samples.sample.gps.node.filter.StudentReportTableController;
import com.hccs.samples.sample.gps.node.filter.StudentReportTableGlass;
import com.hccs.samples.sample.gps.node.gateway.NodeGateway;
import com.hccs.samples.sample.gps.node.list.Adapter;
import com.hccs.samples.sample.gps.node.list.StudentListController;
import com.hccs.samples.sample.gps.node.list.StudentListGlass;
import com.hccs.samples.sample.gps.node.window.StudentWindowController;
import com.hccs.samples.sample.gps.node.window.StudentWindowGlass;

import javafx.scene.Node;
@Form
public class _StudentForm extends FormBase implements StudentForm {

	private double serialNo = Math.random();
	
	@Autowired
	private NodeGateway gateway;

	protected StudentWindowController window;
	protected StudentReportTableController report;
	protected StudentListController list;

	@Override
	public Class<?> configClass() {
		System.out.println("_NodeForm, configClass method");
		return StudentFormConfig.class;
	}

	@Override
	public void postContextSetup() {
		System.out.println("_NodeForm, postContextSetup method");
		window = getBean(StudentWindowController.class);
		report = getBean(StudentReportTableController.class);
		list = getBean(StudentListController.class);
	}

	@Override
	public void setupActions() {
//		System.out.println("_NodeForm, setupActions method");
//		filter.setOnApply(filters -> list.setData(fetch(filters)));
//		window.addOnShowAction(() -> System.out.println("This form is shown."));
		
		System.out.println("SN: " + serialNo);
		window.setupActions();
		System.out.println("_NodeForm, setupActions method, start");
		
		window.addOnSetAction(new Consumer<List<StudentBean>>() {
			@Override
			public void accept(List<StudentBean> studList) {
				list.setData(studList);
			}
		});
		list.setOnSelectItem(new Consumer<Adapter>() {
			@Override
			public void accept(Adapter selectedStud) {
				report.setOnSelectItem(selectedStud);
				window.addOnSelectedItemAction();
			}
		});
		
		window.addOnNewAction(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				report.setOnNew();
				list.setOnInputMode();
			}
		});
		
		window.addOnEditAction(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				report.setOnEdit();
				list.setOnInputMode();
			}
			
		});
		
		window.addOnCancelAction(new Runnable () {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				report.setOnCancel();
				list.setOnCancelMode();
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
		report.init();
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
			StudentWindowGlass window = getGlass(StudentWindowGlass.class);
			StudentReportTableGlass filter = getGlass(StudentReportTableGlass.class);
			setAttacher(window.getFilterAttacher());
			setGrabber(filter.getGlassGrabber());
		}

	}

	class ListAttacher extends ComponentCombiner<Node> {

		public ListAttacher(FormBase form) {
			setForm(form);
			System.out.println("ListAttacher, ListAttacher constructor");
			StudentWindowGlass window = getGlass(StudentWindowGlass.class);
			StudentListGlass list = getGlass(StudentListGlass.class);
			setAttacher(window.getListAttacher());
			setGrabber(list.getGlassGrabber());
		}

	}

}
