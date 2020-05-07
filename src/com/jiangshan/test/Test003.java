package com.jiangshan.test;

import java.util.Scanner;

public class Test003 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入年份:");
		int year = scanner.nextInt();
		scanner.close();
		int day = 1;
		for(int i=1; i<year; i++) {
			if((i%4==0 && i%100!=0) || i%400==0) {
				day += 366;
			} else {
				day += 365;
			}
		}
		int[] month = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		if((year%4==0 && year%100!=0) || year%400==0) {
			month[1]=29;
		}
		for(int i=1; i<=12; i++) {
			switch(i) {
				case 1:	System.out.printf("======%2d月======\n", i); break; 
				case 2: System.out.printf("======%2d月======\n", i); break; 
				case 3: System.out.printf("======%2d月======\n", i); break; 
				case 4: System.out.printf("======%2d月======\n", i); break; 
				case 5: System.out.printf("======%2d月======\n", i); break; 
				case 6: System.out.printf("======%2d月======\n", i); break; 
				case 7: System.out.printf("======%2d月======\n", i); break; 
				case 8: System.out.printf("======%2d月======\n", i); break; 
				case 9: System.out.printf("======%2d月======\n", i); break; 
				case 10: System.out.printf("======%2d月======\n", i); break; 
				case 11: System.out.printf("======%2d月======\n", i); break; 
				case 12: System.out.printf("======%2d月======\n", i); break; 
			}
			
		}
		System.out.println("一   二   三   四   五   六   七");
		
		
		
	}
	
}
