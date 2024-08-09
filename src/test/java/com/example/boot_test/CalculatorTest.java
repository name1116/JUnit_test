package com.example.boot_test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private Calculator calculator;
	
	
	@BeforeEach //각 테스트 메서드 실행 전에
	void setUp() {
		calculator = new Calculator();
	}
	
	@Test
	@DisplayName("1+1=2")
	void testAdd() {
		assertEquals(2, calculator.add(1, 1), "1+1은 2다");
	}
	
	@Test
	@DisplayName("2+2=4")
	void testAdd2() {
		assertEquals(4, calculator.add(2, 2), "2+2은 4다");
	}
	
	@Test
	@DisplayName("4/2=2")
	void testDeivide() {
		assertEquals(2, calculator.devide(4, 2));
	}
	
	@Test
	@DisplayName("1/0=exception")
	void testDeivide2() {
		assertThrows(ArithmeticException.class, () -> calculator.devide(1, 0));
	}
	
	@Test
	@Disabled // 테스트 스킵
	void testMinus() {
		
	}
	
	@Test
	@Disabled // 테스트 스킵
	void testMultiply () {
		
	}
	
	
}
