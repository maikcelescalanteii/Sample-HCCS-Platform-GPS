package com.hccs.samples.sample.gps.node.employee.list;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.SupervisingController;
import com.hccs.samples.sample.gps.models.beans.EmployeeBean;
import com.hccs.samples.sample.gps.models.beans.StudentBean;

@SupervisingController
public class _EmployeeListController implements EmployeeListController {

	@Autowired
	private EmployeeListPresenter presenter;
	@Autowired
	private ObjectToAdapterTransformer transformer;

	@Override
	public void init() {
		presenter.init();
	}

	@Override
	public void setupActions() {
	}

	public void setData(List<EmployeeBean> data) {
		System.out.println("_ListController, setData method");
		presenter.setData(data.stream().map(transformer::transform).collect(Collectors.toList()));
	}

	@Override
	public void setOnSelectItem(Consumer<Adapter> adapter) {
		// TODO Auto-generated method stub
		presenter.setOnSelectItem(adapter);
	}

	@Override
	public void setOnModifyList() {
		// TODO Auto-generated method stub
		presenter.setOnModifyList();
		
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
