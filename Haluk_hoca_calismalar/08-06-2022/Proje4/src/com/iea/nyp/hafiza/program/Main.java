package com.iea.nyp.hafiza.program;

import com.iea.nyp.kapsulleme.program.Calisan;

public class Main
{

	public static void main(String[] args)
	{
		int sayi1;
		sayi1 = 42;
		
		double sayi2 = 7.43;
		
		int sayi3;
		
		Calisan calisan1 = null;
		
		char ch1 = 'v';
		
		sayi3 = sayi1;
		
		calisan1 = new Calisan(555449, "Veli", "Ucmak");
		
		Calisan calisan2;
		
		calisan2 = calisan1;
		
		System.out.println(calisan2.isim);
	}

}
