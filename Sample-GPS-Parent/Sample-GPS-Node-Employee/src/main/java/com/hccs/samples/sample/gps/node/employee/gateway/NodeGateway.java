package com.hccs.samples.sample.gps.node.employee.gateway;

import java.util.List;

public interface NodeGateway {

	public List<Object> getAllObjectsByFilter(List<String> filters);
}
