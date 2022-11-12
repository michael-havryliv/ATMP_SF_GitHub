package models.widget;

import java.util.List;
import lombok.Data;

@Data
public class Widget{
	private List<Integer> filterIds;
	private String name;
	private String description;
	private boolean share;
	private ContentParameters contentParameters;
	private String widgetType;

	public Widget(){}

	public Widget(List<Integer> filterIds, String name, String description, boolean share, ContentParameters contentParameters, String widgetType) {
		this.filterIds = filterIds;
		this.name = name;
		this.description = description;
		this.share = share;
		this.contentParameters = contentParameters;
		this.widgetType = widgetType;
	}
}