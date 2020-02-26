package oblici;

import java.awt.Color;
import java.awt.Graphics;



public abstract class AreaShape extends Shape {
	
	/*Klasa koja opisuje sve oblike, koji imaju povrsinu.
	 * Ova klasa nasledjuje klasu Oblik
	 * */
	
	private Color innerColor;

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	public abstract void draw(Graphics g);
	
	public abstract double area();
	

}
