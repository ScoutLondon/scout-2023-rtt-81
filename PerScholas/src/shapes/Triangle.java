package shapes;

public class Triangle extends Shape {
	
	private double baseSide;
	private double sideB;
	private double sideC;
	private double height;
	public double getBaseSide() {
		return baseSide;
	}
	public void setBaseSide(double baseSide) {
		this.baseSide = baseSide;
	}
	public double getSideB() {
		return sideB;
	}
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}
	public double getSideC() {
		return sideC;
	}
	public void setSideC(double sideC) {
		this.sideC = sideC;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public double calculateArea() {
		return baseSide * height;
	}
	
	@Override
	public double calculatePeri() {
		return baseSide + sideB + sideC;
	}

}
