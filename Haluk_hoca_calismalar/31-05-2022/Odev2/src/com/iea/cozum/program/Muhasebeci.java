package com.iea.cozum.program;

// Muhasebeci is a Calisan. (is a relationship)
// Muhasebeci bir Calisan'dýr. (bir isiþkisi)
public class Muhasebeci extends Calisan
{

	public Muhasebeci(int calisanID, String ad, String soyad) 
	{
		super(calisanID, ad, soyad);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void isYap() 
	{
		System.out.println("Finansal takip yapýlýyor.");
	}
}
