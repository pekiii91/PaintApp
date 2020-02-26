package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		setEndPoint(endPoint);
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		setSelected(selected);
	}
	
	public String toString() {
		return startPoint + "-->" + endPoint;
	}
	
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	//duzina linije
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	//metoda sredina linije
	public Point middleOfLine() {
		int middleByX = (this.getStartPoint().getX() + this.getStartPoint().getY()) / 2;
		int middleByY = (this.getEndPoint().getX() + this.getEndPoint().getY()) / 2;
		
		Point p = new Point(middleByX, middleByY);
		return p;
		
	}
	
	
	//metoda sadrzi
	public boolean constains(int x, int y) {
		if((startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <= 0.05) {
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (this.length() - ((Line) o).length());
		}
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(),
				this.getEndPoint().getX(), this.getEndPoint().getY());
		
		if(isSelected()) {
			g.drawRect(this.getStartPoint().getX()-3, this.getStartPoint().getY()-3, 6, 6);
			g.drawRect(getEndPoint().getX()-3, getEndPoint().getY()-3, 6, 6);
			g.drawRect(middleOfLine().getX() , middleOfLine().getY() , 6, 6);

			g.setColor(Color.BLACK);;
		}
		
	}

}
