package com.genpact.mongo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

// watches - chokidar, hadoop, python, pycharm anaconda 
// jasmine - karma 
// jasmine - mocha
// jasmine - chai 

public class AppTest {

	static Employee employee;

	@BeforeAll
	static void setUp() {
		System.out.println("before all");
		employee = new Employee(101, "Sonu", 10.5);
	}

	@BeforeEach
	void fun() {
		System.out.println("before each");
	}

	@AfterAll
	static void tearDown() {
		System.out.println("after all");
		employee = null;
	}

	@Disabled // @Ignore 
	@Test
	public void testAdd() {
		System.out.println("add method");
		assertEquals(10, employee.add(5, 5));
	}

	@Test  // (timeout = 1000)
	public void tesToString() {
		System.out.println("to string method 1");
		String expected = "Employee [eid=101, name=Sonu, salary=10.5]";
		String actual = employee.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void tesToString2() {
		System.out.println("to string method 2");
		String unexpected = "Employee [eid=102, name=Monu, salary=10.6]";
		String actual = employee.toString();
		assertNotEquals(unexpected, actual);
	}

}
