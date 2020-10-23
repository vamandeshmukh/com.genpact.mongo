package com.genpact.mongo;

public class Employee {

	private int eid; // 4 bytes 
	private String name; // depends 
	private double salary; // 8 

	public Employee(int eid, String name, double salary) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
	}

	public Employee() {
		
	}

	public int add(int i, int j) {
		return i + j;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", name=" + name + ", salary=" + salary + "]";
	}

}
