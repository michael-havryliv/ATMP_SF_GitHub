package models.dashboard;

import java.util.List;
import lombok.Data;
import models.widget.UpdateWidgetsItem;

@Data
public class DashboardWithWidged{
	private String name;
	private String description;
	private boolean share;
	private List<UpdateWidgetsItem> updateWidgets;

	public DashboardWithWidged(){}

	public DashboardWithWidged(String name, String description, boolean share, List<UpdateWidgetsItem> updateWidgets){
		setName(name);
		setDescription(description);
		setShare(share);
		setUpdateWidgets(updateWidgets);
	}
}