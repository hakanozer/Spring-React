package com.iea.cozum.program;

public class Calisan extends Object
{
	public int calisanID;
	public String ad;
	public String soyad;

	public Calisan(int calisanID, String ad, String soyad) 
	{
		super();
		this.calisanID = calisanID;
		this.ad = ad;
		this.soyad = soyad;
	}


	public Calisan(int calisanID) 
	{
		this.calisanID = calisanID;
	}
	
	
	public void isYap()
	{
		System.out.println("iþ yapýlýyor.");
	}
}
