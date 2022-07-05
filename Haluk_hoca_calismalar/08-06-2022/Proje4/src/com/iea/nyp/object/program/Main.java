package com.iea.nyp.object.program;

public class Main 
{

	public static void main(String[] args)
	{
		Calisan calisan1 = new Calisan();
		calisan1.calisanID = 555443;
		calisan1.isim = "Mahmut";
		calisan1.soyisim = "Bilir";
		
		Calisan calisan2 = new Calisan();
		calisan2.calisanID = 555444;
		calisan2.isim = "Sevim";
		calisan2.soyisim = "Caliskan";
		
		System.out.println( calisan1 );
		System.out.println("\n");
		System.out.println( calisan2 );
		
		System.out.println("\n");
		System.out.println( calisan1.calisanID );
		
		
		
		Calisan calisan;
	 	
	 	calisan = new Ogretmen();
	 	
	 	calisan = new Fizyoterapist();
	 	
	 	calisan = new Muhasebeci();
	 	
	 	System.out.println(calisan);
	}

}
