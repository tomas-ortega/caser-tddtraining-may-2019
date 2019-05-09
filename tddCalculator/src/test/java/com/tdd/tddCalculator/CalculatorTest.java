package com.tdd.tddCalculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("AAA")
class CalculatorTest {
	
	@BeforeAll
	static void testBeforeAllDoThis() {
		System.out.println("Before All Execute this!!!");
	}
	
	@BeforeEach
	void testBeforeEachDoThis() {
		System.out.println("Before each test Execute this!!!");
	}
	
	@Test
	void testDivideByZero() {
		CalculatorBS myCalculator = new CalculatorBS();
		Integer number1 = 0;
		Integer number2 = 0;
		
		assertThrows(ArithmeticException.class, () -> {
			myCalculator.divide(number1, number2);
		});	
	}
	
	@Test
	void testSumWithAssertTimeoutPreemptively() {
		CalculatorBS myCalculator = new CalculatorBS();
		Integer number1 = 3;
		Integer number2 = 4;
        Integer expectedSecondsTimeout = 5;
		
        assertTimeoutPreemptively(Duration.ofSeconds(expectedSecondsTimeout), () -> {
        	Integer sumResult;
        	Integer expectedSumValue = 7;
        	
        	sumResult = myCalculator.sum(number1, number2);
        	
        	Thread.sleep(1000);
        	
        	assertTrue(sumResult.equals(expectedSumValue));
        });
	}

	@Test
	void testSumWithAssertTimeout() {
		CalculatorBS myCalculator = new CalculatorBS();
		Integer number1 = 3;
		Integer number2 = 4;
        Integer expectedSecondsTimeout = 3;
		
        assertTimeout(Duration.ofSeconds(expectedSecondsTimeout), () -> {
        	myCalculator.sum(number1, number2);
        	Thread.sleep(1000);
        });
	}
	
	@Test
	@Disabled("Deactivated because hay pollos!!!")
	void testSum() {
		CalculatorBS myCalculator = new CalculatorBS();
		Integer number1 = 3;
		Integer number2 = 4;
		Integer sumResult;
		Integer expectedSumResult = 7;
		
		sumResult = myCalculator.sum(number1, number2);
		
		assertAll(() -> {
			assertTrue(sumResult != null);
			assertFalse(!sumResult.equals(expectedSumResult), "Error!!!");
			assertTrue(sumResult.equals(expectedSumResult + 4));
		});
	}
	
	@Test
	@DisplayName("Test Multiply")
	void testMultiply() {
		CalculatorBS myCalculator = new CalculatorBS();
		Integer multiplyResult;
		Integer number1 = 2;
		Integer number2 = 3;
		Integer expectedValue = 6;
		
		multiplyResult = myCalculator.multiply(number1, number2);
		
		assertTrue(multiplyResult.equals(expectedValue));
	}
	
	@AfterEach
	void testAfterEachDoThis() {
		System.out.println("After each execute this!!!");
	}
	
	@AfterAll
	static void testAllAfterDoThis() {
		System.out.println("After all test execute this!!!");
	}
}
