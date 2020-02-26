package oblici;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable {
	
	private boolean selected;
	private Color color;
	
	
	public Shape(Color newBoja){ 
		color = newBoja;
	}
	
	
	public Color getColor() {
		return color;
	}



	public void setColor(Color newColor) {
		this.color = newColor;
	}

	//Konstruktor

	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected){
		this.selected = selected;
	}

	public abstract boolean constains(int x, int y);
	
	public abstract void draw(Graphics g);


}
