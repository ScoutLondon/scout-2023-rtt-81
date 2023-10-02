package shapes;

public class Rectangle extends Shape{
	
	private double height;
	private double width;
	
	//this is specific formula for area
	//of a rectangle.  This is implementation
	//of the Area interface
	@Override
	public double calculateArea() {
		return height * width;
	}
	
	@Override
	public double calculatePeri() {
		return ((height + width) *2);
	}
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}

}
