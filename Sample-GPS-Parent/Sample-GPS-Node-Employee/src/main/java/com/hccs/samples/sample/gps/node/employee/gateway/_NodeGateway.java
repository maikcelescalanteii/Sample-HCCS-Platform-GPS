package com.hccs.samples.sample.gps.node.employee.gateway;

import java.util.List;
import java.util.stream.Collectors;

import com.hccs.samples.sample.gps.core.annotations.Gateway;

@Gateway
public class _NodeGateway implements NodeGateway {

	@Override
	public List<Object> getAllObjectsByFilter(List<String> filters) {
		return filters.stream().map(filter -> (Object) filter).collect(Collectors.toList());
	}

}
