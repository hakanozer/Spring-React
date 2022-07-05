package com.iea.nyp.kalitim.program; 

public class Calisan 
{
	public int calisanID;
	public String isim;
	public String soyisim;
	
	public Calisan(int calisanID, String isim, String soyisim) 
	{
		super();
		this.calisanID = calisanID;
		this.isim = isim;
		this.soyisim = soyisim;
	}

	public Calisan() {
		// TODO Auto-generated constructor stub
	}
	
	// ID'si ..., ad� ... ve soyad� ... olan �al��an i� yap�yor.
	public String calis()
	{
		return ozellikGoster() + "i� yap�yor.";
	}

	// ID'si ..., ad� ... ve soyad� ... olan �al��an mola verdi.
	public String molaVer()
	{
		return ozellikGoster() + "mola verdi.";
	}
	
	private String ozellikGoster() 
	{
		return "ID'si " + calisanID + ", ad� " + isim + ", soyad� " + soyisim + " olan ";
	}
}
