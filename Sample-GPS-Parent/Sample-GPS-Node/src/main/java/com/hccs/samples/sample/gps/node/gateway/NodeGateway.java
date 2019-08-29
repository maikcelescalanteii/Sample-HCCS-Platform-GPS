package com.hccs.samples.sample.gps.node.gateway;

import java.util.List;

public interface NodeGateway {

	public List<Object> getAllObjectsByFilter(List<String> filters);
}
