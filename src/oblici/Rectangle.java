package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int height;
	private int width;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width) {
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width, boolean selected) {
		this(upperLeftPoint,height, width);
		setSelected(selected);
	}
	
	public int area() {
		return height * width;
	}

	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}

	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public String toString(){
		return "Upper Left point= " + upperLeftPoint + ", height= " + height + ", width= " + width;
	}
	
	//metoda sadrzi
	public boolean constains(int x, int y) {
		if(this.getUpperLeftPoint().getX() <= x && 
				this.getUpperLeftPoint().getY() <= y &&
				x <= this.getUpperLeftPoint().getX() + width &&
				y <= this.getUpperLeftPoint().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public void moveBy(int byX, int byY) {
		upperLeftPoint.moveBy(byX, byY);
	}

	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			return this.area() - ((Rectangle) o).area();
		}		
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(this.getUpperLeftPoint().getX(), this.getUpperLeftPoint().getY(), this.width, this.height);
		
		if(isSelected()) {
			g.setColor(Color.BLACK);
			/*1*/	g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() -3, 6, 6);
			/*2*/	g.drawRect(this.getUpperLeftPoint().getX() - 3, this.getUpperLeftPoint().getY() - 3 + getHeight() ,6, 6);
			/*4*/	g.drawRect(this.getUpperLeftPoint().getX() + getWidth() -3, this.getUpperLeftPoint().getY() + getHeight() -3, 6,6);
			/*3*/	g.drawRect(this.getUpperLeftPoint().getX() + getWidth() -3, this.getUpperLeftPoint().getY() -3, 6,6);
		}
	}
}
