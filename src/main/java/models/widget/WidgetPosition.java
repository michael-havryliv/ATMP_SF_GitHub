package models.widget;

import lombok.Data;

@Data
public class WidgetPosition{
	private int positionY;
	private int positionX;

	public WidgetPosition(){}

	public WidgetPosition(int positionY, int positionX) {
		this.positionY = positionY;
		this.positionX = positionX;
	}
}