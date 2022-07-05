package com.iea.metot_imza.ornek1.program;

import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) 
	{
		Scanner klavye = new Scanner(System.in);
			
		System.out.println("Birinci say�y� giriniz:");
		int sayi1 = klavye.nextInt();
			
		
		System.out.println("ikinci say�y� giriniz:");
		int sayi2 = klavye.nextInt();
		
		int toplam = topla(sayi1, sayi2);
		System.out.println("Toplama i�leminin sonucu: " + toplam);		
		
		cikar(sayi1, sayi2);
		
		carp(sayi1, sayi2);
		
		double bolum = bol(sayi1, sayi2);
		System.out.println("B�lme i�leminin sonucu: " + bolum);
		
		klavye.close();
		
	}
		
	private static double bol(int num1, int num2) 
	{
		double sonuc = num1 / (double)num2;
		return sonuc;
	}

	private static void carp(int sayi1, int sayi2) 
	{
		double sonuc = sayi1  * sayi2;
		System.out.println("�arpma i�leminin sonucu: " + sonuc);
	}

	private static void cikar(int sayi1, int sayi2)
	{
		System.out.println("��karma i�leminin sonucu: " + (sayi1-sayi2));
	}

	private static int topla(int num1, int num2) 
	{
		return num1 + num2;
	}
	
}
