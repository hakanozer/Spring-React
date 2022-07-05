package com.iea.nyp.kalitim.program;

// Muhasebeci bir Calisan'dýr.
public class Muhasebeci extends Calisan
{
	
	public Muhasebeci(int calisanID, String isim, String soyisim) 
	{
		super(calisanID, isim, soyisim);
	}
	
	@Override
	public String calis() {
		// TODO Auto-generated method stub
		return super.calis() + " Ýþ türü " + IsTuru.MUHASEBECI.getDeger();
	}
}
