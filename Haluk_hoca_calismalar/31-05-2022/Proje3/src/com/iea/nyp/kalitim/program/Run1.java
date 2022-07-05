package com.iea.nyp.kalitim.program;

public class Run1 
{

	public static void main(String[] args) 
	{
		Calisan calisan1 =  new Calisan();
		calisan1.calisanID = 555991;
		calisan1.isim = "Mahmut";
		calisan1.soyisim = "Durmaz";
		calisan1.calis();
		calisan1.molaVer();
		
		System.out.println("\n");
		
		Calisan calisan2 =  new Calisan();
		calisan2.calisanID = 555993;
		calisan2.isim = "Sevim";
		calisan2.soyisim = "Caliskan";
		calisan2.calis();
		calisan2.molaVer();
	}

}
