package com.example.boot_test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

//AssertJ를 이용한 어설션. 특정 지점에서 반드시참이어야 하는 조건을 명시하는 것


public class AssertionTest {
	@Test
	void testString() {
		String str = "Hello, World!";
		
		assertThat(str)
		.isNotNull() //문자열이 null이라면 에러를 발생해달라
		.startsWith("Hello")
		.endsWith("!");
	}
	
	
	@Test
	void testInteger() {
		
//		Integer num = null;
//		Integer num = 39;
		Integer num = 42;
		
		assertThat(num)
			.isNotNull()
			.isGreaterThan(40) //40 초과
			.isLessThan(50) // 50 미만
			.isEqualTo(42);
	}
	
	@Test
	void testList() {
		List<String> list = Arrays.asList("사과","바나나","체리");
		
		assertThat(list)
			.isNotNull()
			.hasSize(3)
			.contains("바나나")
			.doesNotContain("포도")
			.containsExactly("사과","바나나","체리");
	}
	
	
}



