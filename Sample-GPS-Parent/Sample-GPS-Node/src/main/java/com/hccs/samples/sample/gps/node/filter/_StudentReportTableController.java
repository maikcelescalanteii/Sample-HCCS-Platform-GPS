package com.hccs.samples.sample.gps.node.filter;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;

import com.hccs.samples.sample.gps.core.annotations.SupervisingController;
import com.hccs.samples.sample.gps.node.list.Adapter;

@SupervisingController
public class _StudentReportTableController implements StudentReportTableController {

	@Autowired
	private StudentReportTablePresenter presenter;

	@Autowired
	private AdapterToObjectTransformer transformer;
	
	@Override
	public void init() {
		presenter.init();
	}

	@Override
	public void setupActions() {
		presenter.setOnClearFilter(this::clearFilter);
	}

	@Override
	public void setOnApply(Consumer<List<String>> consumer) {
		presenter.setOnApply(consumer);
	}

	private void clearFilter() {
		System.out.println("Filters are cleared");
	}

	@Override
	public void setOnSelectItem(Adapter adapter) {
		// TODO Auto-generated method stub
		presenter.setOnSelectItem(transformer.transform(adapter));
		
	}
	
	@Override
	public void setOnNew() {
		// TODO Auto-generated method stub
		presenter.setOnNew();	
	}

	@Override
	public void setOnEdit() {
		// TODO Auto-generated method stub
		presenter.setOnEdit();	
	}
	
	@Override
	public void setOnCancel() {
		// TODO Auto-generated method stub
		presenter.setOnCancel();
		
	}


} 
