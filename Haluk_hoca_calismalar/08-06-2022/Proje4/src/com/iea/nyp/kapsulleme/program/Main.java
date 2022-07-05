package com.iea.nyp.kapsulleme.program;

public class Main 
{

	public static void main(String[] args) 
	{
	 	Calisan calisan1 = new Calisan();
	 	calisan1.setCalisanID(555443);
	 	calisan1.isim = "Mahmut";
	 	calisan1.soyisim = "Bilir";	 	
	 	System.out.println(calisan1);
	 	
	 	System.out.println("\n");
	 	
		Calisan calisan2 = new Calisan();
		calisan2.setCalisanID(555447);
	 	calisan2.isim = "Sevim";
	 	calisan2.soyisim = "Caliskan";	 	
	 	System.out.println(calisan2);
	 	
	 	System.out.println("\n");
	 	
		Calisan calisan3 = new Calisan();
		calisan3.setCalisanID(-555);
	 	calisan3.isim = "Hilmi";
	 	calisan3.soyisim = "Bulut";	 	
	 	System.out.println(calisan3);
	 	
	 	
	 	System.out.println("\n");
	 	
		Calisan calisan4 = new Calisan();
		calisan4.setCalisanID(5557);
		calisan4.isim = "Ayse";
	 	calisan4.soyisim = "Bilen";	 	
	 	System.out.println(calisan4);
	 	
	 	System.out.println("\n");
	 	
		Calisan calisan5 = new Calisan();
		calisan5.setCalisanID(-5557);
		calisan5.isim = "Temel";
		calisan5.soyisim = "Duman";	 	
	 	System.out.println(calisan5);
	 	
	 	System.out.println("\n");
	 	
		calisan1.setCalisanID(-55521);
		
		System.out.println(calisan1);
	}

}
