import com.hccs.platform.components.tags.LayoutContainer;
import com.hccs.platform.components.tags.LayoutGroup.SplitType;

public class Layout {
	
	LayoutContainer left = new LayoutContainer("left", "20", 0, false);
	LayoutContainer center = new LayoutContainer("center", "70", 1);
	LayoutContainer right = new LayoutContainer("right", "10", 2);
	LayoutContainer top = new LayoutContainer("top", "80", 0);
	LayoutContainer bottom = new LayoutContainer("bottom", "10", 2);
	
	LayoutGroup vertical = new LayoutGroup(SplitType.VERTICAL, "80", 1);
	vertical.setLayoutContainers(left, center, right);
	
	LayoutGroup horizontal = new LayoutGroup(SplitType.HORIZONTAL);
	horizontal.setLayoutContainers(top, bottom);
	horizontal.setLayoutGroups(vertical);
	
}
