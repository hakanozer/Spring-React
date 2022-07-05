package com.iea.nyp.kalitim.program;

// Mudur bir Calisan'dýr.
public class Mudur extends Calisan
{
	public Mudur(int calisanID, String isim, String soyisim) 
	{
		super(calisanID, isim, soyisim);
	}
	
	@Override
	public String calis() {
		// TODO Auto-generated method stub
		return super.calis() + " Ýþ türü " + IsTuru.MUDUR.getDeger();
	}
}
