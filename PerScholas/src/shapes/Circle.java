package shapes;

public class Circle extends Shape {
	
	private double diameter;
	
	@Override
	public double calculateArea() {
		return 3.14159 * getRadius() * getRadius();
	}
	
	@Override
	public double calculatePeri() {
		return 3.14159 * getRadius() * 2;
	}
	
	public double getRadius() {
		return diameter / 2;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}


}
