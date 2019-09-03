package com.hccs.samples.sample.gps.node.dashboard.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.hccs.samples.sample.gps.core.annotations.Gateway;

@Gateway
public class _DashboardGateway implements DashboardGateway {

	@Override
	public List<Object> getAllObjectsByFilter(List<String> filters) {
		return filters.stream().map(filter -> (Object) filter).collect(Collectors.toList());
	}

}
