package com.iea.cozum1.program;

import java.util.Scanner;

public class Main 
{

	private static final int CAP_LIMIT = 1;
	private static final double PI = 3.14;
	private static final double HATA = -1;

	public static void main(String[] args) 
	{
		
		Scanner klavye = new Scanner(System.in);
		
		
		System.out.println("Lütfen çap deðerini giriniz:");
		int girilenDeger = klavye.nextInt();
		
		cemberCevreHesapla(girilenDeger);
		
		double alan = daireAlanHesapla(girilenDeger);
		
		if(alan == HATA)
		{
			System.out.println("Girilen çap deðeri " + CAP_LIMIT + "'den büyük olmalýdýr.");
		}
		else
		{
			System.out.println("Çap deðeri " + girilenDeger + " için daire alaný: " + alan);
		}
		
		klavye.close();
	}


	private static double daireAlanHesapla(int cap) 
	{
		double alan = HATA;
		double yaricap;
		
		if(cap < CAP_LIMIT)
		{
			System.out.println("Yanlýþ bir deðer girdiniz.");
		}
		else
		{
			yaricap = cap / 2;
			alan = PI * Math.pow(yaricap, 2);
		}
		
		return alan;
	}

	private static void cemberCevreHesapla(int cap) 
	{
		double cevre;
		double yaricap;
		
		if(cap < CAP_LIMIT)
		{
			System.out.println("Yanlýþ bir deðer girdiniz.");
		}
		else
		{
			yaricap = cap / 2;
			cevre = 2 * PI * yaricap;
			System.out.println("Çap deðeri " + cap + " için çevre: " + cevre);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
