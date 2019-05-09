package com.tdd.tddCalculator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CalculatorNestedTest {
	
	@BeforeEach
	void testBeforeMainClass() {
		System.out.println("BEFORE IN MAIN CLASS!");
	}
	
	@Test
	void testMultiply() {
		CalculatorBS calculatorBs = new CalculatorBS();
		
		assertTrue(calculatorBs.multiply(2, 2).equals(4));
	}
	
	@Nested
	public class CalculatorSumTest {
		
		@BeforeEach
		void testBeforeAllInNested() {
			System.out.println("BEFORE EACH IN NESTED TEST!!!");
		}
		
		@Test
		public void testSum() {
			CalculatorBS calculatorBs = new CalculatorBS();
			
			assertTrue(calculatorBs.sum(2, 2).equals(4));
		}
		
	}
}
