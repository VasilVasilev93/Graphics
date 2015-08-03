package shapes;

public class Point {
	
	private double x = 0;
	private double y = 0;

	
	public double getX() {
		return x;
	}


	public void setX(double d) {
		this.x = d;
	}


	public double getY() {
		return y;
	}


	public void setY(double d) {
		this.y = d;
	}


	public double distance(Point other){
		return (((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y)));	
	}
	
	public Point topProjection(){
		Point projection = new Point();
		projection.setX((x >= y) ? 0 : x);
		projection.setY(((y > x) ? 0 : y));
		return projection;
		
	}
	
	public Point symetricX(int max){
		Point symetric = new Point();
		symetric.setX(x);
		symetric.setY(max - y);
		return symetric;
	}
	
	public Point symetricY(int max){
		Point symetric = new Point();
		symetric.setX(max - x);
		symetric.setY(y);
		return symetric;
	}
}
