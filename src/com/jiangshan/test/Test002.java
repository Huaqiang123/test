package com.jiangshan.test;

import java.util.Scanner;

public class Test002 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入第一个数字:");
		int num1 = scanner.nextInt();
		System.out.println("请输入第二个数字:");
		int num2 = scanner.nextInt();
		System.out.println("和:");
		int sum = num1 + num2;
		System.out.println(sum);
		scanner.close();
	}
	
}
