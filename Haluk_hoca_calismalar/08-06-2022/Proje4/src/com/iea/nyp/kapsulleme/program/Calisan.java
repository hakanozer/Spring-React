package com.iea.nyp.kapsulleme.program;

public class Calisan
{
	private static int VARSAYILAN_ID = 100000;
	private static final int ID_HANE = 6;

	private int calisanID;
	
	public String isim;
	
	public String soyisim;

	
	public Calisan(int calisanID, String isim, String soyisim) 
	{
		setCalisanID(calisanID);
		this.isim = isim;
		this.soyisim = soyisim;
	}

	public Calisan() {
		// TODO Auto-generated constructor stub
	}

	public int getCalisanID() 
	{
		return calisanID;
	}

	public void setCalisanID(int calisanID) 
	{	    
	    if (calisanID < 0) 
	    {
	        System.out.println("UYARI: Çalýþanýn ID'si negatif olamaz.");	  
	        if(this.calisanID == 0)
	        {
	        	this.calisanID = VARSAYILAN_ID++;
	        }
	    } 
	    else 
	    {
	    	if (String.valueOf(calisanID).length() != ID_HANE) 
	 	    {
	 	        System.out.println("UYARI: Çalýþanýn ID'si " + ID_HANE + " haneli olmalýdýr.");
	 	        if(this.calisanID == 0)
		        {
	 	        	this.calisanID = VARSAYILAN_ID++;
	 	        }
	 	    }
	    	else
	    	{
	    		this.calisanID = calisanID;
	    	}
	    }
	}

	@Override
	public String toString() {
		return "Calisan [calisanID=" + calisanID + ", isim=" + isim + ", soyisim=" + soyisim + "]";
	}
		
}
