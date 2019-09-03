package com.hccs.samples.sample.gps.node.dashboard.list;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.SupervisingController;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

@SupervisingController
public class _DashboardListController implements DashboardListController {

	@Autowired
	private DashboardListPresenter presenter;
	@Autowired
	private ObjectToAdapterTransformer transformer;

	@Override
	public void init() {
		presenter.init();
	}

	@Override
	public void setupActions() {
	}

	public void setData(List<StudentBean> data) {
		System.out.println("_ListController, setData method");
		presenter.setData(data.stream().map(transformer::transform).collect(Collectors.toList()));
	}

	@Override
	public void setOnSelectItem(Consumer<DashboardAdapter> adapter) {
		// TODO Auto-generated method stub
		presenter.setOnSelectItem(adapter);
	}

	@Override
	public void setOnInputMode() {
		// TODO Auto-generated method stub
		presenter.setOnInputMode();
		
	}

	@Override
	public void setOnCancelMode() {
		// TODO Auto-generated method stub
		presenter.setOnCancelMode();
	}
	
//	public void setData(List<StudentBean> data) {
//		System.out.println("_ListController, setData method");
//		presenter.setData(extracted(data));
//	}
//
//	private List<Adapter> extracted(List<StudentBean> data) {
//		return data.stream().map(new Function<StudentBean, Adapter>() {
//			@Override
//			public Adapter apply(StudentBean t) {
//				return transformer.transform(t);
//			}
//		}).collect(Collectors.toList());
//	}

}
