package com.tdd.tddCalculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Test;

public class CalculatorAsumptionTest {
	
	@Test
	void testSum() {
		CalculatorBS myCalculator = new CalculatorBS();
		Integer number1 = 3;
		Integer number2 = 4;
		Integer sumResult;
		Integer expectedSumResult = 7;
		
		sumResult = myCalculator.sum(number1, number2);
		
		assumingThat(
				System.getProperty("os.name").equalsIgnoreCase("Linux"), 
				() -> {
					assertEquals(sumResult, expectedSumResult, "Error Sum is not 7!!!");
				});
		
		/*assertAll(() -> {
			assertTrue(sumResult != null);
			assertFalse(!sumResult.equals(expectedSumResult), "Error!!!");
			assertTrue(sumResult.equals(expectedSumResult + 4));
		});*/
	}
}
