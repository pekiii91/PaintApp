package oblici;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	private Point center;
	private int radius;
	
	public Circle(){
		
	}
	
	public Circle(Point center, int radius){
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected){
		this(center, radius);
		setSelected(selected);
	}
	
	//metoda poredjenja
	public int compareTo(Object o){
		if (o instanceof Circle) {
			return this.radius - ((Circle) o).radius; 
		}
		return 0;
	}
	
	//metoda crtanje i selektovanje
	public void draw(Graphics g) {
		g.drawOval(this.getCenter().getX() - getRadius(),
				getCenter().getY() - this.radius,
				this.getRadius()*2, this.getRadius()*2);
		
		//selektovanje
		if(isSelected()){
			g.setColor(Color.BLACK);;
			g.drawRect(this.getCenter().getX(), this.getCenter().getY(), 6, 6);
			
			g.drawRect(this.getCenter().getX(), this.getCenter().getY() - 3 + getRadius(), 6, 6);
			g.drawRect(this.getCenter().getX() - 3 + getRadius(), this.getCenter().getY(), 6, 6);
			
			g.drawRect(this.getCenter().getX() - 3 - getRadius(), this.getCenter().getY(), 6, 6);
			g.drawRect(this.getCenter().getX(), this.getCenter().getY() - 3 - getRadius(), 6, 6);


		}
		
	}
	
	
	//metoda sadrzi Tacku u Krugu
	public boolean contains(Point p) {
		return p.distance(getCenter().getX(), getCenter().getY()) <= radius;
	}

	
	public double area(){
		return radius*radius* Math.PI;
	}
	
	public Point getCenter(){
		return center;
	}
	
	public void setCenter(Point center){
		this.center = center;
	}
	
	public int getRadius(){
		return radius;
	}
	
	public void setRadius(int radius){
		this.radius = radius;
	}
	
	public String toString() {
		return "Center=" + center + " , radius="+ radius;
	}
	
	public void moveBy(int byX, int byY){
		center.moveBy(byX, byY);
	}

	//metoda koja sadrzi u Krug
	@Override
	public boolean constains(int x, int y) {
		// TODO Auto-generated method stub
		return this.getCenter().distance(x, y) <= radius;
	}

	
	
	
	
	
	
}
