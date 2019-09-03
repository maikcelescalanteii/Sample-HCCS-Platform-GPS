package com.hccs.samples.sample.gps.node.dashboard.gateway;

import java.util.List;

public interface DashboardGateway {

	public List<Object> getAllObjectsByFilter(List<String> filters);
}
