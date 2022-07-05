package com.iea.cozum3.program;

import java.util.Scanner;

public class Main 
{

	private static final int LIM_MIN = 1;
	private static final int LIM_MAX = 1000;

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		int lim;
		int sonuc;
		
		while(true)
		{
			System.out.println("Tek tam say�lar�n ortalamas�n� bulmak i�in limit de�er giriniz:");
			lim = scanner.nextInt();
			if(lim < LIM_MIN || lim > LIM_MAX)
			{
				System.out.println("Limit de�er " + LIM_MIN + " ve " + LIM_MAX + " aras�nda olmal�d�r.");
				System.out.println("Limit de�eri tekrar giriniz.");
			}
			else
			{
				sonuc = tekSayiOrtalamaBul(lim);
				System.out.println("Girilen limit de�er i�in tek say�lar�n ortalamas�: " + sonuc);
				break;
			}
		}
		
		scanner.close();
	}

	private static int tekSayiOrtalamaBul(int limit) 
	{
		int toplam = 0;
		int sayac = 0;
		for (int i = 0; i <= limit; i++) 
		{
			if(i % 2 == 1)
			{
				toplam = toplam + i;
				sayac++;
			}
		}
		
		return toplam / sayac;
	}

}
