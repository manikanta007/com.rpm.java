package com.rpm.java.app;

public class MainClass {

	public static void main(String... arg){
		
		ClassA classA=new ClassA();
		System.out.println(classA);
		System.out.println(classA.hashCode());
		System.out.println(classA.getClass());
	}
}
