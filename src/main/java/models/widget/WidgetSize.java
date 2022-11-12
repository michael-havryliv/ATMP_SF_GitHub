package models.widget;

import lombok.Data;

@Data
public class WidgetSize{
	private int width;
	private int height;

	public WidgetSize(){}

	public WidgetSize(int width, int height) {
		this.width = width;
		this.height = height;
	}
}