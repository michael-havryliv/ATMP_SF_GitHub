package models.widget;

import lombok.Data;
import models.widget.WidgetOptions;
import models.widget.WidgetPosition;
import models.widget.WidgetSize;

@Data
public class UpdateWidgetsItem{
	private String widgetName;
	private WidgetOptions widgetOptions;
	private int widgetId;
	private boolean share;
	private WidgetPosition widgetPosition;
	private WidgetSize widgetSize;
	private String widgetType;

	public UpdateWidgetsItem(){}

	public UpdateWidgetsItem(String widgetName, WidgetOptions widgetOptions, int widgetId, boolean share, WidgetPosition widgetPosition, WidgetSize widgetSize, String widgetType) {
		this.widgetName = widgetName;
		this.widgetOptions = widgetOptions;
		this.widgetId = widgetId;
		this.share = share;
		this.widgetPosition = widgetPosition;
		this.widgetSize = widgetSize;
		this.widgetType = widgetType;
	}
}