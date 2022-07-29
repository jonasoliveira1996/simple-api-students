package com.owner.school;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SchoolApplicationTests {

	calculator calc = new calculator();
	@Test
	void contextLoads() {
		assertThat(calc.add(40, 10)).isEqualTo(50);
	}

	class calculator {
		int add(int a, int b) {
			return a + b;
		}
	}

}
