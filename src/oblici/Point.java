package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{

	private int x;
	private int y;
	
	public Point (){
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y= y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);
		setSelected(selected);
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y += byY;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	//metoda crtanja i selektovanja
	public void draw(Graphics g) {
		g.drawLine(this.x-2, this.y, this.x+2, this.y);
		g.drawLine(this.x, this.y-2, this.x, this.y+2);
		
		if(isSelected()) {
			g.drawRect(this.x-3, this.y-3, 6, 6);
			g.setColor(Color.BLACK);
		}
	}
	
	
	//metoda poredjenja
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point start = new Point (0,0);
			return (int) (this.distance(start.getX(), (int) (start.getY() -
					((Point) o).distance(start.getX(), start.getY()))));
		}
		return 0;
	}
	
	//metoda rastojanje
	public double distance (int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	//metoda sadrzi
	public boolean constains(int x, int y) {
		return this.distance(x, y) <= 3;
	}
	
	
	
	

}
