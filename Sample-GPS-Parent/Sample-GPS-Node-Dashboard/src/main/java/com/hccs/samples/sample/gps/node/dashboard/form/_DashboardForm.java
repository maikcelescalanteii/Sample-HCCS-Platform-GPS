package com.hccs.samples.sample.gps.node.dashboard.form;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.ComponentCombiner;
import com.hccs.samples.sample.gps.core.FormBase;
import com.hccs.samples.sample.gps.core.annotations.Form;
import com.hccs.samples.sample.gps.models.beans.StudentBean;
import com.hccs.samples.sample.gps.node.dashboard.DashboardFormConfig;
import com.hccs.samples.sample.gps.node.dashboard.details.DashboardDetailsController;
import com.hccs.samples.sample.gps.node.dashboard.details.DashboardDetailsGlass;
import com.hccs.samples.sample.gps.node.dashboard.gateway.DashboardGateway;
import com.hccs.samples.sample.gps.node.dashboard.list.DashboardAdapter;
import com.hccs.samples.sample.gps.node.dashboard.list.DashboardListController;
import com.hccs.samples.sample.gps.node.dashboard.list.DashboardListGlass;
import com.hccs.samples.sample.gps.node.dashboard.window.DashboardWindowController;
import com.hccs.samples.sample.gps.node.dashboard.window.DashboardWindowGlass;

import javafx.scene.Node;
@Form
public class _DashboardForm extends FormBase implements DashboardForm {

	private double serialNo = Math.random();
	
	@Autowired
	private DashboardGateway gateway;

	protected DashboardWindowController window;
	protected DashboardDetailsController report;
	protected DashboardListController list;

	@Override
	public Class<?> configClass() {
		System.out.println("_NodeForm, configClass method");
		return DashboardFormConfig.class;
	}

	@Override
	public void postContextSetup() {
		System.out.println("_NodeForm, postContextSetup method");
		window = getBean(DashboardWindowController.class);
		report = getBean(DashboardDetailsController.class);
		list = getBean(DashboardListController.class);
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
		list.setOnSelectItem(new Consumer<DashboardAdapter>() {
			@Override
			public void accept(DashboardAdapter selectedStud) {
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
			DashboardWindowGlass window = getGlass(DashboardWindowGlass.class);
			DashboardDetailsGlass filter = getGlass(DashboardDetailsGlass.class);
			setAttacher(window.getFilterAttacher());
			setGrabber(filter.getGlassGrabber());
		}

	}

	class ListAttacher extends ComponentCombiner<Node> {

		public ListAttacher(FormBase form) {
			setForm(form);
			System.out.println("ListAttacher, ListAttacher constructor");
			DashboardWindowGlass window = getGlass(DashboardWindowGlass.class);
			DashboardListGlass list = getGlass(DashboardListGlass.class);
			setAttacher(window.getListAttacher());
			setGrabber(list.getGlassGrabber());
		}

	}

}
