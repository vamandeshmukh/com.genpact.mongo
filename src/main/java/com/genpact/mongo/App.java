package com.genpact.mongo;

/** 
 * 
 * @author Vaman Deshmukh 
 *
 */

class Manager {
	static ClassTwo getClass2() {
		return new ClassTwo();
	}
}


class ClassOne {
	int id;
	ClassTwo classTwo = Manager.getClass2();
	
	
}

class ClassTwo {
	int id2;
	
}




public class App {
	public static void main(String[] args) {
		
		System.out.println("Hello World!");
		
		Employee emp = new Employee(101, "Sonu", 10.5);
		
		Employee emp2 = emp;
		
		System.out.println(emp.toString());
		
		
	}
}
