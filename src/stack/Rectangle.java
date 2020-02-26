package stack;

/**
 * @author Peki
 *
 */
public class Rectangle implements Comparable{

	private Point upperLeftPoint; 
	private int height;
	private int width;
	

	public Rectangle(){
		
	}
	
	public Rectangle(Point upperLeftPoint, int height, int width){
	
		this.upperLeftPoint = upperLeftPoint;
		setHeight(height);
		setWidth(width);
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
	
	public int area(){
		return height * width;
	}
	
	public String toString() {
		return "Upper left point= " +  upperLeftPoint + ", height= " + height + ", width= " + width;
	}
	
	
	//ovu metodu poriva sort
	@Override
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return this.area() - ((Rectangle) o).area();
		}
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}

