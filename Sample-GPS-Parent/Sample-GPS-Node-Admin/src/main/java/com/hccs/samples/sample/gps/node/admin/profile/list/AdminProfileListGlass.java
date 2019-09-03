package com.hccs.samples.sample.gps.node.admin.profile.list;

import java.util.List;
import java.util.function.Consumer;

import com.hccs.samples.sample.gps.core.interfaces.Glass;
import com.hccs.samples.sample.gps.node.admin.settings.proxies.PartialGlass;

public interface AdminProfileListGlass extends Glass, PartialGlass {

	public void setData(List<Adapter> adapters);
	
	public void setOnSelectItem(Consumer<Adapter> adapter);

	public void setOnModifyList();
}
