package perscholas.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	
	@ParameterizedTest
	@CsvSource({
		"5, 5, 10",
		"10, 10, 20",
		"5.5, 5.5, 11.0"
	})
	public void additionTest(double a, double b, double answer) {
		Calculator c = new Calculator();
		
		double actual = c.add(a, b);
		
		Assertions.assertEquals(answer, actual);
	}
	
	@ParameterizedTest
	@CsvSource({
		"5, 5, 12",
		"10, 10, 20.5",
		"5.5, 5.5, 12.0"
	})
	public void additionErrorTest(double a, double b, double answer) {
		Calculator c = new Calculator();
		
		double actual = c.add(a, b);
		
		Assertions.assertNotEquals(answer, actual);
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"5, 5, 0",
		"45, 10, 35",
		"21, 7, 14"
	})
	public void subtractionTest(double a, double b, double answer) {
		Calculator c = new Calculator();
		
		double actual = c.subtract(a, b);
		
		Assertions.assertEquals(answer, actual);
	}
	
	
	@Test
	public void nonparameterizedSubtractionTest() {
		Calculator c = new Calculator();
		double expected = 0.0;
		
		double actual = c.subtract(5.0, 5.0);
		
		Assertions.assertEquals(expected, actual);
		
		Assertions.assertEquals(15.0, c.subtract(20.0, 5.0));
	}
	
	@ParameterizedTest
	@CsvSource({
		"5, 5, 25",
		"10, 10, 100",
		"20, 3, 60"
	})
	public void multiplyTest(double a, double b, double answer) {
		Calculator c = new Calculator();
		
		double actual = c.multiple(a, b);
		
		Assertions.assertEquals(answer, actual);
	}
	
	@ParameterizedTest
	@CsvSource({
		"5, 5, 1",
		"10, 5, 2",
		"35, 5, 7"
	})
	public void divideTest(double a, double b, double answer) {
		Calculator c = new Calculator();
		
		double actual = c.divide(a, b);
		
		Assertions.assertEquals(answer, actual);
	}

}
