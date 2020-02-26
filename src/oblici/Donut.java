package oblici;

import java.awt.Graphics;

/* Donut ili (Krug sa rupom) to je klasa koja nasledjuje Circle(Krug);
 * */

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut (Point center, int radius, int innerRadius, boolean selected){
		this(center, radius, innerRadius);
		setSelected(selected);
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public double area() {
		return super.area() - innerRadius*innerRadius * Math.PI;
	}
	
	//metoda poredjenja
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			return (int) (this.area() -  ((Donut) o).area());
		}
		return 0;
	}
	
	//metoda crtanje
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(getCenter().getX() - getInnerRadius(), 
				this.getCenter().getY() - this.getInnerRadius(),
				this.getInnerRadius()*2, this.getInnerRadius()*2);
	}
	
	public String toString(){
		return super.toString() + ", inner radius= " + innerRadius;
	}
	
	
	
}
