package com.iea.nyp.kalitim.program;

// Muhasebeci bir Calisan'd�r.
public class Muhasebeci extends Calisan
{
	
	public Muhasebeci(int calisanID, String isim, String soyisim) 
	{
		super(calisanID, isim, soyisim);
	}
	
	@Override
	public String calis() {
		// TODO Auto-generated method stub
		return super.calis() + " �� t�r� " + IsTuru.MUHASEBECI.getDeger();
	}
}
