package stack;

public class Point implements Comparable {

	private int x;
	private int y;
	
	public Point(){
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public double distance (int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public int comperTo(Object o) {
		if(o instanceof Point) {
			Point start = new Point(0,0);
			return (int) (this.distance(start.getX(), start.getY()) - 
					((Point) o).distance(start.getX(), start.getY()));
		}
		return 0;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point start = new Point(0,0);
			return (int) (this.distance(start.getX(), start.getY()) - 
					((Point) o).distance(start.getX(), start.getY()));
		}		// TODO Auto-generated method stub
		return 0;
	}
	
}
