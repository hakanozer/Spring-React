package com.iea.nyp.kalitim.program;

// Mudur bir Calisan'd�r.
public class Mudur extends Calisan
{
	public Mudur(int calisanID, String isim, String soyisim) 
	{
		super(calisanID, isim, soyisim);
	}
	
	@Override
	public String calis() {
		// TODO Auto-generated method stub
		return super.calis() + " �� t�r� " + IsTuru.MUDUR.getDeger();
	}
}
