package com.iea.cozum.program;

public class Fizyoterapist extends Calisan
{

	public Fizyoterapist(int calisanID, String ad, String soyad) {
		super(calisanID, ad, soyad);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void isYap() 
	{
		System.out.println("Tedavi programý uygulanýyor.");
	}
}
