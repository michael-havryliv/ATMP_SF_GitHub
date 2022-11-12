package models.widget;

import java.util.List;
import lombok.Data;

@Data
public class ContentParameters{
	private WidgetOptions widgetOptions;
	private List<String> contentFields;
	private int itemsCount;

	public ContentParameters(){}

	public ContentParameters(WidgetOptions widgetOptions, List<String> contentFields, int itemsCount) {
		this.widgetOptions = widgetOptions;
		this.contentFields = contentFields;
		this.itemsCount = itemsCount;
	}
}