package com.genpact.mongo;

/**
 * Hello world!
 *
 */

@FunctionalInterface
interface Delete {

	public abstract void m1();

//	public abstract void ma();

	static void m2() {

	}

	static void m22() {

	}

	default void m3() {

	}

	default void m4() {

	}

}

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}
