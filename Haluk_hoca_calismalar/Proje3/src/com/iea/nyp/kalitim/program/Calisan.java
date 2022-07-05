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
	
	// ID'si ..., adý ... ve soyadý ... olan çalýþan iþ yapýyor.
	public String calis()
	{
		return ozellikGoster() + "iþ yapýyor.";
	}

	// ID'si ..., adý ... ve soyadý ... olan çalýþan mola verdi.
	public String molaVer()
	{
		return ozellikGoster() + "mola verdi.";
	}
	
	private String ozellikGoster() 
	{
		return "ID'si " + calisanID + ", adý " + isim + ", soyadý " + soyisim + " olan ";
	}
}
